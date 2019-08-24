package com.example.okcredit;

public class ModelHelpClass {

    public static final int BALANCE_CHECK = 0;
    public static final int HOME_PAGE_BOTTOM_SETTING = 1;

    private int viewType;
    private  int imageResource;
    private  String title;
    private  String subtitle;


    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }


//////////RightLayout

    public ModelHelpClass(int viewType, String title, String subtitle) {

        this.title = title;
        this.subtitle = subtitle;
        this.viewType = viewType;
    }
    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }


    public String getSubtitle() {
        return subtitle;
    }

    ////////LeftLayout

    private String data;

    public ModelHelpClass(int viewType, String data) {
        this.data = data;
        this.viewType = viewType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
