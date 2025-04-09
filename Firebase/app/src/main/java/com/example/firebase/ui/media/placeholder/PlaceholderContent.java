package com.example.firebase.ui.media.placeholder;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.firebase.Sqlite.AddData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlaceholderContent {
    public String imageName;
    public String imageURL;
    public static final List<PlaceholderContent> arrayList = Collections.emptyList();

    public PlaceholderContent(String imageName, String imageURL) {
        this.imageName = imageName;
        this.imageURL = imageURL;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }



}