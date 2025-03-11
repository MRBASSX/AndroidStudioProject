package com.example.instagram;

import android.graphics.Bitmap;

public class CustomModel {

    String name;
    String title;
    String des;
    Bitmap image;

    public CustomModel(String name, String title, String des, Bitmap image) {
        this.name = name;
        this.title = title;
        this.des = des;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }




}
