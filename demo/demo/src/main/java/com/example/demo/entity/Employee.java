package com.example.demo.entity;

import jakarta.persistence.*;

import lombok.ToString;


@Entity
@ToString
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = true)
    private String middleName;
    @Column(nullable = false)
    private String lastName;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinTable(joinColumns = @JoinColumn(name="companyid", unique = false)
//            , inverseJoinColumns = @JoinColumn(name = "credentials_id")
//    )
//    private Company company;


    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;



    public Employee(){

    }

    public Employee(int id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}


