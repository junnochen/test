package com.junno.login.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: login
 * @description: 员工实体类
 * @author: Junno
 * @create: 2018-09-11 10:23
 **/
@Entity
@Data
public class Emp {

    @Id
    @GeneratedValue
    /*用户编号.*/
    private Integer id;
    /*姓名.*/
    private String name;
    /*密码.*/
    private String password;
    /*性别.*/
    private String sex;
    /*年龄.*/
    private Integer age;

    public Emp() {
    }

    public Emp(String name, String password, String sex, Integer age) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
    }
}
