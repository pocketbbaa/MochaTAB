package com.tab.controllers;

import com.tab.model.Evaluation;
import com.tab.model.Report;
import com.tab.model.User;
import com.tab.model.UserData;
import com.tab.service.EvaluationService;
import com.tab.service.ProductService;
import com.tab.service.ReportService;
import com.tab.service.UserService;
import com.tab.utils.Log4jUtil;
import com.tab.vo.ProductListVO;
import com.tab.vo.ReportListVO;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.var.Model;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
@Path("/report")
public class ReportController {

    private Logger webLog = Log4jUtil.webLog;
    @Autowired
    private ReportService reportService;
    @Autowired
    private EvaluationService evaluationService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    /**
     * 获取待审核列表
     *
     * @param model
     * @return
     */
    @ValidateLogin
    @Get("/list")
    public String getReportList(Model model) {

        List<ReportListVO> reportListVOList = reportService.getReportListVO();
        if (CollectionUtils.isEmpty(reportListVOList)) {
            model.add("reportList", new ArrayList<ReportListVO>());
            return "evaluation/report_check_list";
        }
        model.add("reportList", reportListVOList);
        return "evaluation/report_check_list";
    }

    /**
     * 报告详情
     *
     * @param model
     * @param reportID
     * @return
     */
    @ValidateLogin
    @Get("/info/{reportID}")
    public String getReportInfo(Model model, @Param("reportID") int reportID) {

        System.out.println("reportID:" + reportID);

        if (reportID == 0) {
            model.add("message", "传入数据有误:reportID:" + reportID);
            return "r:/report/list";
        }

        //1、报告信息
        Report report = reportService.getByID(reportID);
        if (report == null) {
            model.add("message", "返回报告基本数据有误!");
            return "r:/report/list";
        }
        model.add("report", report);

        //获取用户心得图片
        String picUrls = report.getExperiencePicUrl();
        String[] picUrlArray = picUrls.split("#");
        Set<String> picSet = new HashSet<>();
        for (String s : picUrlArray) {
            picSet.add(s);
        }
        model.add("feelPicUrl", picSet);


        //2、市调信息
        int evaluationID = report.getEvaluationId(); //市调ID
        Evaluation evaluation = evaluationService.getByID(evaluationID);
        if (evaluation == null) {
            model.add("message", "返回市调信息数据有误!");
            return "r:/report/list";
        }
        model.add("evaluation", evaluation);

        //3、用户信息,（用户基本数据可以直接在session中取）
        int userID = report.getUserId();
        UserData userData = userService.getUserDataByUserId(userID); //获取用户data
        if (userData == null) {
            model.add("message", "返回用户信息数据有误!");
            return "r:/report/list";
        }
        model.add("userData", userData);

        //4、商品信息
        int productID = report.getProductId();
        ProductListVO productListVO = productService.getProductListVOByID(productID);
        if (productListVO == null) {
            model.add("message", "返回商品信息数据有误!");
            return "r:/report/list";
        }
        model.add("product", productListVO);

        //根据用户ID，市调ID获取小题目信息


        return "evaluation/report_check_info";
    }

    public static void main(String[] args) {

        String aa = "/data/log/512x512/timg2017311108.jpg#/data/log/550x440/timg (1)2017311108.jpg#/data/log/550x440/timg (1)2017311108.jpg#/data/log/512x512/timg2017311109.jpg#/data/log/512x512/timg2017311109.jpg#/data/log/550x440/timg (1)2017311109.jpg#/data/log/550x440/timg (1)20173111010.jpg#/data/log/512x512/timg20173111010.jpg#/data/log/512x512/timg20173111010.jpg#/data/log/550x440/timg (1)20173111010.jpg#/data/log/550x440/timg (1)20173111011.jpg#/data/log/512x512/timg20173111011.jpg#";
        String[] picUrlArray = aa.split("#");
        Set<String> picSet = new HashSet<>();
        for (String s : picUrlArray) {
            System.out.println(s);
            picSet.add(s);
        }
        System.out.println("--------------------------------------------------------------------");
        for (String s : picSet) {
            System.out.println(s);
        }


    }

}
