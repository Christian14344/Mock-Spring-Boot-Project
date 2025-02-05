//package com.example.demo.entity;
//
//
//import jakarta.persistence.*;
//
//@Entity
//public class Credential {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String username;
//    private String password;
//
//    @OneToOne
//    @JoinColumn(name = "employee_id", nullable = false) // Correct the join column
//    private Employee employee; // Instead of String id, use Employee
//
//    public Credential() {
//
//    }
//
//    public Credential(int id, String username, String password, Employee employee) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.employee = employee;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//}
