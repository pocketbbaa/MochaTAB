package com.tab.service;

import com.tab.model.Answer;

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


}
