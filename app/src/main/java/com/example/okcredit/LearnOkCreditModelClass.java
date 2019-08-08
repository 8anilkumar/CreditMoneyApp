package com.example.okcredit;

public class LearnOkCreditModelClass {
    private  int imageResourceclass;
    private  String maintitle;
    private  String submaintitle;


    public LearnOkCreditModelClass(int imageResourceclass, String maintitle, String submaintitle) {
        this.imageResourceclass = imageResourceclass;
        this.maintitle = maintitle;
        this.submaintitle = submaintitle;
    }
    public int getImageResourceclass() {
        return imageResourceclass;
    }

    public String getMaintitle() {
        return maintitle;
    }

    public String getSubmaintitle() {
        return submaintitle;
    }


}
