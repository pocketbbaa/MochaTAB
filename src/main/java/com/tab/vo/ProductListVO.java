package com.tab.vo;

import com.tab.utils.FileUploadUtil;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/8 0008.
 */
public class ProductListVO {


    private int id;
    private String name;
    private String picUrl;
    private double price;
    private String skinName;
    private int ismarket;
    private int likeNum;
    private String lastEditer;
    private Date lastEditerTime;
    private String function;
    private String attention;

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = FileUploadUtil.getDomainPic(picUrl);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSkinName() {
        return skinName;
    }

    public void setSkinName(String skinName) {
        this.skinName = skinName;
    }

    public int getIsmarket() {
        return ismarket;
    }

    public void setIsmarket(int ismarket) {
        this.ismarket = ismarket;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getLastEditer() {
        return lastEditer;
    }

    public void setLastEditer(String lastEditer) {
        this.lastEditer = lastEditer;
    }

    public Date getLastEditerTime() {
        return lastEditerTime;
    }

    public void setLastEditerTime(Date lastEditerTime) {
        this.lastEditerTime = lastEditerTime;
    }

    @Override
    public String toString() {
        return "ProductListVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", price=" + price +
                ", skinName='" + skinName + '\'' +
                ", ismarket=" + ismarket +
                ", likeNum=" + likeNum +
                ", lastEditer='" + lastEditer + '\'' +
                ", lastEditerTime=" + lastEditerTime +
                '}';
    }
}
