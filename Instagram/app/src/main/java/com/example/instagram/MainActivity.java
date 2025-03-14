package com.example.instagram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.instagram.databinding.ActivityListBinding;
import com.example.instagram.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

//     ActivityMainBinding mainBinding;
     TextInputEditText name,email,password1,password2;
  Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        context = getActivity();

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password1 = findViewById(R.id.password1);
        password2 = findViewById(R.id.password2);






    }



    public void Regiters(View view){

        String username = String.valueOf(name.getText());
        String useremail = email.getText().toString();
        String userpass1 = password1.getText().toString();
        String userpass2 = password2.getText().toString();

        Toast.makeText(this, "HI", Toast.LENGTH_SHORT).show();

        Toast.makeText(MainActivity.this, username +" "+ username +" "+userpass1+ " "+userpass2, Toast.LENGTH_SHORT).show();


        if ((username.isEmpty() && useremail.isEmpty() && userpass1.isEmpty() && userpass2.isEmpty())) {

            Toast.makeText(MainActivity.this, "All Field Is Required", Toast.LENGTH_SHORT).show();

        }else {


            if ( useremail.contains("@") && (useremail.endsWith(".com") || useremail.endsWith(".gh")) ) {

                Toast.makeText(MainActivity.this, username + username + userpass1 + userpass2, Toast.LENGTH_LONG).show();

            }else{

                Toast.makeText(MainActivity.this, "Type A Valid Email", Toast.LENGTH_SHORT).show();
            }



        }
    }




    public  void  SignI(){

//        Intent intent = new Intent(context, List.class);
//        startActivity(intent);

//        BlankFragment blankFragment = new BlankFragment();
//        FragmentTransaction fragmentTransaction  = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.fragmentContainerView, blankFragment).commit();
    }


    @Override
    protected void onStart() {
        super.onStart();
        SignI() ;
    }
}