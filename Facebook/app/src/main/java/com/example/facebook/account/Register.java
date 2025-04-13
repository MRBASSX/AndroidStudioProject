package com.example.facebook.account;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.facebook.Home;
import com.example.facebook.R;
import com.example.facebook.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {


    ActivityRegisterBinding  binding;
    TextInputEditText email,password,cpassword;
    ProgressDialog progressDialog ;
    private FirebaseAuth mAuth;


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

                 try{
                   mAuth.createUserWithEmailAndPassword(UserMail,UserPass)
                           .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   if (task.isSuccessful()) {

                                       FirebaseUser user = mAuth.getCurrentUser();
                                       updateUI(user);
                                   } else {
                                       Toast.makeText(getApplicationContext(), String.valueOf(task.getException()), Toast.LENGTH_SHORT).show();
                                       updateUI(null);
                                   }
                               }
                           });
               } catch (Exception e) {
                   Toast.makeText(this, String.valueOf(e), Toast.LENGTH_SHORT).show();
               }

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




    private void updateUI(FirebaseUser user) {
        Toast.makeText(this, "Welcome Home", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
    }



    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        try {
            FirebaseUser currentUser = mAuth.getCurrentUser();
            updateUI(currentUser);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


}