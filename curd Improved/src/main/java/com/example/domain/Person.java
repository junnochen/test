package com.example.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @program: curd
 * @description: 实体类
 * @author: Junno
 * @create: 2018-08-27 22:47
 **/
@Entity
public class Person {

    @Id  //主键id
    @GeneratedValue  //自增长
    private int id;

    private String name;

    @Min(value = 18,message = "默认message信息")
    private int age;

    @NotNull(message = "成绩必填")
    private Double score;

    //必须要有构造函数
    public Person() {
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
