package com.imooc.sell.utils;

import java.util.Random;

/**
 * @program: sell
 * @description:
 * @author: Junno
 * @create: 2018-09-04 19:01
 **/
public class KeyUtil {

    /**
     *@Description: 生成唯一的主键
     *@格式： 时间+随机数
     *@Author: Junno
     *@Date: 18-9-4 下午7:03
     */
    public  static synchronized String genUniqueKey(){

        Random random = new Random();
        //6位随机数
        Integer number = random.nextInt(900000)+100000;

        return System.currentTimeMillis()+ String.valueOf(number);

    }


}
