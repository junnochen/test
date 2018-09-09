package com.imooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: sell
 * @description: 商品包含类目
 * 返回给前端和数据库不同字段的话用VO，通过@JsonProperty可以起名不一致
 * @author: Junno
 * @create: 2018-08-30 22:30
 **/
@Data
public class ProductVO {


    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private Integer type;


    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;


}
