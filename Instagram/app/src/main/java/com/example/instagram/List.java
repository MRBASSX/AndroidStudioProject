package com.example.instagram;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.instagram.databinding.ActivityListBinding;

public class List extends AppCompatActivity {
   ImageView imageView;
    ActivityListBinding listBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listBinding = ActivityListBinding.inflate(getLayoutInflater());
        View view = listBinding.getRoot();
        setContentView(view);

//        imageView =   findViewById(R.id.imageView4);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "I am An Image", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        listBinding.imageView4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "I am An Image", Toast.LENGTH_SHORT).show();
//            }
//        });
//
    }


//    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

//        MenuInflater flaterOject = getMenuInflater();
//        flaterOject.inflate(R.menu.list,menu);
        getMenuInflater().inflate(R.menu.list,menu);
        return true;
    }


    public void Profile(View view){

        Toast.makeText(this, "I am An Image", Toast.LENGTH_SHORT).show();

    }

    public void Profiles(){


    }






}