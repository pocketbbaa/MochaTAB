package com.tab.vo;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class ReportVO {

    private int evaluate; //评价 1:很好，2：好，3：普通，4：差，5：很差
    private int[] questionIDs; //问题ID
    private String[] answers;  //回答
    private int[] score; //得分

    private String experience; //心得
    private int productID; //商品ID
    private int userID; //用户ID
    private int evaluationID;//市调专案ID

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getEvaluationID() {
        return evaluationID;
    }

    public void setEvaluationID(int evaluationID) {
        this.evaluationID = evaluationID;
    }

    public int getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(int evaluate) {
        this.evaluate = evaluate;
    }


    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }


    public int[] getQuestionIDs() {
        return questionIDs;
    }

    public void setQuestionIDs(int[] questionIDs) {
        this.questionIDs = questionIDs;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "ReportVO{" +
                "evaluate=" + evaluate +
                ", questionIDs=" + Arrays.toString(questionIDs) +
                ", answers=" + Arrays.toString(answers) +
                ", score=" + Arrays.toString(score) +
                ", experience='" + experience + '\'' +
                ", productID=" + productID +
                ", userID=" + userID +
                ", evaluationID=" + evaluationID +
                '}';
    }
}
