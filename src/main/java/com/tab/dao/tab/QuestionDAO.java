package com.tab.dao.tab;

import com.tab.model.Question;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;

import java.util.List;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
@DAO
public interface QuestionDAO {

    /**
     * 添加问题
     *
     * @param desc
     * @param caseID
     * @return
     */
    @ReturnGeneratedKeys
    @SQL("INSERT INTO question (Des,CaseID,CreateTime) VALUES (:1,:2,NOW())")
    int insert(String desc, int caseID);

    /**
     * 根据IDs获取问题集合
     *
     * @param IDs
     * @return
     */
    @SQL("SELECT ID,Des,CaseID,CreateTime FROM question WHERE ID IN (:1) ORDER BY FIELD (ID,:1)")
    List<Question> getQuestionByIDs(List<Integer> IDs);

}
