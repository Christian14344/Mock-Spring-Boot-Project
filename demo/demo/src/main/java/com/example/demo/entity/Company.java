package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

    @Id
    private int companyID;
    private String companyName;



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
