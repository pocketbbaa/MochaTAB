package com.tab.service.impl;

import com.tab.dao.mocha.MochaUserDAO;
import com.tab.dao.tab.UserDAO;
import com.tab.model.User;
import com.tab.model.UserMocha;
import com.tab.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/3 0003.
 */
@Service
public class UserServiceImpl implements UserService {

    /***
     * 抹茶商品图片前缀(阿里)
     */
    private static final String URL_MOCHA_IMAGE_ALI_PFEFIX = "https://img.immocha.com";
    /***
     * 抹茶商品图片前缀(阿里)
     */
    private static final String URL_MOCHA_IMAGE_ALI_PFEFIX_1 = "https://img.immocha.com/";

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private MochaUserDAO mochaUserDAO;

    @Override
    public boolean add(Integer mochaUserID, String username, String password) {

        //根据mochaUserID获取用户抹茶信息
        UserMocha userMocha = mochaUserDAO.getByID(mochaUserID);
        if (userMocha == null) {
            return false;
        }
        //组装数据存user表
        User user = new User();
        user.setMochaID(mochaUserID);
        user.setMochaUserName(userMocha.getUserName());
        user.setMochaUserPic(userMocha.getPhotoURL());
        user.setTabUserName(username);
        user.setTabPassWord(password);
        try {
            userDAO.add(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkMochaUserID(Integer mochaUserID) {

        Integer ID = userDAO.getIDBymochaUserID(mochaUserID);
        if (ID == null || ID == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkTabUserName(String username) {

        Integer ID = userDAO.getIDByTabUserName(username);
        if (ID == null || ID == 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = userDAO.getUserList();
        for (User user : userList) {
            user.setMochaUserPic(getDomainPic(user.getMochaUserPic()));
        }
        return userList;
    }

    @Override
    public boolean deleteByID(int id) {
        try {
            userDAO.deleteByID(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Integer login(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }

    @Override
    public User getByID(int id) {
        return userDAO.getByID(id);
    }

    /***
     * 通过图片的URI, 得到包含域名的完整URL路径;
     */
    public static final String getDomainPic(String picURL) {
        picURL = picURL.trim();
        if (StringUtils.startsWithIgnoreCase(picURL, "http")) {
            return picURL;
        }
        return buildAliURL(picURL);
    }

    /**
     * 合成Ali图片链接
     */
    public static String buildAliURL(String path) {
        if (StringUtils.isBlank(path)) {
            return path;
        }
        if (path.startsWith("/")) {
            return URL_MOCHA_IMAGE_ALI_PFEFIX + path;
        } else {
            return URL_MOCHA_IMAGE_ALI_PFEFIX_1 + path;
        }
    }
}
