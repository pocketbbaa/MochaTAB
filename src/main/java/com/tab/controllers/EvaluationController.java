package com.tab.controllers;

import com.tab.model.*;
import com.tab.service.*;
import com.tab.utils.FileUploadUtil;
import com.tab.utils.Log4jUtil;
import com.tab.utils.Threads;
import com.tab.vo.EvaluationListVO;
import com.tab.vo.EvaluationVO;
import com.tab.vo.ProductListVO;
import com.tab.vo.ReportVO;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Model;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 市调专案
 * Created by Administrator on 2017/3/6 0006.
 */
@Path("/case")
public class EvaluationController {

    private Logger webLog = Log4jUtil.webLog;

    @Autowired
    private ProductService productService;
    @Autowired
    private EvaluationService evaluationService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private UserService userServicel;

    /**
     * 获取商品列表
     *
     * @param model
     * @return
     */
    @ValidateLogin
    @Get("/product/list")
    public String list(Model model) {
        webLog.info(Threads.getCallLocation() + ", in case/product/list");

        List<ProductListVO> productListVOList = productService.getList();
        if (CollectionUtils.isEmpty(productListVOList)) {
            model.add("message", "目前还没有商品录入!");
            return "evaluation/case_add1";
        }
        model.add("productList", productListVOList);
        return "evaluation/case_add1";
    }

    /**
     * 创建市调专案载入商品信息
     *
     * @param model
     * @param id
     * @return
     */
    @ValidateLogin
    @Get("/add/stepOne/{id}")
    public String addStepOne(Model model, @Param("id") int id) {

        webLog.info(Threads.getCallLocation() + ", in case/add/stepOne->id:" + id);
        if (id == 0) {
            model.add("message", "传入id参数有误!");
            return "r:/case/product/list";
        }
        System.out.println(id);
        Product product = productService.getByID(id);
        if (product == null) {
            model.add("message", "没有获取到该商品信息!");
            return "r:/case/product/list";
        }
        model.add("product", product);
        return "evaluation/case_add";
    }

    /**
     * 创建市调专案
     *
     * @return
     */
    @ValidateLogin
    @Post("/add/create")
    public String add(Model model, EvaluationVO evaluationVO) {

        webLog.info(Threads.getCallLocation() + ", in case/add/create->evaluationVO:" + evaluationVO);
        System.out.println(evaluationVO);
        if (evaluationVO == null) {
            model.add("message", "创建市调专案出错!!");
            return "r:/case/product/list";
        }
        boolean result = evaluationService.add(evaluationVO);
        webLog.info(Threads.getCallLocation() + ", add result : " + result);
        if (result) {
            return "r:/case/list";
        }
        return "r:/case/product/list";
    }

    /**
     * 市调专案列表
     *
     * @return
     */
    @ValidateLogin
    @Get("/list")
    public String getList(Model model, HttpSession session) {

        webLog.info(Threads.getCallLocation() + ", in case/list ...");
        System.out.println("in case list ...");
        List<EvaluationListVO> evaluationListVOList = evaluationService.getListByManager();

        for (EvaluationListVO vo : evaluationListVOList) {
            System.out.println(vo);
        }
        if (CollectionUtils.isEmpty(evaluationListVOList)) {
            model.add("message", "目前还没有专案");
            return "evaluation/case_list";
        }
        webLog.info(Threads.getCallLocation() + ", evaluationListVOList.size:" + evaluationListVOList.size());
        model.add("evaluationList", evaluationListVOList);
        return "evaluation/case_list";
    }

