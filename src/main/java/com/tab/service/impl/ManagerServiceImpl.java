package com.tab.service.impl;

import com.tab.dao.ManagerDAO;
import com.tab.model.Manager;
import com.tab.service.ManagerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/2/27 0027.
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDAO managerDAO;


    @Override
    public boolean add(Manager manager) {
        if (manager == null) {
            return false;
        }
        try {
            managerDAO.add(manager);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteByID(int ID) {
        if (ID == 0) {
            return false;
        }
        try {
            managerDAO.deleteByID(ID);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Manager> getList() {
        return managerDAO.getList();
    }

    @Override
    public boolean userExist(String username) {
        if (StringUtils.isEmpty(username)) {
            return false;
        }
        Integer ID = managerDAO.getIDbyUserName(username);
        if (ID == null || ID == 0) {
            return false;
        }
        return true;
    }
}
