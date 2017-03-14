package com.tab.service.impl;

import com.tab.dao.tab.ReportDAO;
import com.tab.enums.SatisfyScoreEnum;
import com.tab.model.Evaluation;
import com.tab.model.Report;
import com.tab.service.AnswerService;
import com.tab.service.EvaluationService;
import com.tab.service.ReportService;
import com.tab.service.UserService;
import com.tab.utils.Log4jUtil;
import com.tab.vo.QAnswerVO;
import com.tab.vo.ReportListVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDAO reportDAO;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private UserService userService;

    @Override
    public boolean add(Report report) {
        try {
            reportDAO.insert(report);
        } catch (Exception e) {
            e.printStackTrace();
            Log4jUtil.exception(e);
            return false;
        }
        return true;
    }

    @Override
    public List<ReportListVO> getReportListVO() {
        return reportDAO.getReportListVO();
    }

    @Override
    public Report getByID(int reportID) {
        return reportDAO.getByID(reportID);
    }

    @Override
    public void updatePass(int reportID, int pass) {
        reportDAO.updatePass(reportID, pass);
    }

    @Override
    public void updateNoPassStr(int reportID, String reason) {
        reportDAO.updateNoPassStr(reportID, reason);
    }

    @Override
    public int getIDByCaseIDAndUserID(int caseID, int userID) {
        Integer id = reportDAO.getIDByCaseIDAndUserID(caseID, userID);
        if (id != null && id != 0) {
            return id;
        }
        return 0;
    }

    @Override
    public void deleteReportById(int reportId) {
        reportDAO.deleteReportById(reportId);
    }

    @Override
    public boolean updateEvalutionData(Report report) {

        try {
            //获取市调详情,根据市调详情算分
            int totalGrade = 0;

            //1、满意度算分1:很好，2：好，3：普通，4：差，5：很差 更新满意度人数、得分
            String whereAmount = "";
            String whereTotalGrade = "";
            int evaluate = report.getEvaluate();
            switch (evaluate) {
                case 1:
                    totalGrade = SatisfyScoreEnum.VERY_GOOD.getState();
                    whereAmount = "Item1amount = Item1amount+1";
                    break;
                case 2:
                    totalGrade = SatisfyScoreEnum.GOOD.getState();
                    whereAmount = "Item2amount = Item2amount+1";
                    break;
                case 3:
                    totalGrade = SatisfyScoreEnum.NORMAL.getState();
                    whereAmount = "Item3amount = Item3amount+1";
                    break;
                case 4:
                    totalGrade = SatisfyScoreEnum.BAD.getState();
                    whereAmount = "Item4amount = Item4amount+1";
                    break;
                case 5:
                    totalGrade = SatisfyScoreEnum.VERY_BAD.getState();
                    whereAmount = "Item5amount = Item5amount+1";
                    break;
            }
            whereTotalGrade = "TotalGrade = TotalGrade+" + totalGrade; //总满意度分

            //3、如果心得不为空，心得数+1
            String experience = report.getExperience();
            String whereExper = "";
            if (StringUtils.isNotEmpty(experience)) {
                whereExper = "ResAmount = ResAmount+1";
            }

            //4、获取小题目平均分，更新小题目得分总和
            int userID = report.getUserId();
            int caseID = report.getEvaluationId();
            String whereAnswerScore = "";
            List<QAnswerVO> qAnswerVOList = answerService.getQAByUserIDAndCaseID(userID, caseID);
            if (!CollectionUtils.isEmpty(qAnswerVOList)) {
                int totalScore = 0;
                for (QAnswerVO answer : qAnswerVOList) {
                    totalScore += answer.getScore();
                }
                double avgScore = totalScore / qAnswerVOList.size(); //取单个人的平均分
                avgScore = avgScore * 1.1; //权重系数
                whereAnswerScore = "TotalAnswerScore = TotalAnswerScore+" + (int)avgScore;
            }
            //5、总参与人数+1 JoinNum
            String whereJoinNum = "JoinNum = JoinNum+1";
            evaluationService.updateEvaluation(whereAmount, whereTotalGrade, whereExper, whereAnswerScore, whereJoinNum, caseID);

            //6、个人FileNum 报告总数+1
            String sqlFileNum = "FileNum = FileNum+1";
            //7、个人FileScore 报告总分累加
            String sqlFileScore = "FileScore = FileScore+" + totalGrade;
            //8、个人GetApplyNum 市调商品数+1
            String sqlGetApplyNum = "GetApplyNum = GetApplyNum + 1";
            //9、个人VoteNum 投票总数+1
            String sqlVoteNum = "VoteNum = VoteNum+1";

            userService.updateDate(userID, sqlFileNum, sqlFileScore, sqlGetApplyNum, sqlVoteNum);
        } catch (Exception e) {
            e.printStackTrace();
            Log4jUtil.exception(e);
            return false;
        }
        return true;
    }
}
