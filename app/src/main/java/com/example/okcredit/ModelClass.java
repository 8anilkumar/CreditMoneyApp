package com.example.okcredit;

public class ModelClass {

    public static final int LEFT_SIDE_DATA = 0;
    public static final int RIGHT_SIDE_DATA = 1;


    private int viewType;
    private String amount;
    private String balance;
    private String discription;
    private String mobile;
    private int status;


    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
///LEFT_SIDE_DATA


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public ModelClass(String amount, String discription, int viewType, String mobile) {
        this.amount = amount;
        this.discription = discription;
        this.balance = balance;
        this.viewType = viewType;
        this.mobile = mobile;

    }


    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String title) {
        this.amount = title;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
    ///////LEFT_SIDE_DATA

    ///////RIGHT_SIDE_DATA

    private int image_view;
    private String data;


    public ModelClass(int viewType, String data) {
        this.image_view = image_view;
        this.data = data;
        this.viewType = viewType;


    }


    public int getImage_view() {
        return image_view;
    }

    public void setImage_view(int image_view) {
        this.image_view = image_view;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
