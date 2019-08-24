package com.example.okcredit;

public class HomepageModelClass {

    public static final int BALANCE_CHECK = 0;
    public static final int HOME_PAGE_BOTTOM_SETTING = 1;


    private int viewType;
    private int img_view;
    private String title;
    private String balance;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
///Balance layout

    public HomepageModelClass(int viewType, int img_view, String title, String balance) {
        this.img_view = img_view;
        this.title = title;
        this.balance = balance;
        this.viewType = viewType;
    }


    public int getImg_view() {
        return img_view;
    }

    public void setImg_view(int img_view) {
        this.img_view = img_view;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
///////Balance layout

    ///////Home page Bottom

    private int image_view;
    private String data;

    public HomepageModelClass(int viewType, int image_view, String data) {
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
