package com.junno.login.controller;
import com.junno.login.entity.Emp;
import com.junno.login.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @program: login
 * @description: 员工controller层
 * @author: Junno
 * @create: 2018-09-11 10:47
 **/
@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/")
    public String loginIndex(){
        return "login";
    }


    //员工登录
    @RequestMapping("/login")
    public String getEmp(@RequestParam String name,
                         @RequestParam String password,
                         HttpSession httpSession,
                         RedirectAttributes attributes){
        Emp emp = empService.getEmp(name, password);
        if(emp!=null){
            emp.setPassword(null);
            httpSession.setAttribute("emp", emp);
            return "index";
        }else {
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect";
        }
    }



    //进入注册页面
    @RequestMapping("/toRegist")
    public String insert(){
        return "regist";
    }

    //保存注册信息
    @RequestMapping("/regist")
    public String save(Emp emp){
        empService.save(emp);
        return  "success";

    }




}
