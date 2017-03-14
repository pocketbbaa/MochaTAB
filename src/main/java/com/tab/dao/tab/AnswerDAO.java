package com.tab.dao.tab;

import com.tab.model.Answer;
import com.tab.vo.QAnswerVO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
@DAO
public interface AnswerDAO {

    /**
     private int id;
     private int questionID;  //问题ID
     private String answerStr; //回答
     private String picUrls; //图片
     private int userID;    //用户ID
     private int caseID;    //市调ID
     private int score; //得分
     private Date createTime; //创建时间
     */

    /**
     * 插入问题集合
     *
     * @param answers
     */
    @SQL("INSERT INTO answer " +
            "(QuestionID,AnswerStr,PicUrls,UserID,CaseID,Score,CreateTime) " +
            "VALUES (:1.questionID,:1.answerStr,:1.picUrls,:1.userID,:1.caseID,:1.score,NOW())")
    void insertList(List<Answer> answers);

    /**
     * 获取用户对市调小题的列表
     *
     * @param userID
     * @param caseID
     * @return
     */
    @SQL("SELECT q.`Id` AS questionID,q.`Des` AS questionDes,a.`ID` AS answerID,a.`AnswerStr` AS answerDes,a.`PicUrls` AS picUrls,a.`Score` AS score " +
            "FROM answer a,question q " +
            "WHERE a.`QuestionID` = q.`Id` " +
            "AND a.`UserID` = :1 AND a.CaseID = :2")
    List<QAnswerVO> getQAByUserIDAndCaseID(int userID, int caseID);

    @SQL("DELETE FROM answer WHERE UserID = :1 AND CaseID = :2")
    void deleteByUserIDAndCaseID(int userID, int caseID);
}
