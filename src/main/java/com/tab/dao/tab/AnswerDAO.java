package com.tab.dao.tab;

import com.tab.model.Answer;
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
     * @param answers
     */
    @SQL("INSERT INTO answer " +
            "(QuestionID,AnswerStr,PicUrls,UserID,CaseID,Score,CreateTime) " +
            "VALUES (:1.questionID,:1.answerStr,:1.picUrls,:1.userID,:1.caseID,:1.score,NOW())")
    void insertList(List<Answer> answers);
}
