package com.geek.bottomnavigation.fragments;

public class Model {
    private String name;
    private String phoneNumber;

    public Model(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
