package com.tab.controllers;


import com.tab.model.Manager;
import com.tab.service.ManagerService;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Model;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Administrator on 2017/2/27 0027.
 */
@Path("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Post("/add")
    public String add(Model model, @Param("username") String username, @Param("password") String password) {

        String message = "输入信息有误";
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.add("message", message);
            return "manager_add_success";
        }
        if (managerService.userExist(username)) {
            message = "用户名已存在";
            model.add("message", message);
            return "manager_add";
        }

        Manager manager = new Manager();
        manager.setUsername(username);
        manager.setPassword(password);
        manager.setRole(2);
        manager.setCreateTime(new Date());
        if (managerService.add(manager)) {
            message = "添加成功!";
            model.add("message", message);
            return "manager_add_success";
        }
        model.add("message", message);
        return "manager_add_success";
    }

}
