package com.tab.controllers;


import com.tab.model.Manager;
import com.tab.service.ManagerService;
import com.tab.utils.Log4jUtil;
import com.tab.utils.Threads;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Model;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/2/27 0027.
 */
@Path("/edit")
public class ManagerController {


    private Logger webLog = Log4jUtil.webLog;

    @Autowired
    private ManagerService managerService;

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

        webLog.info(Threads.getCallLocation() + ", edit/login-> username:" + username + "  password:" + password);

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.add("message", "账号密码错误!");
            return "edit/login_manager";
        }
        Integer ID = managerService.login(username, password);

        webLog.info(Threads.getCallLocation() + ", edit/login->UserID:" + ID);
        System.out.println("ID:" + ID);
        if (ID == null || ID == 0) {
            model.add("message", "账号密码错误!");
            return "edit/login_manager";
        }
        Manager manager = managerService.getByID(ID);
        if (manager != null) {
            session.setAttribute("user", manager);
        }
        return "edit/home_manager";
    }


    /**
     * 获取管理员列表(除去超级管理员)
     *
     * @param model
     * @return
     */
    @ValidateLogin
    @Get("/list")
    public String getManagerList(Model model) {
        webLog.info(Threads.getCallLocation() + ", edit/list-> in getManagerList....");
        List<Manager> managerList = managerService.getList();
        if (CollectionUtils.isEmpty(managerList)) {
            webLog.info(Threads.getCallLocation() + ", edit/list-> getManagerList -> managerList is null or size = 0");
            return "edit/managers";
        }
        model.add("managerList", managerList);

        return "edit/managers";
    }

    /**
     * 添加管理员
     *
     * @param model
     * @param username
     * @param password
     * @return
     */
    @ValidateLogin
    @Post("/add")
    public String add(Model model, @Param("username") String username, @Param("password") String password) {

        webLog.info(Threads.getCallLocation() + ", edit/add-> username:" + username + "  password:" + password);
        String message = "输入信息有误";
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            webLog.info(Threads.getCallLocation() + ", edit/add-> username or password is null or size = 0");
            model.add("message", message);
            return "r:/edit/list";
        }
        if (managerService.userExist(username)) {
            webLog.info(Threads.getCallLocation() + ", edit/add-> username is exist ...");
            message = "用户名已存在";
            model.add("message", message);
            return "r:/edit/list";
        }

        Manager manager = new Manager();
        manager.setUsername(username);
        manager.setPassword(password);
        manager.setRole(2);
        manager.setCreateTime(new Date());
        if (managerService.add(manager)) {
            webLog.info(Threads.getCallLocation() + ", edit/add-> add manager success ...");
            message = "添加成功!";
            model.add("message", message);
            return "r:/edit/list";
        }
        model.add("message", message);
        return "r:/edit/list";
    }

    /**
     * 删除管理员
     *
     * @param model
     * @param id
     * @return
     */
    @ValidateLogin
    @Get("/delete/{id}")
    public String delete(Model model, @Param("id") int id) {
        webLog.info(Threads.getCallLocation() + ", edit/delete-> id = " + id);
        if (managerService.deleteByID(id)) {
            webLog.info(Threads.getCallLocation() + ", edit/delete-> id = " + id + " delete success!");
            return "r:/edit/list";
        }
        model.add("message", "用户异常，稍后重试");
        return "r:/edit/list";
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
        webLog.info(Threads.getCallLocation() + ", edit/exit ... success ");
        session.removeAttribute("user");
        return "r:/index.jsp";
    }

}
