package com.example.springboot.demo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Person {

    private String firstName;
    private String lastName;
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;

    //@JsonIgnore
    @JsonManagedReference
    @OneToOne(cascade =  CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "licenseId")
    private License license;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }
}
