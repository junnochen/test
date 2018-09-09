package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;

/**
 * @program: sell
 * @description: sell异常处理
 * @author: Junno
 * @create: 2018-09-04 14:25
 **/
public class SellException extends RuntimeException {


    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();

    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
