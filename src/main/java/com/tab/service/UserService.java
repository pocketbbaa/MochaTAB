package com.tab.service;

import com.tab.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/3/3 0003.
 */
public interface UserService {

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    boolean add(Integer mochaUserID, String username, String password);

    /**
     * 判断抹茶ID是否存在
     *
     * @param mochaUserIDs
     * @return
     */
    boolean checkMochaUserID(Integer mochaUserIDs);

    /**
     * 判断用户登陆账户是否存在
     *
     * @param username
     * @return
     */
    boolean checkTabUserName(String username);

    /**
     * 获取用户列表
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 根据ID删除用户
     *
     * @param id
     * @return
     */
    boolean deleteByID(int id);

    /**
     * 根据用户名密码查询用户ID
     *
     * @param username
     * @param password
     * @return
     */
    Integer login(String username, String password);

    /**
     * 根据ID获取用户对象
     *
     * @param id
     * @return
     */
    User getByID(int id);
}
