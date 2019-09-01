package com.example.okcredit;

import java.util.List;

public class ModelClassForAddedCustomer {

    private String name;
    private String mobile_number;
    private String time;
    private String totel_money;
    private String img;


    public ModelClassForAddedCustomer(String name, String mobile_number, String time, String totel_money, String user_img) {

        this.name = name;
        this.totel_money = totel_money;
        this.mobile_number = mobile_number;
        this.time = time;
        this.img = user_img;


    }

    public ModelClassForAddedCustomer(List<ModelClassForAddedCustomer> modelClassForAddedCustomers) {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotel_money() {
        return totel_money;
    }

    public void setTotel_money(String totel_money) {
        this.totel_money = totel_money;
    }
}
