package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @program: sell
 * @description: 类目
 * @author: Junno
 * @create: 2018-08-30 14:39
 **/

/**实体类*/
@Entity
/** 修改时间属性. */
@DynamicUpdate
/**getter、setter和toString方法注解*/
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**类目id. */
    private Integer categoryId;
    /**类目名称. */
    private String categoryName;
    /**类目属性. */
    private Integer categoryType;

    public ProductCategory() {

    }
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
