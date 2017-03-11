package com.tab.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class Question {

    private int id;
    private int caseID;
    private String des;
    private Date createTime;


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", caseID=" + caseID +
                ", des='" + des + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
