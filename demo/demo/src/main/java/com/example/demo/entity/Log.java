//package com.example.demo.entity;
//
//
//import jakarta.persistence.*;
//
//@Entity
//public class Log {
//
//    private String timeStamp;
//    private double longitude;
//    private double latitude;
//
//    @Id
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinTable(joinColumns = @JoinColumn(name="employee_id"))
//    private String id;
//
//
//    public Log(){
//
//    }
//
//    public Log(String timeStamp, double longitude, double latitude) {
//        this.timeStamp = timeStamp;
//        this.longitude = longitude;
//        this.latitude = latitude;
//    }
//
//    public String getTimeStamp() {
//        return timeStamp;
//    }
//
//    public double getLongitude() {
//        return longitude;
//    }
//
//    public double getLatitude() {
//        return latitude;
//    }
//
//    public void setTimeStamp(String timeStamp) {
//        this.timeStamp = timeStamp;
//    }
//
//    public void setLongitude(double longitude) {
//        this.longitude = longitude;
//    }
//
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
//}
