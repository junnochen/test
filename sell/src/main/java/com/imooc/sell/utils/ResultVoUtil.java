package com.imooc.sell.utils;

import com.imooc.sell.VO.ResultVO;

/**
 * @program: sell
 * @description:
 * @author: Junno
 * @create: 2018-08-31 16:52
 **/
public class ResultVoUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg(msg);
        return resultVO;
    }
}


