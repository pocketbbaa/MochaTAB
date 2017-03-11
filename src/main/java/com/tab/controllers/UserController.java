package com.tab.controllers;

import com.tab.model.User;
import com.tab.model.UserData;
import com.tab.service.UserService;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Model;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.Date;
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
            session.setAttribute("user", user);
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
    @ValidateLogin
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
    @ValidateLogin
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
    @ValidateLogin
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
    @ValidateLogin
    @Get("/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("user");
        return "r:/index.jsp";
    }


    @Get("/info")
    public String getUserDataInfo(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int userID = user.getId();

        //根据用户ID获取userData信息
        UserData userData = userService.getUserDataByUserId(userID);
        if (userData == null) {
            return "user/edit_user";
        }
        model.add("userData", userData);
        return "user/user_info";
    }


    /**
     * 提交用户信息修改
     *
     * @param model
     * @param userData
     * @param session
     * @return
     */
    @ValidateLogin
    @Post("/data")
    public String updateData(Model model, UserData userData, HttpSession session) {

        if (userData == null) {
            model.add("message", "输入信息有误userData == null");
            return "r:/user/info";
        }
        User user = (User) session.getAttribute("user");
        int userID = user.getId();
        String nickName = user.getMochaUserName();

        userData.setUserID(userID);
        userData.setNickName(nickName);
        userData.setLastFileUpdateTime(new Date());
        userData.setLastJoinTime(new Date());
        userData.setCreateTime(new Date());

        boolean success = userService.addUserDate(userData);
        if (success) {
            model.add("message", "添加成功");
            return "r:/user/info";
        }
        model.add("message", "添加失败!");
        return "r:/user/info";
    }

    /**
     * 跟新用户信息
     *
     * @param model
     * @param userData
     * @param session
     * @return
     */
    @ValidateLogin
    @Post("/data/update")
    public String updateUserData(Model model, UserData userData, HttpSession session) {
        if (userData == null) {
            model.add("message", "输入信息有误userData == null");
            return "r:/user/info";
        }
        User user = (User) session.getAttribute("user");
        int userID = user.getId();
        userData.setUserID(userID);
        boolean success = userService.updateUserDate(userData);
        if (success) {
            model.add("message", "修改成功");
            return "r:/user/info";
        }
        model.add("message", "修改失败!");
        return "r:/user/info";
    }

}
