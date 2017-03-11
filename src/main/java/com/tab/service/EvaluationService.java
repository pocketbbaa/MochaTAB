package com.tab.service;

import com.tab.model.Evaluation;
import com.tab.vo.EvaluationListVO;
import com.tab.vo.EvaluationVO;

import java.util.List;

/**
 * Created by Administrator on 2017/3/8 0008.
 */
public interface EvaluationService {

    /**
     * 创建市调专案
     *
     * @param evaluationVO
     * @return
     */
    boolean add(EvaluationVO evaluationVO);

    /**
     * 获取市调专案列表
     *
     * @return
     */
    List<EvaluationListVO> getList();

    /**
     * 根据ID获取市调专案详情
     *
     * @param id
     * @return
     */
    Evaluation getByID(int id);

}
