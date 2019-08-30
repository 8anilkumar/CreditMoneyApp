package com.example.okcredit;

public class Contacts {
    String name;
    String phone;
    String side;
    int imgURL;

    public String getSide() {
        return side;
    }


    public Contacts(String name, String side) {
        this.name = name;
        this.side = side;
    }

    public Contacts() {

    }


    public int getImgURL(){
        return imgURL;
    }

    public void setImgURL(int imgURL){

        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
