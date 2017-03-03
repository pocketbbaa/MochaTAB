package com.tab.controllers;

import com.tab.model.User;
import com.tab.service.UserService;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Model;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/3/3 0003.
 */
@Path("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 登陆
     *
     * @param model
     * @param username
     * @param password
     * @param session
     * @return
     */
    @Post("/login")
    public String login(Model model, @Param("username") String username, @Param("password") String password, HttpSession session) {

        System.out.println("username:" + username + "  password:" + password);
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.add("message", "账号密码错误!");
            return "user/login_user";
        }
        Integer ID = userService.login(username, password);

        System.out.println("ID:" + ID);
        if (ID == null || ID == 0) {
            model.add("message", "账号密码错误!");
            return "user/login_user";
        }
        User user = userService.getByID(ID);
        if (user != null) {
            session.setAttribute("manager", user);
        }
        return "user/home_user";
    }


    /**
     * 添加用户
     *
     * @param model
     * @param mochaUserID
     * @param username
     * @param password
     * @return
     */
    @Post("/add")
    public String add(Model model, @Param("mochaUserID") String mochaUserID, @Param("username") String username, @Param("password") String password) {

        System.out.println("mochaUserID:" + mochaUserID + "  username:" + username + "  password:" + password);

        if (StringUtils.isEmpty(mochaUserID) || StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.add("message", "输入数据为空!");
            return "user/add_user";
        }
        Integer mochaID = Integer.parseInt(mochaUserID);
        if (mochaID == 0) {
            model.add("message", "用户ID不能为0！");
            return "user/add_user";
        }

        //mochaID是否存在
        if (userService.checkMochaUserID(mochaID)) {
            model.add("message", "该抹茶用户ID已存在!");
            return "user/add_user";
        }
        //用户登陆账号是否存在
        if (userService.checkTabUserName(username)) {
            model.add("message", "该账号已存在!");
            return "user/add_user";
        }
        boolean addSuccess = userService.add(mochaID, username, password);

        if (!addSuccess) {
            model.add("message", "添加用户异常!");
            return "user/add_user";
        }
        return "r:/user/list";
    }

    /**
     * 获取用户列表
     *
     * @param model
     * @return
     */
    @Get("/list")
    public String getList(Model model) {
        List<User> userList = userService.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        model.add("userList", userList);
        return "user/user_list";
    }

    /**
     * 删除用户
     *
     * @param model
     * @param id
     * @return
     */
    @Get("/delete/{id}")
    public String delete(Model model, @Param("id") Integer id) {

        if (id == null || id == 0) {
            return "r:/user/list";
        }
        boolean deleteSuccess = userService.deleteByID(id);
        if (!deleteSuccess) {
            return "r:/user/list";
        }
        return "r:/user/list";
    }

    /**
     * 安全退出
     *
     * @param session
     * @return
     */
    @Get("/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("user");
        return "r:/index.jsp";
    }

}
