package com.example.electricityapp.data.model;

public class Profile {
    String Number;
    String Company;
    String Name;
    String Region;
    String Home;
    String Floor;
    String Statistics;

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getHome() {
        return Home;
    }

    public void setHome(String home) {
        Home = home;
    }

    public String getFloor() {
        return Floor;
    }

    public void setFloor(String floor) {
        Floor = floor;
    }

    public String getStatistics() {
        return Statistics;
    }

    public void setStatistics(String statistics) {
        Statistics = statistics;
    }

    public Profile(String number, String company, String name, String region, String home, String floor, String statistics) {
        Number = number;
        Company = company;
        Name = name;
        Region = region;
        Home = home;
        Floor = floor;
        Statistics = statistics;
    }
}
