package com.tab.service;

import com.tab.model.Answer;
import com.tab.vo.QAnswerVO;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public interface AnswerService {

    /**
     * 添加回答集合
     * @param answerList
     * @return
     */
    boolean addList(List<Answer> answerList);

    /**
     * 根据用户ID市调ID获取题目详情和回答
     * @param userID
     * @param caseID
     * @return
     */
    List<QAnswerVO> getQAByUserIDAndCaseID(int userID, int caseID);

    /**
     * 删除回答
     * @param userID
     * @param caseID
     */
    void deleteByUserIDAndCaseID(int userID, int caseID);
}
