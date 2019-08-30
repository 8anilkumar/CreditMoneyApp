package com.example.okcredit;

import java.util.List;

public class ModelClassForAddedCustomer {
    private String user_img;
    private String name;
    private String status;
    private String totel_money;
    private String mobile_number;
    private String day;


    public ModelClassForAddedCustomer(String name, String status, String totel_money, String mobile_number, String day, String user_img) {

        this.name = name;
        this.status = status;
        this.totel_money = totel_money;
        this.mobile_number = mobile_number;
        this.day = day;
        this.user_img = user_img;


    }

    public ModelClassForAddedCustomer(List<ModelClassForAddedCustomer> modelClassForAddedCustomers) {
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotel_money() {
        return totel_money;
    }

    public void setTotel_money(String totel_money) {
        this.totel_money = totel_money;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }



}
