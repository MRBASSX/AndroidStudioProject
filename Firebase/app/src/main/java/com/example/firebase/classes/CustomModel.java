package com.example.firebase.classes;

public class CustomModel {

    public String imageName;
    public String imageURL;
    public CustomModel(){}

    public CustomModel(String name, String url) {
        this.imageName = name;
        this.imageURL = url;
    }

    public String getImageName() {

        return imageName;
    }
    public String getImageURL() {

        return imageURL;
    }
}
