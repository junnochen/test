package com.junno.login.service.impl;

import com.junno.login.dao.EmpRepository;
import com.junno.login.entity.Emp;
import com.junno.login.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: login
 * @description: 实现员工的service接口
 * @author: Junno
 * @create: 2018-09-11 10:42
 **/
@org.springframework.stereotype.Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepository empRepository;

    //通过名字和密码进行登录
    @Override
    public Emp getEmp(String name, String password) {
        Emp emp = empRepository.findByNameAndPassword(name, password);
        return emp;
    }

    //保存用户
    @Override
    public Emp save(Emp emp) {
        empRepository.save(emp);
        return emp;
    }
}
