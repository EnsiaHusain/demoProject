package com.example.springboot.demo.service;

import com.example.springboot.demo.domain.Person;

public interface PersonService {

    void savePerson(Person person);

    Person getPerson(Long personId);

}
