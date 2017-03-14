package com.tab.service.impl;

import com.tab.dao.tab.EvaluationDAO;
import com.tab.model.Evaluation;
import com.tab.service.EvaluationService;
import com.tab.service.QuestionService;
import com.tab.vo.EvaluationListVO;
import com.tab.vo.EvaluationVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/8 0008.
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationDAO evaluationDAO;
    @Autowired
    private QuestionService questionService;

    @Override
    public boolean add(EvaluationVO evaluationVO) {

        //添加市调，传入基本数据
        Evaluation evaluation = new Evaluation();
        evaluation.setTitle(evaluationVO.getTitle());
        evaluation.setStandard(evaluationVO.getStandard()); //评测规格
        evaluation.setAmount(evaluationVO.getAmount());
        evaluation.setDuration(evaluationVO.getDuration()); //评测周期
        evaluation.setStartDate(evaluationVO.getStartDate());
        evaluation.setEndDate(evaluationVO.getEndDate());
        evaluation.setShowDate(evaluationVO.getShowDate());
        evaluation.setProductId(evaluationVO.getProductId());
        evaluation.setVisible(evaluationVO.getVisible());
        evaluation.setVersion(1.0); //版本
        evaluation.setCreateTime(new Date());
        evaluation.setUpdateTime(new Date());

        try {
            //基本数据存库
            int evaluationID = evaluationDAO.insert(evaluation);

            String questionStr = "";
            String[] questions = evaluationVO.getQuestion();
            for (String str : questions) {
                //将问题存库，返回问题ID
                int questionID = questionService.addQuestion(str, evaluationID);
                questionStr += questionID + ",";
            }
            //统一更新问题ID到市调
            if (StringUtils.isNotEmpty(questionStr)) {
                evaluationDAO.updateQuestion(questionStr, evaluationID);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<EvaluationListVO> getList(int userID) {
        return evaluationDAO.getList(userID);
    }

    @Override
    public Evaluation getByID(int id) {
        return evaluationDAO.getByID(id);
    }

    @Override
    public List<EvaluationListVO> getListByManager() {
        return evaluationDAO.getListByManager();
    }

    @Override
    public List<EvaluationListVO> getListNoPass(int userID) {
        return evaluationDAO.getListNoPass(userID);
    }

    @Override
    public void updateEvaluation(String whereAmount, String whereTotalGrade, String whereExper, String whereAnswerScore, String whereJoinNum,int reportID) {
        evaluationDAO.updateEvaluation(whereAmount, whereTotalGrade, whereExper, whereAnswerScore, whereJoinNum,reportID);
    }

    public static void main(String[] args) {
        String questionStr = "";
        String[] str = new String[]{"aaaa", "bbbb", "ccccc"};
        for (String s : str) {
            questionStr += s + ",";
        }
        System.out.println(questionStr);

        String[] sp = questionStr.split(",");

        for (String s : sp) {
            System.out.println(s);
        }

    }
}
