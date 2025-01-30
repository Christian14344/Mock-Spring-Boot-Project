//package com.example.demo.entity;
//
//
//import jakarta.persistence.*;
//
//@Entity
//public class Credential {
//
//    private String username;
//    private String password;
//
//    @Id
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(joinColumns = @JoinColumn(name="employee_id"))
//    private String id;
//    @OneToOne(cascade = CascadeType.ALL)
//    private String companyID;
//
//    public Credential() {
//
//    }
//
//    public Credential(String username, String password) {
//        this.username = username;
//        this.password = password;
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
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}
