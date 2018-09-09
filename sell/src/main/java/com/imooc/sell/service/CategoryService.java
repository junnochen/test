package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @program: sell
 * @description: 类目 接口
 * @author: Junno
 * @create: 2018-08-30 16:17
 **/
public interface CategoryService {

    ProductCategory findById(Integer categoryId);

    List<ProductCategory > findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);


    ProductCategory save(ProductCategory productCategory);


}
