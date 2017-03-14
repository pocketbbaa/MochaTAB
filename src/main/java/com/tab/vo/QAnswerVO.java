package com.tab.vo;

import com.tab.utils.FileUploadUtil;

/**
 * 问题回答vo
 * Created by Administrator on 2017/3/13 0013.
 */
public class QAnswerVO {

    private int questionID;
    private String questionDes;
    private int answerID;
    private String answerDes;
    private String picUrls;
    private int score;

    @Override
    public String toString() {
        return "QAnswerVO{" +
                "questionID=" + questionID +
                ", questionDes='" + questionDes + '\'' +
                ", answerID=" + answerID +
                ", answerDes='" + answerDes + '\'' +
                ", picUrls='" + picUrls + '\'' +
                ", score=" + score +
                '}';
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestionDes() {
        return questionDes;
    }

    public void setQuestionDes(String questionDes) {
        this.questionDes = questionDes;
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public String getAnswerDes() {
        return answerDes;
    }

    public void setAnswerDes(String answerDes) {
        this.answerDes = answerDes;
    }

    public String getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String picUrls) {
        this.picUrls = FileUploadUtil.getDomainPic(picUrls);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
