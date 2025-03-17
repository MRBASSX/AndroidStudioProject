package com.example.facebook.account;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.facebook.Home;
import com.example.facebook.R;
import com.example.facebook.databinding.ActivityRegisterBinding;
import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {


    ActivityRegisterBinding  binding;
    TextInputEditText email,password,cpassword;
    ProgressDialog progressDialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        email = binding.Email;
        password = binding.Password;
        cpassword = binding.Cpassword;







    }

    public  void SignUp(View view){



        String UserMail = email.getText().toString().trim();
        String UserPass = password.getText().toString().trim();
        String UserCPass = cpassword.getText().toString().trim();

        Boolean mail = UserMail.length() > 0;
        Boolean pass = UserPass.length() > 0;
        Boolean Cpass = UserCPass.length() > 0;


        if( mail && pass && Cpass){


           if (UserMail.contains("@") && UserMail.endsWith(".com")){

               if (UserPass.equals(UserCPass)) {

//                   progressDialog.setTitle("Registering.......");
//                   progressDialog.show();
                   Toast.makeText(this, UserMail +" "+UserPass+" "+UserCPass, Toast.LENGTH_SHORT).show();
                   FirebaseRegistration();
//                  progressDialog.dismiss();


               }else {

                   Toast.makeText(this, "Password Do Not Match", Toast.LENGTH_SHORT).show();

               }

           }else {

               Toast.makeText(this, "Type A Valid Email", Toast.LENGTH_SHORT).show();


           }


        }else {

            Toast.makeText(this, "All Field Is Required", Toast.LENGTH_SHORT).show();


        }



    }



    private void FirebaseRegistration(){

        Toast.makeText(this, "Welcome Home", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);

    }



}