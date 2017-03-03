package com.tab.dao.tab;

import com.tab.model.User;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import java.util.List;

/**
 * Created by Administrator on 2017/3/3 0003.
 */
@DAO
public interface UserDAO {

    /**
     * 添加用户
     *
     * @param user
     */
    @SQL("INSERT INTO USER " +
            "(MochaUserID,MochaUserName,MochaUserPic,TabUserName,TabPassWord,CreateTime) " +
            "VALUES (:1.mochaID,:1.mochaUserName,:1.mochaUserPic,:1.tabUserName,:1.tabPassWord,NOW());")
    void add(User user);

    /**
     * 校验MochauserID是否存在
     *
     * @param id
     * @return
     */
    @SQL("SELECT ID FROM USER WHERE MochauserID = :1 LIMIT 1")
    Integer getIDBymochaUserID(int id);

    /**
     * 校验TabUserName是否存在
     *
     * @param username
     * @return
     */
    @SQL("SELECT ID FROM USER WHERE TabUserName = :1 LIMIT 1")
    Integer getIDByTabUserName(String username);

    /**
     * 获取用户列表
     *
     * @return
     */
    @SQL("SELECT ID,MochaUserID as mochaID,MochaUserName,MochaUserPic,TabUserName,TabPassWord,CreateTime FROM USER")
    List<User> getUserList();

    /**
     * 根据ID删除用户
     *
     * @param id
     */
    @SQL("DELETE FROM USER WHERE ID = :1")
    void deleteByID(int id);

    @SQL("SELECT ID FROM USER WHERE TabUserName = :1 AND TabPassWord = :2 LIMIT 1")
    Integer getByUsernameAndPassword(String username, String password);

    @SQL("SELECT ID,MochaUserID as mochaID,MochaUserName,MochaUserPic,TabUserName,TabPassWord,CreateTime FROM USER WHERE ID = :1")
    User getByID(int id);

}
