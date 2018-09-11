package com.junno.login.dao;

import com.junno.login.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: login
 * @description: 员工dao接口
 * @author: Junno
 * @create: 2018-09-11 10:36
 **/
public interface EmpRepository  extends JpaRepository<Emp,Long> {

    //通过姓名和密码查询
    Emp findByNameAndPassword(String name,String password);

}
