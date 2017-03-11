package com.tab.dao.tab;

import com.tab.model.Evaluation;
import com.tab.vo.EvaluationListVO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;

import java.util.List;

/**
 * Created by Administrator on 2017/3/8 0008.
 */
@DAO
public interface EvaluationDAO {


    /**
     * private int id;
     * private String title; //市调标题
     * private String standard; //市调评测规格
     * private int amount; //招募理想人数
     * <p>
     * private int duration; //市调评测周期
     * private Date startDate; //市调评测开始时间
     * private Date endDate; //市调评测结束时间
     * private Date showDate; //市调公布日期
     * <p>
     * private int productId;  //商品ID
     * private int visible; //市調報告代碼  3:市调
     * private double version; //版本
     * <p>
     * private Date createTime;
     * private Date updateTime;
     * <p>
     * private int resAmount; //市调成员回复心得数
     * <p>
     * private int votePercent; //投票率
     * private int item1amount; //满意度为很好的人数
     * private int item2amount; //满意度为好的人数
     * private int item3amount; //满意度为普通的人数
     * private int item4amount; //满意度为差的人数
     * private int item5amount; //满意度为很差的人数
     * <p>
     * private int item1grade; //滿意度为很好的加權后分數
     * private int item2grade; //滿意度為好的加權後分數
     * private int item3grade; //滿意度為普通的加權後分數
     * private int item4grade; //滿意度為差的加權後分數
     * private int item5grade; //滿意度為很差的加權後分數
     * <p>
     * private int totalGrade; //滿意度總分
     * private int item1Apercent; // 選擇滿意度為很好的比例
     * private int item2Apercent; // 選擇滿意度為好的比例
     * private int item3Apercent; // 選擇滿意度為普通的比例
     * private int item4Apercent; // 選擇滿意度為差的比例
     * private int item5Apercent; // 選擇滿意度為很差的比例
     * <p>
     * private String question; //小题目
     */

    String EvaluationParam = "ID,Title,Standard,Amount,Duration,StartDate,EndDate," +
            "ShowDate,ProductId,Visible,Version,CreateTime,UpdateTime,ResAmount,VotePercent,Item1amount,Item2amount,Item3amount,Item4amount," +
            "Item5amount,Item1grade,Item2grade,Item3grade,Item4grade,Item5grade,TotalGrade,Item1Apercent,Item2Apercent,Item3Apercent,Item4Apercent," +
            "Item5Apercent,Question";

    /**
     * 添加市调专案
     *
     * @param evaluation
     */
    @ReturnGeneratedKeys
    @SQL("INSERT INTO evaluation " +
            "(Title,Standard,Amount,Duration,StartDate,EndDate,ShowDate,ProductId,Visible,Version,Question,CreateTime,UpdateTime) " +
            "VALUES " +
            "(:1.title,:1.standard,:1.amount,:1.duration,:1.startDate,:1.endDate,:1.showDate,:1.productId,:1.visible,:1.version,:1.question,:1.createTime,:1.updateTime)")
    int insert(Evaluation evaluation);

    /**
     * 更新问题到市调
     *
     * @param qsIDs
     * @param caseID
     */
    @SQL("UPDATE evaluation SET Question = :1 WHERE ID = :2")
    void updateQuestion(String qsIDs, int caseID);

    /**
     * 获取市调专案列表
     *
     * @return
     */
    @SQL("SELECT  e.ID as id,p.picUrl AS picURL,e.Title AS title,e.CreateTime AS createTime,e.StartDate,e.EndDate,e.ProductId " +
            "FROM evaluation e LEFT JOIN product p ON e.ProductId = p.id " +
            "WHERE e.ISValid = 1 ORDER BY e.CreateTime DESC")
    List<EvaluationListVO> getList();

    /**
     * 根据ID获取市调专案详情
     *
     * @param id
     * @return
     */
    @SQL("SELECT " + EvaluationParam + " FROM evaluation WHERE ID = :1")
    Evaluation getByID(int id);
}
