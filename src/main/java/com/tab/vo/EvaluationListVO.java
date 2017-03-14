package com.tab.vo;

import com.tab.utils.FileUploadUtil;

import java.util.Date;

/**
 * 市调专题列表VO
 * Created by Administrator on 2017/3/8 0008.
 */
public class EvaluationListVO {

    private int id; //市调专题ID
    private String picURL; //商品图片
    private String title;
    private Date startDate;
    private Date EndDate;
    private Date createTime;
    private int productId;

    private int pass; //是否通过审核
    private String noPassStr;

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String getNoPassStr() {
        return noPassStr;
    }

    public void setNoPassStr(String noPassStr) {
        this.noPassStr = noPassStr;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = FileUploadUtil.getDomainPic(picURL);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "EvaluationListVO{" +
                "id=" + id +
                ", picURL='" + picURL + '\'' +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", EndDate=" + EndDate +
                ", createTime=" + createTime +
                ", productId=" + productId +
                ", pass=" + pass +
                ", noPassStr='" + noPassStr + '\'' +
                '}';
    }
}
