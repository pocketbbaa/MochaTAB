package com.tab.controllers;

import com.tab.model.Manager;
import com.tab.model.Product;
import com.tab.service.ProductService;
import com.tab.utils.Log4jUtil;
import com.tab.utils.Threads;
import com.tab.vo.ProductListVO;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Model;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 商品
 * Created by Administrator on 2017/3/7 0007.
 */
@Path("/product")
public class ProductController {

    private Logger webLog = Log4jUtil.webLog;

    @Autowired
    private ProductService productService;

    /**
     * 添加商品
     *
     * @param model
     * @return
     */
    @ValidateLogin
    @Post("/add")
    public String add(Model model, Product product, @Param("file") MultipartFile file, HttpSession session) {

        webLog.info(Threads.getCallLocation() + ", product/add-> product:" + product);
        byte[] bytes = null;
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (product == null) {
            model.add("message", "商品信息填写有误!");
            return "product/product_add";
        }
        Manager manager = (Manager) session.getAttribute("user");
        if (manager == null) {
            webLog.info(Threads.getCallLocation() + ", product/add-> session.getAttribute(\"user\"): manager is null");
            return "r:/index.jsp";
        }

        product.setPriceUpdateTime(new Date());
        product.setProducersStatusTime(new Date());
        product.setLastEditer(manager.getId());
        product.setLastEditerTime(new Date());

        if (productService.add(product, bytes, file.getOriginalFilename())) {
            webLog.info(Threads.getCallLocation() + ", product/add-> add success!!!");
            return "r:/product/list";
        }
        model.add("message", "商品存库出错!!");
        return "product/product_add";
    }

    /**
     * 获取商品列表
     *
     * @param model
     * @return
     */
    @ValidateLogin
    @Get("/list")
    public String list(Model model) {
        webLog.info(Threads.getCallLocation() + ", in product/list");

        List<ProductListVO> productListVOList = productService.getList();
        if (CollectionUtils.isEmpty(productListVOList)) {
            model.add("message", "目前还没有商品录入!");
            return "product/product_list";
        }
        model.add("productList", productListVOList);
        return "product/product_list";
    }

    /**
     * 删除商品
     *
     * @param model
     * @param id
     * @return
     */
    @ValidateLogin
    @Get("delete/{id}")
    public String delete(Model model, @Param("id") int id) {

        if (id == 0) {
            model.add("message", "传入ID有误");
            return "r:/product/list";
        }
        if (productService.deleteByID(id)) {
            return "r:/product/list";
        }
        return "r:/product/list";
    }

}