    /**
     * 获取市调专案详情
     *
     * @param model
     * @param id
     * @return
     */
    @ValidateLogin
    @Get("{id}/info")
    public String info(Model model, @Param("id") int id) {

        webLog.info(Threads.getCallLocation() + ", in case/{id}/info ...id:" + id);
        if (id == 0) {
            model.add("message", "传入id参数有误!");
            return "r:/case/list";
        }
        //获取市调详情
        Evaluation evaluation = evaluationService.getByID(id);
        if (evaluation == null) {
            model.add("message", "没有获取到市调专案详情");
            return "r:/case/list";
        }
        //获取商品详情
        int productID = evaluation.getProductId();
        System.out.println("productID:" + productID);
        ProductListVO product = productService.getProductListVOByID(productID);
        System.out.println(product);

        //获取评测题目
        String questionIDStr = evaluation.getQuestion();
        String[] questions = questionIDStr.split(",");
        List<Integer> IDs = new ArrayList<>();
        for (String s : questions) {
            if (StringUtils.isNotEmpty(s)) {
                int questionID = Integer.parseInt(s);
                IDs.add(questionID);
            }
        }
        if (!CollectionUtils.isEmpty(IDs)) {
            List<Question> questionList = questionService.getQuestionByIDs(IDs);
            if (!CollectionUtils.isEmpty(questionList)) {
                List<Question> removeQ = new ArrayList<>();
                for (Question question : questionList) {
                    if (question == null || StringUtils.isEmpty(question.getDes())) {
                        removeQ.add(question);
                    }
                }
                questionList.removeAll(removeQ);
                model.add("questions", questionList);
            }
        }
        model.add("evaluation", evaluation);
        model.add("product", product);
        return "evaluation/case_info";
    }

    /**
     * 用户评测列表
     *
     * @param model
     * @return
     */
    @ValidateLogin
    @Get("/list/user")
    public String getListForUser(Model model, HttpSession session) {

        //过滤已经参与过评测的列表，
        //未通过审核报告
        webLog.info(Threads.getCallLocation() + ", in case/list/user ...");
        User user = (User) session.getAttribute("user");

        int userID = user.getId();
        //获取用户data
        UserData userData = userServicel.getUserDataByUserId(userID);
        if (userData == null) {
            model.add("message", "请在参与测评前完善个人资料，不然无法参与测评!");
            return "user/case_list";
        }

        List<EvaluationListVO> evaluationListVOList = evaluationService.getList(userID);
        if (CollectionUtils.isEmpty(evaluationListVOList)) {
            model.add("message", "目前还没有可参与的评测");
            return "user/case_list";
        }
        model.add("evaluationList", evaluationListVOList);
        return "user/case_list";
    }

    /**
     * 未通过的评测列表 pass = 2
     *
     * @param model
     * @param session
     * @return
     */
    @ValidateLogin
    @Get("/list/user/nopass")
    public String getListNoPass(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");
        int userID = user.getId();
        List<EvaluationListVO> evaluationListVOList = evaluationService.getListNoPass(userID);
        if (CollectionUtils.isEmpty(evaluationListVOList)) {
            model.add("message", "没有未通过的评测");
            return "user/no_pass_case_list";
        }
        model.add("evaluationList", evaluationListVOList);
        return "user/no_pass_case_list";
    }

    /**
     * 开始测评
     *
     * @param model
     * @param caseID
     * @param userID
     * @param productID
     * @return
     */
    @Get("/begin/{caseID}/{productID}")
    public String beginCase(Model model, @Param("caseID") int caseID, @Param("productID") int productID) {
        System.out.println("caseID:" + caseID + "  productID:" + productID);
        //1、获取商品信息
        ProductListVO productListVO = productService.getProductListVOByID(productID);
        System.out.println(productListVO);

        //2、获取市调专案信息
        Evaluation evaluation = evaluationService.getByID(caseID);
        System.out.println(evaluation);

        //3、获取小题目list
        String questionIDStr = evaluation.getQuestion();
        String[] questions = questionIDStr.split(",");
        List<Integer> IDs = new ArrayList<>();
        for (String s : questions) {
            if (StringUtils.isNotEmpty(s)) {
                int questionID = Integer.parseInt(s);
                IDs.add(questionID);
            }
        }
        if (!CollectionUtils.isEmpty(IDs)) {
            List<Question> questionList = questionService.getQuestionByIDs(IDs);
            if (!CollectionUtils.isEmpty(questionList)) {
                List<Question> remove = new ArrayList<>();
                for (Question q : questionList) {
                    if (q == null || StringUtils.isEmpty(q.getDes())) {
                        remove.add(q);
                    }
                }
                questionList.removeAll(remove);
                model.add("questions", questionList);
            }
        }
        model.add("evaluation", evaluation);
        model.add("product", productListVO);

        return "user/begin_case";

    }

