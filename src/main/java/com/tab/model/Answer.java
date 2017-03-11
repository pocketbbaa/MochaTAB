package com.tab.model;

import java.util.Date;

/**
 * 小题目回答
 * Created by Administrator on 2017/3/10 0010.
 */
public class Answer {

    private int id;
    private int questionID;  //问题ID
    private String answerStr; //回答
    private String picUrls; //图片
    private int score; //得分
    private int userID;    //用户ID
    private int caseID;    //市调ID
    private Date createTime; //创建时间

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getAnswerStr() {
        return answerStr;
    }

    public void setAnswerStr(String answerStr) {
        this.answerStr = answerStr;
    }

    public String getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String picUrls) {
        this.picUrls = picUrls;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", questionID=" + questionID +
                ", answerStr='" + answerStr + '\'' +
                ", picUrls='" + picUrls + '\'' +
                ", score=" + score +
                ", userID=" + userID +
                ", caseID=" + caseID +
                ", createTime=" + createTime +
                '}';
    }
}
