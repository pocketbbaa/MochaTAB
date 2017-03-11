package com.tab.dao.tab;

import com.tab.model.Report;
import com.tab.vo.ReportListVO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import java.util.List;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
@DAO
public interface ReportDAO {

    /**
     * private int id;
     * private int evaluate; //评价 1:很好，2：好，3：普通，4：差，5：很差
     * private int productId; //商品ID
     * private int userId; //用户ID
     * private int evaluationId; //市调专案ID
     * private String experience; //用户心得
     * private String experiencePicUrl; //心得图片（用‘#’隔开）
     * private Date createTime;
     */
    String REPORT_PARAM = "ID,Evaluate,ProductId,UserId,EvaluationId,Experience,ExperiencePicUrl,CreateTime";

    /**
     * 添加报告
     *
     * @param report
     */
    @SQL("INSERT INTO report " +
            "(Evaluate,ProductID,UserID,EvaluationID,Experience,ExperiencePicUrl,Createtime) " +
            "VALUES (:1.evaluate,:1.productId,:1.userId,:1.evaluationId,:1.experience,:1.experiencePicUrl,NOW())")
    void insert(Report report);

    /**
     * 查询待审核的报告
     *
     * @return
     */
    @SQL("SELECT r.ID as reportID,e.Title as title,u.MochaUserName as username,r.CreateTime as createTime " +
            "FROM report r " +
            "LEFT JOIN evaluation e ON r.evaluationID = e.ID " +
            "LEFT JOIN USER u ON r.UserID = u.ID " +
            "WHERE r.Pass = 0 " +
            "ORDER BY r.CreateTime ASC ")
    List<ReportListVO> getReportListVO();

    /**
     * 根据ID获取报告
     *
     * @param reportID
     * @return
     */
    @SQL("SELECT " + REPORT_PARAM + " FROM report WHERE ID = :1")
    Report getByID(int reportID);
}
