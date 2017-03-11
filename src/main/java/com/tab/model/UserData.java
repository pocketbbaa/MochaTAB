package com.tab.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public class UserData {

    private int id;
    private int userID;
    private String name; //真实姓名
    private String nickName; //使用抹茶用户名
    private String phone; //电话号码

    private String postCode; //邮编

    private int six; //性别 1：男 0：女
    private String address; //详细住址
    private int applyNum; //申请中的市调商品数
    private Date birthday; //生日

    private int bodySkin; //身体肌肤
    private String city; //居住城市
    private String email; //邮件地址
    private int emailPublic; //是否公开邮件 1：是 0：否

    private int hairSkin; //发质
    private int faceSkin; //脸部肌肤
    private int wholeSkin; //整体肤质
    private String faceDescribe; //脸部肌肤描述

    private int fileLevel;//报告等级
    private int fileNum; //报告数量
    private int fileScore; //报告总分
    private int getApplyNum; //获取申请的市调商品数

    private int married; //是否结婚 1：是  0：否
    private int haveChildren;//是否有子女 1:是 0：否
    private int height; //身高cm
    private int weight; //g

    private int job; //工作ID
    private int lastFileStat; //最后回文状态  1:OK

    private Date lastFileUpdateTime; //最后回文时间
    private Date lastJoinTime; //最后获取参与市调时间

    private int voteNum; //投票总数
    private int status; //账号状态 1:ok 0:异常
    private String remark; //备注
    private Date createTime; //创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public int getSix() {
        return six;
    }

    public void setSix(int six) {
        this.six = six;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(int applyNum) {
        this.applyNum = applyNum;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getBodySkin() {
        return bodySkin;
    }

    public void setBodySkin(int bodySkin) {
        this.bodySkin = bodySkin;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmailPublic() {
        return emailPublic;
    }

    public void setEmailPublic(int emailPublic) {
        this.emailPublic = emailPublic;
    }

    public int getHairSkin() {
        return hairSkin;
    }

    public void setHairSkin(int hairSkin) {
        this.hairSkin = hairSkin;
    }

    public int getFaceSkin() {
        return faceSkin;
    }

    public void setFaceSkin(int faceSkin) {
        this.faceSkin = faceSkin;
    }

    public int getWholeSkin() {
        return wholeSkin;
    }

    public void setWholeSkin(int wholeSkin) {
        this.wholeSkin = wholeSkin;
    }

    public String getFaceDescribe() {
        return faceDescribe;
    }

    public void setFaceDescribe(String faceDescribe) {
        this.faceDescribe = faceDescribe;
    }

    public int getFileLevel() {
        return fileLevel;
    }

    public void setFileLevel(int fileLevel) {
        this.fileLevel = fileLevel;
    }

    public int getFileNum() {
        return fileNum;
    }

    public void setFileNum(int fileNum) {
        this.fileNum = fileNum;
    }

    public int getFileScore() {
        return fileScore;
    }

    public void setFileScore(int fileScore) {
        this.fileScore = fileScore;
    }

    public int getGetApplyNum() {
        return getApplyNum;
    }

    public void setGetApplyNum(int getApplyNum) {
        this.getApplyNum = getApplyNum;
    }

    public int getMarried() {
        return married;
    }

    public void setMarried(int married) {
        this.married = married;
    }

    public int getHaveChildren() {
        return haveChildren;
    }

    public void setHaveChildren(int haveChildren) {
        this.haveChildren = haveChildren;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public int getLastFileStat() {
        return lastFileStat;
    }

    public void setLastFileStat(int lastFileStat) {
        this.lastFileStat = lastFileStat;
    }

    public Date getLastFileUpdateTime() {
        return lastFileUpdateTime;
    }

    public void setLastFileUpdateTime(Date lastFileUpdateTime) {
        this.lastFileUpdateTime = lastFileUpdateTime;
    }

    public Date getLastJoinTime() {
        return lastJoinTime;
    }

    public void setLastJoinTime(Date lastJoinTime) {
        this.lastJoinTime = lastJoinTime;
    }

    public int getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(int voteNum) {
        this.voteNum = voteNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", userID=" + userID +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", postCode='" + postCode + '\'' +
                ", six=" + six +
                ", address='" + address + '\'' +
                ", applyNum=" + applyNum +
                ", birthday=" + birthday +
                ", bodySkin=" + bodySkin +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", emailPublic=" + emailPublic +
                ", hairSkin=" + hairSkin +
                ", faceSkin=" + faceSkin +
                ", wholeSkin=" + wholeSkin +
                ", faceDescribe='" + faceDescribe + '\'' +
                ", fileLevel=" + fileLevel +
                ", fileNum=" + fileNum +
                ", fileScore=" + fileScore +
                ", getApplyNum=" + getApplyNum +
                ", married=" + married +
                ", haveChildren=" + haveChildren +
                ", height=" + height +
                ", weight=" + weight +
                ", job=" + job +
                ", lastFileStat=" + lastFileStat +
                ", lastFileUpdateTime=" + lastFileUpdateTime +
                ", lastJoinTime=" + lastJoinTime +
                ", voteNum=" + voteNum +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
