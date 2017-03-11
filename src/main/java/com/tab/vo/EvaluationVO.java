package com.tab.vo;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * 创建市调专案VO
 * Created by Administrator on 2017/3/8 0008.
 */
public class EvaluationVO {

    private int productId; //商品ID
    private String title; //市调标题
    private String standard; //市调评测规格
    private int amount; //招募理想人数
    private int duration; //市调评测周期
    private Date startDate; //市调评测开始时间
    private Date endDate; //市调评测结束时间
    private Date showDate; //市调公布日期
    private int visible; //市調報告代碼
    private String[] question; //小题目

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public String[] getQuestion() {
        return question;
    }

    public void setQuestion(String[] question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "EvaluationVO{" +
                "productId=" + productId +
                ", title='" + title + '\'' +
                ", standard='" + standard + '\'' +
                ", amount=" + amount +
                ", duration=" + duration +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", showDate=" + showDate +
                ", visible='" + visible + '\'' +
                ", question=" + Arrays.toString(question) +
                '}';
    }
}
