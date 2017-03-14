package com.tab.vo;

import com.tab.utils.FileUploadUtil;

import java.util.Date;

/**
 * 市调审核列表
 * Created by Administrator on 2017/3/11 0011.
 */
public class ReportListVO {

    private int reportID;
    private String title;
    private String username;
    private String mochaUserPic;
    private Date createTime;

    public String getMochaUserPic() {
        return mochaUserPic;
    }

    public void setMochaUserPic(String mochaUserPic) {
        this.mochaUserPic = FileUploadUtil.getDomainPic(mochaUserPic);
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ReportListVO{" +
                "reportID=" + reportID +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
