package com.example.electricityapp.data.model;

public class Information {
    int date;
    int reading;
    int idNumber;

    public Information(){

    }

    public Information(int date, int reading, int idNumber) {
        this.date = date;
        this.reading = reading;
        this.idNumber = idNumber;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getReading() {
        return reading;
    }

    public void setReading(int reading) {
        this.reading = reading;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
}