    /**
     * 提交报告
     *
     * @param model
     * @param reportVO
     * @param files
     * @return
     */
    @ValidateLogin
    @Post("/report")
    public String report(Model model, ReportVO reportVO, MultipartFile[] files) {

        System.out.println(reportVO);

        if (reportVO == null) {
            model.add("message", "传入数据有误!report == null,请重新填写");
            return "r:/case/list/user";
        }

        int caseID = reportVO.getEvaluationID(); //市调ID
        int userID = reportVO.getUserID();
        int productID = reportVO.getProductID();

        //根据caseID，userID获取报告，如果没有获取到，走添加流程，如果获取成功，删除报告和回答 TODO
        System.out.println("userID:" + userID + "  caseID:" + caseID);
        int reportId = reportService.getIDByCaseIDAndUserID(caseID, userID);
        System.out.println("reportId:" + reportId);
        if (reportId != 0) {
            //1、删除report；
            reportService.deleteReportById(reportId);
            //2、删除回答;
            answerService.deleteByUserIDAndCaseID(userID, caseID);
        }

        // 获取小题目回答，并存库
        List<Answer> answerList = new ArrayList<>();
        int[] questionIDs = reportVO.getQuestionIDs(); //获取问题IDs
        String[] answers = reportVO.getAnswers(); //获取回答
        int[] score = reportVO.getScore();

        List<MultipartFile> fileExList = new ArrayList<>();

        if (questionIDs != null && questionIDs.length != 0 && answers != null && answers.length != 0 && score != null && score.length != 0) {
            if (questionIDs.length == answers.length && questionIDs.length == score.length) {
                for (int i = 0; i < questionIDs.length; i++) {
                    Answer answer = new Answer();
                    answer.setQuestionID(questionIDs[i]);
                    answer.setAnswerStr(answers[i]);
                    answer.setScore(score[i]);
                    answer.setCaseID(caseID);
                    answer.setUserID(userID);
                    //找到该问题的图片，并赋值给回答对象
                    for (MultipartFile file : files) {
                        String fileName = file.getName();
                        System.out.println(file.getName() + "   " + file.getOriginalFilename());
                        //过滤心得图片
                        if (fileName.startsWith("picUrl")) {
                            //获取文件名字后缀
                            if (StringUtils.isNotEmpty(file.getOriginalFilename())) {
                                String questionIDStr = fileName.split("_")[1];
                                if (StringUtils.isNotEmpty(questionIDStr)) {
                                    int questionID = Integer.parseInt(questionIDStr);
                                    if (questionID == questionIDs[i]) {
                                        //上传文件 TODO 目前每题一张图片
                                        try {
                                            String filePath = FileUploadUtil.uploadImg(file.getBytes(), FileUploadUtil.getFileName(file.getOriginalFilename())); //文件上传
                                            System.out.println("小题目图片:" + filePath);
                                            if (StringUtils.isNotEmpty(filePath)) {
                                                answer.setPicUrls(filePath);
                                            }
                                        } catch (IOException e) {
                                            Log4jUtil.exception(e);
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    answerList.add(answer);
                }
            }
        }
        for (MultipartFile file : files) {
            String fileName = file.getName();
            if (!fileName.startsWith("picUrl")) {
                fileExList.add(file);
            }
        }
        //小题目回答存库
        answerService.addList(answerList);

        //市调报告存库
        Report report = new Report();
        report.setCreateTime(new Date());
        report.setEvaluate(reportVO.getEvaluate());
        report.setExperience(reportVO.getExperience());
        report.setEvaluationId(caseID);
        report.setProductId(productID);
        report.setUserId(userID);

        String experiencePicUrl = "";
        for (MultipartFile file : fileExList) {
            if (StringUtils.isEmpty(file.getOriginalFilename())) {
                continue;
            }
            try {
                //心得图片上传
                String filePath = FileUploadUtil.uploadImg(file.getBytes(), FileUploadUtil.getFileName(file.getOriginalFilename()));
                if (StringUtils.isNotEmpty(filePath)) {
                    experiencePicUrl += filePath + "#";
                }
            } catch (IOException e) {
                Log4jUtil.exception(e);
                e.printStackTrace();
            }
        }
        report.setExperiencePicUrl(experiencePicUrl);

        boolean success = reportService.add(report);

        if (success) {
            model.add("message", "提交成功!");
            return "r:/case/list/user";
        }
        model.add("message", "提交失败！");
        return "r:/case/list/user";
    }

    /**
     * 删除市调专案
     *
     * @return
     */
    @Post("delete")
    public String delete() {
        return null;
    }

    /**
     * 分配市调专案
     *
     * @return
     */
    @Post("allot")
    public String allot() {
        return null;
    }

}
