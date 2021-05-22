package com.geek.bottomnavigation.fragments;

import java.io.Serializable;

public class Model implements Serializable {
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
