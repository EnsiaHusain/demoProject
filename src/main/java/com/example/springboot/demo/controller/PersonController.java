package com.example.springboot.demo.controller;

import com.example.springboot.demo.domain.Person;
import com.example.springboot.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/getById/{personId}")
    public Person fetchPerson(@PathVariable("personId") Long personId){
        return personService.getPerson(personId);
    }

    @PostMapping("/save")
    public void savePerson(@RequestBody Person person){
        personService.savePerson(person);
    }
}
