package com.example.okcredit;

import java.util.List;

public class ModelClassForAddedCustomer {

    private String name;
    private String status;
    private int totel_money;
    private String mobile_number;


    public ModelClassForAddedCustomer(String name, String status, int totel_money, String mobile_number) {
        this.name = name;
        this.status = status;
        this.totel_money = totel_money;
        this.mobile_number = mobile_number;

    }

    public ModelClassForAddedCustomer(List<ModelClassForAddedCustomer> modelClassForAddedCustomers) {
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

    public int getTotel_money() {
        return totel_money;
    }

    public void setTotel_money(int totel_money) {
        this.totel_money = totel_money;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }



}
