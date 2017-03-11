package com.tab.model;

import java.util.Date;

/**
 * 市调报告
 * Created by Administrator on 2017/3/11 0011.
 */
public class Report {

    private int id;
    private int evaluate; //评价 1:很好，2：好，3：普通，4：差，5：很差
    private int productId; //商品ID
    private int userId; //用户ID
    private int evaluationId; //市调专案ID
    private String experience; //用户心得
    private String experiencePicUrl; //心得图片（用‘#’隔开）
    private Date createTime;


    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", evaluate=" + evaluate +
                ", productId=" + productId +
                ", userId=" + userId +
                ", evaluationId=" + evaluationId +
                ", experience='" + experience + '\'' +
                ", experiencePicUrl='" + experiencePicUrl + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(int evaluate) {
        this.evaluate = evaluate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getExperiencePicUrl() {
        return experiencePicUrl;
    }

    public void setExperiencePicUrl(String experiencePicUrl) {
        this.experiencePicUrl = experiencePicUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
