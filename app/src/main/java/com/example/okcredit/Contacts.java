package com.example.okcredit;

public class Contacts {
    String name;
    String phone;
   int imgURL;

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
