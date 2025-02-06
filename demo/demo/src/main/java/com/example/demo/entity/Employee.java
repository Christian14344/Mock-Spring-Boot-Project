<<<<<<< HEAD
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
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;



    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;



    public Employee(){

    }

    public Employee(int id, String firstName, String middleName, String lastName, String userName, String password, Company company) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.company = company;
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

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Company getCompany() {
        return company;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCompany(Company company) {
        this.company = company;
    }



}


=======
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
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;



    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;



    public Employee(){

    }

    public Employee(int id, String firstName, String middleName, String lastName, String userName, String password, Company company) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.company = company;
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

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Company getCompany() {
        return company;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCompany(Company company) {
        this.company = company;
    }



}


>>>>>>> 269c967 (updated files)
