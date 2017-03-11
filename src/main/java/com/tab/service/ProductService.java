package com.tab.service;

import com.tab.model.Product;
import com.tab.vo.ProductListVO;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7 0007.
 */
public interface ProductService {

    /**
     * 添加商品
     *
     * @param product
     * @return
     */
    boolean add(Product product, byte[] bytes, String filename);

    /**
     * 获取商品列表
     *
     * @return
     */
    List<ProductListVO> getList();

    /**
     * 根据ID删除商品
     * @param id
     * @return
     */
    boolean deleteByID(int id);

    /**
     * 根据ID获取商品信息
     * @param id
     * @return
     */
    Product getByID(int id);

    /**
     * 根据ID获取ProductListVO
     * @param id
     * @return
     */
    ProductListVO getProductListVOByID(int id);
}
