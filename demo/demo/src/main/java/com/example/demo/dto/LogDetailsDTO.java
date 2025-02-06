package com.example.demo.dto;

public class LogDetailsDTO {

    private int logId;
    private String timeStamp;
    private double longitude;
    private double latitude;
    private int employeeId;
    private String employeeFirstName;
    private String employeeMiddleName;
    private String employeeLastName;
    private String employeeUserName;

    public LogDetailsDTO(int logId, String timeStamp, double longitude, double latitude, int employeeId, String employeeFirstName, String employeeMiddleName, String employeeLastName, String employeeUserName) {
        this.logId = logId;
        this.timeStamp = timeStamp;
        this.longitude = longitude;
        this.latitude = latitude;
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeMiddleName = employeeMiddleName;
        this.employeeLastName = employeeLastName;
        this.employeeUserName = employeeUserName;
    }

    // Getters and setters

    public int getLogId() {
        return logId;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeMiddleName() {
        return employeeMiddleName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public String getEmployeeUserName() {
        return employeeUserName;
    }


    public void setLogId(int logId) {
        this.logId = logId;
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

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public void setEmployeeMiddleName(String employeeMiddleName) {
        this.employeeMiddleName = employeeMiddleName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public void setEmployeeUserName(String employeeUserName) {
        this.employeeUserName = employeeUserName;
    }
}

