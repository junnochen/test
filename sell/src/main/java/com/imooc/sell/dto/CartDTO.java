package com.imooc.sell.dto;

import lombok.Data;

/**
 * @program: sell
 * @description: 购物车
 * @author: Junno
 * @create: 2018-09-04 19:32
 **/

@Data
public class CartDTO {

    /*商品id.*/
    private String productId;

    /*商品数量.*/
    private  Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
