package com.tab.service.impl;

import com.tab.dao.tab.ReportDAO;
import com.tab.model.Report;
import com.tab.service.ReportService;
import com.tab.utils.Log4jUtil;
import com.tab.vo.ReportListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDAO reportDAO;

    @Override
    public boolean add(Report report) {
        try {
            reportDAO.insert(report);
        } catch (Exception e) {
            e.printStackTrace();
            Log4jUtil.exception(e);
            return false;
        }
        return true;
    }

    @Override
    public List<ReportListVO> getReportListVO() {
        return reportDAO.getReportListVO();
    }

    @Override
    public Report getByID(int reportID) {
        return reportDAO.getByID(reportID);
    }
}
