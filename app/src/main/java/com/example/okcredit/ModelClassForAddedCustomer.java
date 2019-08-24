package com.example.okcredit;

public class ModelClassForAddedCustomer {

    private String name;
    private int image;


    public ModelClassForAddedCustomer(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
