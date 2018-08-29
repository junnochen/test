package com.example.dao;

import com.example.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: curd
 * @description:
 * @author: Junno
 * @create: 2018-08-28 09:31
 **/

public interface PersonRepository extends JpaRepository<Person,Integer> {

    //通过年龄来查询
    public List<Person> findByAge(Integer age);

}
