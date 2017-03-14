package com.tab.service;

import com.tab.model.Report;
import com.tab.vo.ReportListVO;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public interface ReportService {


    /**
     * 添加报告
     *
     * @param report
     * @return
     */
    boolean add(Report report);

    /**
     * 查询待审核报告
     *
     * @return
     */
    List<ReportListVO> getReportListVO();

    /**
     * 根据ID获取报告
     * @param reportID
     * @return
     */
    Report getByID(int reportID);

    /**
     * 根据ID更新报告ID
     * @param reportID
     */
    void updatePass(int reportID,int pass);

    /**
     * 更新不通过理由
     * @param reportID
     * @param reason
     */
    void updateNoPassStr(int reportID, String reason);

    /**
     *
     * @param caseID
     * @param userID
     * @return
     */
    int getIDByCaseIDAndUserID(int caseID, int userID);

    /**
     * 删除报告
     * @param reportId
     */
    void deleteReportById(int reportId);

    /**
     * 报告审核通过，更新市调专案总数据
     * @param report
     * @return
     */
    boolean updateEvalutionData(Report report);
}
