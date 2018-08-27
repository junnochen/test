package com.example.controller;

import com.example.dao.PersonRepository;
import com.example.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    /**
     *@Author:Junno
     *@Description: 查询所有数据
     *@Date: 17:00 2018/8/20
    */
    @GetMapping("/persons")
    public List<Person> personList(){
        return personRepository.findAll();
    }

    /**
     *@Author:Junno
     *@Description : 添加一条信息
     *@Date: 17:13 2018/8/20
    */
    @PostMapping(value = "/person")
    public Person addPerson(@RequestParam("name") String name,
                                @RequestParam("age") Integer age){

        Person person = new Person();
        person.setName(name);
        person.setAge(age);

        return personRepository.save(person);

    }

    /**
     *@Author:Junno
     *@Description: 更新一条信息
     *@Date: 17:26 2018/8/20
    */
    @PutMapping(value = "/person/{id}")
    public Person updatePerson(@PathVariable("id") Integer id,
                               @RequestParam("name") String name,
                               @RequestParam("age") Integer age){

        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);

        return personRepository.save(person);

    }

    /**
     *@Author:Junno
     *@Description: 根据id查询
     *@Date: 17:38 2018/8/20
    */
    @GetMapping(value = "/person/{id}")
    public Person findOnePerson(@PathVariable("id") Integer id){
        return personRepository.findById(id).orElse(null);
    }


    /**
     *@Author:Junno
     *@Description: 删除
     *@Date: 17:40 2018/8/20
    */
    @DeleteMapping(value = "/person/{id}")
    public void deletePerson(@PathVariable("id") Integer id){
        personRepository.deleteById(id);
    }




}
