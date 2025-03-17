package com.example.instagram;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.instagram.databinding.ActivityListBinding;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;

public class List extends AppCompatActivity {
   ImageView imageView;
    ActivityListBinding listBinding;

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listBinding = ActivityListBinding.inflate(getLayoutInflater());
        View view = listBinding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
       String[] obj = intent.getStringArrayExtra("key");
        Toast.makeText(this,obj[0].toString(),Toast.LENGTH_SHORT).show();

    }









}