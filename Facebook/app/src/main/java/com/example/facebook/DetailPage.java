package com.example.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailPage extends AppCompatActivity {
  TextView textView;
  ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.NameDetail);
        imageView = findViewById(R.id.ImageDetail);
        Intent intent = getIntent();
        String product[]  = intent.getStringArrayExtra("product");

      String name =   product[0];
      textView.setText(name);
      String Desc =   product[1];
      String title =   product[2];
      String image =   product[3];
      imageView.setImageResource(Integer.parseInt(image));

    }
}