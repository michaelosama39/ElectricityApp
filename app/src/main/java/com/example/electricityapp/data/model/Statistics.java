package com.example.electricityapp.data.model;

public class Statistics {
    String Number;
    String Reading;
    String Date;

    public Statistics(String number, String reading, String date) {
        Number = number;
        Reading = reading;
        Date = date;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getReading() {
        return Reading;
    }

    public void setReading(String reading) {
        Reading = reading;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
