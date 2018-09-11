package com.junno.login.service;

import com.junno.login.entity.Emp;

/**
 * @program: login
 * @description: 员工service接口
 * @author: Junno
 * @create: 2018-09-11 10:39
 **/
public interface EmpService {

    // 通过员工名和密码查找
    Emp getEmp(String name,String password);

    // 新增员工
    Emp save(Emp emp);

}
