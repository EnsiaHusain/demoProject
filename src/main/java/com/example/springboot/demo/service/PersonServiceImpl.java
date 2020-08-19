package com.example.springboot.demo.service;

import com.example.springboot.demo.domain.Person;
import com.example.springboot.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void savePerson(Person person){

        personRepository.save(person);
    }

    @Override
    public Person getPerson(Long personId){
       Optional<Person> person =  personRepository.findById(personId);
       if(person.isPresent()){
           return person.get();
       }
       return null;
    }
}
