package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    private int companyID;
    private String companyName;


    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    public Company() {

    }

    public Company(String companyName, int companyID) {
        this.companyName = companyName;
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }
}
