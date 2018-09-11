package com.junno.login.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: login
 * @description: 自定义错误页面
 * @author: Junno
 * @create: 2018-09-11 12:17
 **/
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e) throws Exception{

        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
        mv.setViewName("error");
        return mv;

    }

}
