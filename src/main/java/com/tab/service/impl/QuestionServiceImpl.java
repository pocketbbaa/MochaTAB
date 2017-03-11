package com.tab.service.impl;

import com.tab.dao.tab.QuestionDAO;
import com.tab.model.Question;
import com.tab.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDAO questionDAO;

    @Override
    public int addQuestion(String des, int caseID) {
        return questionDAO.insert(des, caseID);
    }

    @Override
    public List<Question> getQuestionByIDs(List<Integer> IDs) {
        return questionDAO.getQuestionByIDs(IDs);
    }
}
