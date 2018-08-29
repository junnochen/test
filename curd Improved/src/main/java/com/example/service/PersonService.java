package com.example.service;

import com.example.dao.PersonRepository;
import com.example.domain.Person;
import com.example.enums.ResultEnum;
import com.example.exception.PersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @program: curd
 * @description:
 * @author: Junno
 * @create: 2018-08-28 20:03
 **/
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;



    public void getAge(Integer id) throws PersonException{
        Optional<Person> optional = personRepository.findById(id);
        Integer age = optional.orElseGet(Person::new).getAge();
        if(age < 10){

//            返回“你还在上小学吧”code=100
            throw new PersonException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 && age<16){

//            返回“你还在上初中吧” code=101
            throw new PersonException(ResultEnum.MIDDLE_SCHOOL);
        }

    }


}
