package com.tab.dao.mocha;

import com.tab.model.UserMocha;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * Created by Administrator on 2017/3/3 0003.
 */
@DAO
public interface MochaUserDAO {

    /**
     * 根据抹茶ID获取用户名+头像
     *
     * @param id
     * @return
     */
    @SQL("SELECT UserName,PhotoURL FROM useraccount WHERE ID = :1 AND ISLocked = 0 LIMIT 1")
    UserMocha getByID(int id);

}
