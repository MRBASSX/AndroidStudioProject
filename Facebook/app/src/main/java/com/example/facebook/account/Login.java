package com.example.facebook.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.facebook.Home;
import com.example.facebook.R;
import com.example.facebook.ui.gallery.GalleryFragment;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    TextInputEditText email,password;
//    private FirebaseAuth mAuth;
//    mAuth = FirebaseAuth.getInstance();

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


            Toast.makeText(this, UserMail +" "+ UserPass, Toast.LENGTH_SHORT).show();

            if (UserPass.equals("Admin") && UserMail.equals("Admin@gmail.com")) {

//                mAuth.signInWithEmailAndPassword(UserMail,UserPass)
//        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//
//                    FirebaseUser user = mAuth.getCurrentUser();
//                    updateUI(user);
//                } else {
//                    Toast.makeText(CustomAuthActivity.this, String.valueOf(task.getException), Toast.LENGTH_SHORT).show();
//                    updateUI(null);
//                }
//            }
//        });
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);

            }else {

                Toast.makeText(this, "Wrong Credential", Toast.LENGTH_SHORT).show();

            }


        }else {


            Toast.makeText(this, "All Field Is Required", Toast.LENGTH_SHORT).show();
        }





    }

//    private void updateUI(FirebaseUser user) {
//    }


//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
//    }
}