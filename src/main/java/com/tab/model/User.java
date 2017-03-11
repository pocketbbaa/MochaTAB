package com.tab.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/3 0003.
 */
public class User {

    private int id;
    private int mochaID; //抹茶ID
    private String mochaUserName; //抹茶用户名
    private String mochaUserPic;  //抹茶头像
    private String tabUserName;   //tab登陆用户名
    private String tabPassWord;   //tab登陆密码
    private Date createTime;      //创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMochaID() {
        return mochaID;
    }

    public void setMochaID(int mochaID) {
        this.mochaID = mochaID;
    }

    public String getMochaUserName() {
        return mochaUserName;
    }

    public void setMochaUserName(String mochaUserName) {
        this.mochaUserName = mochaUserName;
    }

    public String getMochaUserPic() {
        return mochaUserPic;
    }

    public void setMochaUserPic(String mochaUserPic) {
        this.mochaUserPic = mochaUserPic;
    }

    public String getTabUserName() {
        return tabUserName;
    }

    public void setTabUserName(String tabUserName) {
        this.tabUserName = tabUserName;
    }

    public String getTabPassWord() {
        return tabPassWord;
    }

    public void setTabPassWord(String tabPassWord) {
        this.tabPassWord = tabPassWord;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mochaID=" + mochaID +
                ", mochaUserName='" + mochaUserName + '\'' +
                ", mochaUserPic='" + mochaUserPic + '\'' +
                ", tabUserName='" + tabUserName + '\'' +
                ", tabPassWord='" + tabPassWord + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
