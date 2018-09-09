package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @program: sell
 * @description: 商品
 * @author: Junno
 * @create: 2018-08-30 18:59
 **/

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品价格. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 商品状态. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;


}


