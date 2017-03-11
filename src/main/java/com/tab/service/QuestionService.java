package com.tab.service;

import com.tab.model.Question;

import java.util.List;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public interface QuestionService {

    /**
     * 添加问题
     *
     * @param des
     * @param caseID
     * @return
     */
    int addQuestion(String des, int caseID);

    /**
     * 根据IDs获取问题
     *
     * @param IDs
     * @return
     */
    List<Question> getQuestionByIDs(List<Integer> IDs);
}
