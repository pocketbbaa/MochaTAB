package com.tab.model;

/**
 * 市调专案
 * Created by Administrator on 2017/3/6 0006.
 */
public class Evaluation extends EvaluationBase{


    private int resAmount; //市调成员回复心得数

    private int votePercent; //投票率
    private int item1amount; //满意度为很好的人数
    private int item2amount; //满意度为好的人数
    private int item3amount; //满意度为普通的人数
    private int item4amount; //满意度为差的人数
    private int item5amount; //满意度为很差的人数

    private int item1grade; //滿意度为很好的加權后分數
    private int item2grade; //滿意度為好的加權後分數
    private int item3grade; //滿意度為普通的加權後分數
    private int item4grade; //滿意度為差的加權後分數
    private int item5grade; //滿意度為很差的加權後分數

    private int totalGrade; //滿意度總分

    private int item1Apercent; // 選擇滿意度為很好的比例
    private int item2Apercent; // 選擇滿意度為好的比例
    private int item3Apercent; // 選擇滿意度為普通的比例
    private int item4Apercent; // 選擇滿意度為差的比例
    private int item5Apercent; // 選擇滿意度為很差的比例

    private String question; //小题目

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getResAmount() {
        return resAmount;
    }

    public void setResAmount(int resAmount) {
        this.resAmount = resAmount;
    }

    public int getVotePercent() {
        return votePercent;
    }

    public void setVotePercent(int votePercent) {
        this.votePercent = votePercent;
    }

    public int getItem1amount() {
        return item1amount;
    }

    public void setItem1amount(int item1amount) {
        this.item1amount = item1amount;
    }

    public int getItem2amount() {
        return item2amount;
    }

    public void setItem2amount(int item2amount) {
        this.item2amount = item2amount;
    }

    public int getItem3amount() {
        return item3amount;
    }

    public void setItem3amount(int item3amount) {
        this.item3amount = item3amount;
    }

    public int getItem4amount() {
        return item4amount;
    }

    public void setItem4amount(int item4amount) {
        this.item4amount = item4amount;
    }

    public int getItem5amount() {
        return item5amount;
    }

    public void setItem5amount(int item5amount) {
        this.item5amount = item5amount;
    }

    public int getItem1grade() {
        return item1grade;
    }

    public void setItem1grade(int item1grade) {
        this.item1grade = item1grade;
    }

    public int getItem2grade() {
        return item2grade;
    }

    public void setItem2grade(int item2grade) {
        this.item2grade = item2grade;
    }

    public int getItem3grade() {
        return item3grade;
    }

    public void setItem3grade(int item3grade) {
        this.item3grade = item3grade;
    }

    public int getItem4grade() {
        return item4grade;
    }

    public void setItem4grade(int item4grade) {
        this.item4grade = item4grade;
    }

    public int getItem5grade() {
        return item5grade;
    }

    public void setItem5grade(int item5grade) {
        this.item5grade = item5grade;
    }

    public int getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(int totalGrade) {
        this.totalGrade = totalGrade;
    }

    public int getItem1Apercent() {
        return item1Apercent;
    }

    public void setItem1Apercent(int item1Apercent) {
        this.item1Apercent = item1Apercent;
    }

    public int getItem2Apercent() {
        return item2Apercent;
    }

    public void setItem2Apercent(int item2Apercent) {
        this.item2Apercent = item2Apercent;
    }

    public int getItem3Apercent() {
        return item3Apercent;
    }

    public void setItem3Apercent(int item3Apercent) {
        this.item3Apercent = item3Apercent;
    }

    public int getItem4Apercent() {
        return item4Apercent;
    }

    public void setItem4Apercent(int item4Apercent) {
        this.item4Apercent = item4Apercent;
    }

    public int getItem5Apercent() {
        return item5Apercent;
    }

    public void setItem5Apercent(int item5Apercent) {
        this.item5Apercent = item5Apercent;
    }
}
