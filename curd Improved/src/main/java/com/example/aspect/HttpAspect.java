package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: curd
 * @description:
 * @author: Junno
 * @create: 2018-08-28 14:59
 **/
@org.aspectj.lang.annotation.Aspect  // 切面
@Component // 加入spring的依赖
public class HttpAspect {

    // spring内置是使用logback，引入的是 import org.slf4j.Logger; 这个log的jar包
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * com.example.controller.PersonController.*(..))")
    public void setLogger(){

    }

    @Before("setLogger()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod() );

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());


        //参数
        logger.info("args={}", joinPoint.getArgs());



    }

    @After("setLogger()")
    public void doAfter(){
        logger.info("22222222222222222");
    }

    /**
     * 返回信息展示，注意实体类需要一个toString方法
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "setLogger()")
    public void doAfterReturning(Object object){
        logger.info("respone={}", object);
    }

}
