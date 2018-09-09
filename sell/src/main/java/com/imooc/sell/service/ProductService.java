package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @program: sell
 * @description: 商品 service接口
 * @author: Junno
 * @create: 2018-08-30 19:25
 **/
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     *@Description: 查询所有在架商品列表
     *@Author: Junno
     *@Date: 18-8-30 下午7:28
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);


    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);



}
