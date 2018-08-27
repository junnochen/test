package com.example.dao;

import com.example.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *@Author:Junno
 *@Description:
 *@Date: 16:46 2018/8/20
*/
public interface PersonRepository extends JpaRepository<Person,Integer> {
    
}
