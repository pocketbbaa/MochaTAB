package com.tab.dao.tab;

import com.tab.model.Product;
import com.tab.vo.ProductListVO;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7 0007.
 */
@DAO
public interface ProductDAO {

    /**
     * 添加商品
     *
     * @param product
     */
    @SQL("INSERT INTO product " +
            "(NAME," +
            "picNum," +
            "picUrl," +
            "price," +
            "capacity," +
            "quality," +
            "element," +
            "function," +
            "userWay," +
            "attention," +
            "channel," +
            "suitSkin," +
            "topicNum," +
            "series," +
            "ismarket," +
            "brandId," +
            "webUrl," +
            "num," +
            "informationStatus," +
            "producersStatus," +
            "productShow," +
            "functionShow," +
            "elementShow," +
            "likeNum," +
            "lastEditer," +
            "priceUpdateTime," +
            "producersStatusTime," +
            "lastEditerTime) " +
            "VALUES " +
            "(:1.name,:1.picNum,:1.picURL,:1.price,:1.capacity,:1.quality,:1.element,:1.function,:1.userWay,:1.attention,:1.channel," +
            ":1.suitSkin,:1.topicNum,:1.series,:1.ismarket,:1.brandId,:1.webUrl,:1.num,:1.informationStatus,:1.producersStatus," +
            ":1.productShow,:1.functionShow,:1.elementShow,:1.likeNum,:1.lastEditer,NOW(),NOW(),NOW())")
    void insert(Product product);

    /**
     * 获取商品列表
     *
     * @return
     */
    @SQL("SELECT " +
            "p.id,p.name,p.picUrl,p.price,s.name AS skinName,p.ismarket,p.likeNum,a.UserName AS lastEditer,p.lastEditerTime " +
            "FROM product p " +
            "LEFT JOIN skin s ON p.suitSkin = s.id " +
            "LEFT JOIN administrator a ON p.lastEditer = a.id order by lastEditerTime desc")
    List<ProductListVO> getList();

    /**
     * 获取商品列表
     *
     * @return
     */
    @SQL("SELECT " +
            "p.id,p.name,p.picUrl,p.price,s.name AS skinName,p.ismarket,p.likeNum,p.function,p.attention " +
            "FROM product p " +
            "LEFT JOIN skin s ON p.suitSkin = s.id " +
            "WHERE p.id = :1")
    ProductListVO getProductListVOByID(int id);

    /**
     * 根据ID删除商品
     *
     * @param id
     */
    @SQL("DELETE FROM product WHERE id = :1")
    void deleteById(int id);

    /**
     * 根据ID获取商品信息
     *
     * @param id
     * @return
     */
    @SQL("SELECT ID,NAME," +
            "picNum," +
            "picUrl as picURL," +
            "price," +
            "capacity," +
            "quality," +
            "element," +
            "function," +
            "userWay," +
            "attention," +
            "channel," +
            "suitSkin," +
            "topicNum," +
            "series," +
            "ismarket," +
            "brandId," +
            "webUrl," +
            "num," +
            "informationStatus," +
            "producersStatus," +
            "productShow," +
            "functionShow," +
            "elementShow," +
            "likeNum," +
            "lastEditer," +
            "priceUpdateTime," +
            "producersStatusTime," +
            "lastEditerTime FROM product WHERE ID = :1")
    Product getByID(int id);
}
