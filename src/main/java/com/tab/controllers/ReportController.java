package com.tab.controllers;

import com.tab.enums.ReportPassEnum;
import com.tab.model.Evaluation;
import com.tab.model.Report;
import com.tab.model.User;
import com.tab.model.UserData;
import com.tab.service.*;
import com.tab.utils.FileUploadUtil;
import com.tab.utils.Log4jUtil;
import com.tab.vo.ProductListVO;
import com.tab.vo.QAnswerVO;
import com.tab.vo.ReportListVO;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
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
    @Autowired
    private AnswerService answerService;

    /**
     * 获取待审核列表
     *
     * @param model
     * @return
     */
    @ValidateLogin
    @Get("/list")
    public String getReportList(Model model) {
        //过滤掉已通过和未通过审核的报告
        List<ReportListVO> reportListVOList = reportService.getReportListVO();
        if (CollectionUtils.isEmpty(reportListVOList)) {
            model.add("message", "目前没有待审核报告");
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
        System.out.println(report);
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
            System.out.println(s);
            picSet.add(FileUploadUtil.getDomainPic(s));
        }
        model.add("feelPicUrl", picSet);


        //2、市调信息
        int evaluationID = report.getEvaluationId(); //市调ID
        Evaluation evaluation = evaluationService.getByID(evaluationID);
        System.out.println(evaluation);
        if (evaluation == null) {
            model.add("message", "返回市调信息数据有误!");
            return "r:/report/list";
        }
        model.add("evaluation", evaluation);

        //3、用户信息,（用户基本数据可以直接在session中取）
        int userID = report.getUserId();
        User user = userService.getByID(userID);
        UserData userData = userService.getUserDataByUserId(userID); //获取用户data
        System.out.println(userData);
        if (userData == null) {
            model.add("message", "返回用户信息数据有误!");
            return "r:/report/list";
        }
        model.add("user", user);
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
        List<QAnswerVO> qAnswerVOList = answerService.getQAByUserIDAndCaseID(userID, evaluationID);
        if (CollectionUtils.isEmpty(qAnswerVOList)) {
            model.add("message", "没有获取到题目回答信息");
            return "r:/report/list";
        }
        model.add("qAnswerList", qAnswerVOList);

        return "evaluation/report_check_info";
    }

    /**
     * 审核通过
     *
     * @return
     */
    @ValidateLogin
    @Get("/pass/{reportID}")
    public String pass(Model model, @Param("reportID") int reportID) {
        if (reportID == 0) {
            model.add("message", "传入参数有误!");
            return "evaluation/report_check_info";
        }
        //更新pass字段
        reportService.updatePass(reportID, ReportPassEnum.PASS.getState());
        //更新市调数据,市调打分
        Report report = reportService.getByID(reportID);
        //更新总数据，算分
        boolean success = reportService.updateEvalutionData(report);
        if (success) {
            model.add("message","成功");
            return "r:/report/list";
        }
        return "r:/report/list";
    }

    /**
     * 审核不通过
     *
     * @param reason
     * @return
     */
    @ValidateLogin
    @Post("/noPass")
    public String noPass(Model model, @Param("reason") String reason, @Param("reportID") int reportID) {

        if (reportID == 0) {
            model.add("message", "传入报告ID有误reportID:" + reportID);
            return "evaluation/report_check_info";
        }

        if (StringUtils.isEmpty(reason)) {
            model.add("message", "不通过原因没有输入");
            return "evaluation/report_check_info";
        }
        //更新passStr
        reportService.updateNoPassStr(reportID, reason);
        //更新pass字段
        reportService.updatePass(reportID, ReportPassEnum.NO_PASS.getState());
        return "r:/report/list";
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
