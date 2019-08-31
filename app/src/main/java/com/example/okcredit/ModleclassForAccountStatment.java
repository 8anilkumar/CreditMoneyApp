package com.example.okcredit;



public class ModleclassForAccountStatment {

    public static final int LEFT_SIDE_DATA = 0;
    public static final int RIGHT_SIDE_DATA = 1;


    private int viewType;
    private String amount;
    private String name;
    private String status;
    private String time;
    private String date;
    private String data;


    public ModleclassForAccountStatment(String amount, String name, int viewType, String paymenttype, String date) {
        this.amount = amount;
        this.name = name;
        this.status = paymenttype;
        this.viewType = viewType;
        this.date = date;


    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }


    public String getName() {
        return name;
    }

    public void setName(String discription) {
        this.name = discription;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String title) {
        this.amount = title;
    }





    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }




    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
