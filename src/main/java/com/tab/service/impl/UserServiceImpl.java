package com.tab.service.impl;

import com.tab.dao.mocha.MochaUserDAO;
import com.tab.dao.tab.UserDAO;
import com.tab.model.User;
import com.tab.model.UserData;
import com.tab.model.UserMocha;
import com.tab.service.UserService;
import com.tab.utils.Log4jUtil;
import com.tab.utils.PhotoUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/3 0003.
 */
@Service
public class UserServiceImpl implements UserService {


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
    public boolean addUserDate(UserData userData) {
        if (userData == null) {
            return false;
        }
        try {
            userDAO.addUserData(userData);
        } catch (Exception e) {
            e.printStackTrace();
            Log4jUtil.exception(e);
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
            user.setMochaUserPic(PhotoUtil.getDomainPic(user.getMochaUserPic()));
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
        User user = userDAO.getByID(id);
        user.setMochaUserPic(PhotoUtil.getDomainPic(user.getMochaUserPic()));
        return user;
    }

    @Override
    public UserData getUserDataByUserId(int userId) {
        return userDAO.getUserDataByUserID(userId);
    }

    @Override
    public boolean updateUserDate(UserData userData) {
        try{
            userDAO.updateUserDate(userData);
        }catch (Exception e){
            e.printStackTrace();
            Log4jUtil.exception(e);
            return false;
        }
        return true;
    }

    @Override
    public void updateDate(int userID, String sqlFileNum, String sqlFileScore, String sqlGetApplyNum, String sqlVoteNum) {

        userDAO.updateDate(userID,sqlFileNum,sqlFileScore,sqlGetApplyNum,sqlVoteNum);

    }


}
