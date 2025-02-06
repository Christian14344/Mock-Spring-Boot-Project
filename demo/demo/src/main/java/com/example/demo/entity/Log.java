package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generating the primary key
    private int id; // This will serve as the primary key for the Log entity

    private String timeStamp;
    private double longitude;
    private double latitude;


    //    @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false) // Correct the join column
    private Employee employee; // Instead of String id, use Employee

    public Log() {
    }

    public Log(String timeStamp, double longitude, double latitude, Employee employee) {
        this.timeStamp = timeStamp;
        this.longitude = longitude;
        this.latitude = latitude;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
