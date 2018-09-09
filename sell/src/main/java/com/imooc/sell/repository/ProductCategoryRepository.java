package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sell
 * @description:
 * @author: Junno
 * @create: 2018-08-30 14:44
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

        List<ProductCategory> findByCategoryTypeIn(List<Integer> categroyTypeList);
}
