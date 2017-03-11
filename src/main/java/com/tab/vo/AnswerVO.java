package com.tab.vo;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public class AnswerVO {

    private int questionID;  //问题ID
    private String answerStr; //回答

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

    @Override
    public String toString() {
        return "AnswerVO{" +
                "questionID=" + questionID +
                ", answerStr='" + answerStr + '\'' +
                '}';
    }
}
