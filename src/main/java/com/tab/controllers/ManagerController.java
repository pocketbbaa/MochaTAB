package com.tab.controllers;


import com.tab.model.Manager;
import com.tab.service.ManagerService;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Model;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/2/27 0027.
 */
@Path("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;


    /**
     * 获取管理员列表(除去超级管理员)
     *
     * @param model
     * @return
     */
    @Get("/list")
    public String getManagerList(Model model) {

        List<Manager> managerList = managerService.getList();
        if (CollectionUtils.isEmpty(managerList)) {
            return "managers";
        }
        model.add("managerList", managerList);

        return "managers";
    }

    /**
     * 添加管理员
     *
     * @param model
     * @param username
     * @param password
     * @return
     */
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

    /**
     * 删除管理员
     *
     * @param model
     * @param id
     * @return
     */
    @Get("/delete/{id}")
    public String delete(Model model, @Param("id") int id) {

        if (managerService.deleteByID(id)) {
            return "managers";
        }
        model.add("message", "用户异常，稍后重试");
        return "managers";
    }

}
