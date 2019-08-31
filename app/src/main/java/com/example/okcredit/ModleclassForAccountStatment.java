package com.example.okcredit;



public class ModleclassForAccountStatment {

    public static final int LEFT_SIDE_DATA = 0;
    public static final int RIGHT_SIDE_DATA = 1;


    private int viewType;
    private String amount;
    private String discription;
    private String status;
    private String time;
    private String date;
    private String data;



    public ModleclassForAccountStatment(String amount, String discription, int viewType, String paymenttype, String date) {
        this.amount = amount;
        this.discription = discription;
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
