package com.tab.dao;

import com.tab.model.Manager;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import java.util.List;

/**
 * 管理员操作
 * <p>
 * Created by wangyang on 2017/2/27 0027.
 */
@DAO
public interface ManagerDAO {

    /**
     * 添加管理员
     *
     * @param manager
     */
    @SQL("INSERT INTO administrator " +
            "(UserName,PASSWORD,Role,CreateTime) " +
            "VALUES (:1.username,:1.password,:1.role,:1.createTime);")
    void add(Manager manager);

    /**
     * 删除管理员
     *
     * @param ID
     */
    @SQL("DELETE FROM administrator WHERE ID = :1")
    void deleteByID(int ID);

    /**
     * 获取管理员列表
     *
     * @return
     */
    @SQL("SELECT ID,UserName,PASSWORD,Role,CreateTime FROM administrator WHERE Role <> 1")
    List<Manager> getList();

    /**
     * 根据用户名查询用户是否存在
     *
     * @param username
     * @return
     */
    @SQL("SELECT ID FROM administrator WHERE username = :1")
    Integer getIDbyUserName(String username);


}
