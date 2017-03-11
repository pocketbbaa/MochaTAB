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
}
