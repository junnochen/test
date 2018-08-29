package com.example.exception;

import com.example.enums.ResultEnum;


/**
 * @program: curd
 * @description: 自定义异常
 * @author: Junno
 * @create: 2018-08-28 20:47
 **/

public class PersonException extends RuntimeException {

    private Integer code;


    public PersonException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
