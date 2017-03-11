package com.tab.service.impl;

import com.tab.dao.tab.AnswerDAO;
import com.tab.model.Answer;
import com.tab.service.AnswerService;
import com.tab.utils.Log4jUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDAO answerDAO;

    @Override
    public boolean addList(List<Answer> answerList) {

        if (CollectionUtils.isEmpty(answerList)) {
            return false;
        }
        try {
            answerDAO.insertList(answerList);
        } catch (Exception e) {
            e.printStackTrace();
            Log4jUtil.exception(e);
            return false;
        }
        return true;
    }
}
