package com.example.okcredit;

public class ModleClassPrivacyAndSecurity {
    private int imageResourceclass;
    private String maintitle;
    private String submaintitle;

    public ModleClassPrivacyAndSecurity(int imageResourceclass, String maintitle, String submaintitle) {
        this.imageResourceclass = imageResourceclass;
        this.maintitle = maintitle;
        this.submaintitle = submaintitle;
    }

    public int getImageResourceclass() {
        return imageResourceclass;
    }

    public void setImageResourceclass(int imageResourceclass) {
        this.imageResourceclass = imageResourceclass;
    }

    public String getMaintitle() {
        return maintitle;
    }

    public void setMaintitle(String maintitle) {
        this.maintitle = maintitle;
    }

    public String getSubmaintitle() {
        return submaintitle;
    }

    public void setSubmaintitle(String submaintitle) {
        this.submaintitle = submaintitle;
    }


}
