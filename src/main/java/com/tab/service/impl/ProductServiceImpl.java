package com.tab.service.impl;

import com.tab.dao.tab.ProductDAO;
import com.tab.dao.tab.QuestionDAO;
import com.tab.model.Product;
import com.tab.service.ProductService;
import com.tab.service.QuestionService;
import com.tab.utils.FileUploadUtil;
import com.tab.vo.ProductListVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7 0007.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public boolean add(Product product, byte[] bytes, String filename) {

        if (bytes == null) {
            product.setPicNum(0);
            product.setPicURL("");
        }
        try {
            String filePath = FileUploadUtil.uploadImg(bytes, FileUploadUtil.getFileName(filename)); //文件上传
            System.out.println("filePath:" + filePath);
            if (StringUtils.isNotEmpty(filePath)) {
                product.setPicNum(1);
                product.setPicURL(filePath);
            }
            productDAO.insert(product);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<ProductListVO> getList() {
        return productDAO.getList();
    }

    @Override
    public boolean deleteByID(int id) {
        try {
            productDAO.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Product getByID(int id) {
        return productDAO.getByID(id);
    }

    @Override
    public ProductListVO getProductListVOByID(int id) {
        return productDAO.getProductListVOByID(id);
    }
}
