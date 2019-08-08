package com.example.okcredit;

public class ModelClass {

    int id;
    String amount;
    String discription;
    String side;

    public ModelClass(String amount, String side) {
        this.amount = amount;
        this.side = side;
    }

    public ModelClass(String j) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }
}
