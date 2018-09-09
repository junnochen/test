package com.imooc.sell.controller;

import com.imooc.sell.VO.ProductInfoVO;
import com.imooc.sell.VO.ProductVO;
import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductService;
import com.imooc.sell.utils.ResultVoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell
 * @description: 买家商品
 * @author: Junno
 * @create: 2018-08-30 21:42
 **/

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    @Autowired
    private ProductService productService;


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){

        //查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();


        //查询类目（一次性查询）

//        List<Integer> categoryTypeList = new ArrayList<>();

        //传统方法
//        for(ProductInfo productInfo: productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType())
//        }

        //精简方法(java8, lambda)重点
         List<Integer> categoryTypeList = productInfoList.stream()
                                              .map(e -> e.getCategoryType())
                                              .collect(Collectors.toList());

         List<ProductCategory> productCategoryList =categoryService.findByCategoryTypeIn(categoryTypeList);


        //数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setType(productCategory.getCategoryType());
            productVO.setName(productCategory.getCategoryName());


            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    /**拷贝 productInfo 相同字段. */
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }


            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);

        }




        return ResultVoUtil.success(productVOList);
    }


}
