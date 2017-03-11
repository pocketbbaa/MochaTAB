package com.tab.model;

import com.tab.utils.FileUploadUtil;

import java.util.Date;

/**
 * 商品
 * Created by Administrator on 2017/3/6 0006.
 */
public class Product {

    private int id;
    private String name; //商品名称
    private int picNum; //商品图片数量  只有0,1
    private String picURL; //商品图片地址
    private double price; //商品价格
    private int capacity; //商品容量
    private String quality; //商品质地
    private String element; //商品成分
    private String function; //商品功能
    private String userWay; //商品使用方法
    private String attention; //商品注意事项
    private String channel; //商品通路(專櫃/通路等)
    private int suitSkin; //商品适合肌肤
    private int topicNum; //商品相关话题数
    private String series; //商品系列
    private int ismarket; //商品是否上市
    private int brandId; //品牌编号

    private String webUrl; //官方或網頁連結
    private int num; //衛妝廣字編號
    private int pic_xx_num; //防止圖片被快取之亂數
    private int informationStatus; //资料状态资料状态 TODO 资料状态有哪些
    private int producersStatus; //产商公布状态 TODO 状态资料

    private int productShow; //商品是否显示于前台
    private int functionShow; //商品功能是否显示于前台
    private int elementShow; //商品成分是否显示于前台
    private int likeNum; //加入此商品為愛用品的人數
    private int lastEditer; //最后编辑者
    private Date priceUpdateTime; //商品价格更新时间
    private Date producersStatusTime; //产商公布状态更新时间
    private Date lastEditerTime; //最后编辑时间


    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = FileUploadUtil.getDomainPic(picURL);
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

    public int getPicNum() {
        return picNum;
    }

    public void setPicNum(int picNum) {
        this.picNum = picNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public int getSuitSkin() {
        return suitSkin;
    }

    public void setSuitSkin(int suitSkin) {
        this.suitSkin = suitSkin;
    }

    public String getUserWay() {
        return userWay;
    }

    public void setUserWay(String userWay) {
        this.userWay = userWay;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getTopicNum() {
        return topicNum;
    }

    public void setTopicNum(int topicNum) {
        this.topicNum = topicNum;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Date getPriceUpdateTime() {
        return priceUpdateTime;
    }

    public void setPriceUpdateTime(Date priceUpdateTime) {
        this.priceUpdateTime = priceUpdateTime;
    }

    public int getIsmarket() {
        return ismarket;
    }

    public void setIsmarket(int ismarket) {
        this.ismarket = ismarket;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPic_xx_num() {
        return pic_xx_num;
    }

    public void setPic_xx_num(int pic_xx_num) {
        this.pic_xx_num = pic_xx_num;
    }

    public int getInformationStatus() {
        return informationStatus;
    }

    public void setInformationStatus(int informationStatus) {
        this.informationStatus = informationStatus;
    }

    public int getProducersStatus() {
        return producersStatus;
    }

    public void setProducersStatus(int producersStatus) {
        this.producersStatus = producersStatus;
    }

    public Date getProducersStatusTime() {
        return producersStatusTime;
    }

    public void setProducersStatusTime(Date producersStatusTime) {
        this.producersStatusTime = producersStatusTime;
    }

    public int getProductShow() {
        return productShow;
    }

    public void setProductShow(int productShow) {
        this.productShow = productShow;
    }

    public int getFunctionShow() {
        return functionShow;
    }

    public void setFunctionShow(int functionShow) {
        this.functionShow = functionShow;
    }

    public int getElementShow() {
        return elementShow;
    }

    public void setElementShow(int elementShow) {
        this.elementShow = elementShow;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getLastEditer() {
        return lastEditer;
    }

    public void setLastEditer(int lastEditer) {
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
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picNum=" + picNum +
                ", picURL=" + picURL +
                ", price=" + price +
                ", capacity=" + capacity +
                ", quality='" + quality + '\'' +
                ", element='" + element + '\'' +
                ", function='" + function + '\'' +
                ", userWay='" + userWay + '\'' +
                ", attention='" + attention + '\'' +
                ", channel='" + channel + '\'' +
                ", suitSkin=" + suitSkin +
                ", topicNum=" + topicNum +
                ", series='" + series + '\'' +
                ", ismarket=" + ismarket +
                ", brandId=" + brandId +
                ", webUrl='" + webUrl + '\'' +
                ", num=" + num +
                ", pic_xx_num=" + pic_xx_num +
                ", informationStatus=" + informationStatus +
                ", producersStatus=" + producersStatus +
                ", productShow=" + productShow +
                ", functionShow=" + functionShow +
                ", elementShow=" + elementShow +
                ", likeNum=" + likeNum +
                ", lastEditer=" + lastEditer +
                ", priceUpdateTime=" + priceUpdateTime +
                ", producersStatusTime=" + producersStatusTime +
                ", lastEditerTime=" + lastEditerTime +
                '}';
    }
}
