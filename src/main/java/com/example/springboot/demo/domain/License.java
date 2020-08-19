package com.example.springboot.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class License {

    private Date expiryDate;
    private Date startDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "licenseId")
    private Long licenseId;

    //@JsonIgnore
    @JsonBackReference
    @OneToOne(mappedBy = "license")
    private Person person;

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
