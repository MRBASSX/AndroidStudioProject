package com.example.facebook.UserClasses;

public class CustomModel {

    private  String name;
    private  String desc;
    private  String title;
    private   int  image_url;



    public CustomModel(int image_url, String name, String desc, String title) {
        this.image_url = image_url;
        this.name = name;
        this.desc = desc;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage_url() {
        return image_url;
    }

    public void setImage_url(int image_url) {
        this.image_url = image_url;
    }
}
