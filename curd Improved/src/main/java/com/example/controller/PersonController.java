package com.example.controller;

import com.example.Utils.ResultUtil;
import com.example.dao.PersonRepository;
import com.example.domain.Person;
import com.example.domain.Result;
import com.example.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @program: curd
 * @description:
 * @author: Junno
 * @create: 2018-08-28 09:33
 **/
@RestController
public class PersonController {
    /*
    *slf4j
    */
    private final static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private PersonService personService;


    /**
     *@Description: 查询用户列表
     *@Author: Junno
     *@Date: 18-8-28
     */
    @GetMapping
    public List<Person> personList(){
        logger.info("personList");
        return personRepository.findAll();
    }



/**
 *@Description: 增添一个用户信息
 *@Author: Junno
 *@Date: 18-8-28
 */
    @PostMapping(value = "/person") //@Validated表示要验证，bindingResult验证的信息
    public Result<Person> addPerson(@Valid Person person, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return null;
        }

        person.setName(person.getName());
        person.setAge(person.getAge());
        person.setScore(person.getScore());

        return ResultUtil.success(personRepository.save(person));

    }


    /**
     *@Description:  更新
     *@Author: Junno
     *@Date: 18-8-28
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
     *@Description: 根据id查询用户信息
     *@Author: Junno
     *@Date: 18-8-28
     */

    @GetMapping(value = "/person/{id}")
    public Person findOnePerson(@PathVariable("id") Integer id){
        return personRepository.findById(id).orElse(null);
    }


    
    /**
     *@Description: 删除一个用户
     *@Author: Junno
     *@Date: 18-8-28 下午3:04
     */

    @DeleteMapping(value = "/person/{id}")
    public void deletePerson(@PathVariable("id") Integer id){
        personRepository.deleteById(id);
    }


    /**
     *@Description: 通过年龄查询用户列表
     *@Author: Junno
     *@Date: 18-8-29 上午9:41
     */

    @GetMapping(value = "/person/age/{age}")
    public List<Person> personListByAge(@PathVariable("age") Integer age){
        return personRepository.findByAge(age);
    }



    /**
     *@Description: 通过id判断年龄，异常处理
     *@Author: Junno
     *@Date: 18-8-29 上午9:47
     */
    @GetMapping(value = "/person/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws  Exception {
         personService.getAge(id);
    }





}
