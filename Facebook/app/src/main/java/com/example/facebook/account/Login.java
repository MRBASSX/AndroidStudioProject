package com.example.facebook.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.facebook.Home;
import com.example.facebook.R;
import com.example.facebook.ui.gallery.GalleryFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    TextInputEditText email,password;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);


    }


    public void SignIn(View view){

        String UserMail = email.getText().toString().trim();
        String UserPass = password.getText().toString().trim();


        Boolean pass = UserPass.length() > 0;
        Boolean user = UserMail.length() > 0;

//        Toast.makeText(this, pass+" "+ user, Toast.LENGTH_SHORT).show();

        if (pass.booleanValue() && user.booleanValue()) {

            try {
                mAuth.signInWithEmailAndPassword(UserMail,UserPass)
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


            Toast.makeText(this, "All Field Is Required", Toast.LENGTH_SHORT).show();
        }





    }

    private void updateUI(FirebaseUser user) {
        try {
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
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