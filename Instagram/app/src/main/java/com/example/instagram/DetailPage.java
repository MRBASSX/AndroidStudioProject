package com.example.instagram;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.instagram.databinding.ActivityDetailPageBinding;


import java.util.Locale;

public class DetailPage extends AppCompatActivity {

    ActivityDetailPageBinding listBinding;

  TextView name ,title ,desc;
  ImageView cover;
  WebView webview;

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listBinding = ActivityDetailPageBinding.inflate(getLayoutInflater());
        View view = listBinding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        String[] obj = intent.getStringArrayExtra("key");
        webview = listBinding.webview;
        name = listBinding.DetailName;
        name.setText(obj[0].toString());

        title = listBinding.TitleDetail;
        title.setText(obj[1].toString());

        desc = listBinding.DetailDesc;
        desc.setText(obj[2].toString().toLowerCase(Locale.ROOT));

        cover =listBinding.Detailimage;
        String ImageUrl = obj[3].toString();
        cover.setImageResource(Integer.parseInt(ImageUrl));

        String Url = obj[3].toString();

//        Using Html IFrame
        String html =  "<html> <head><title> Youtube </title>  </head> <body> " +
                "<iframe width=\"560\" height=\"315\" src=\""+Url+"\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
                + " </body>" +
                "</html> ";
//        webView.loadUrl("file:///android_asset/youtube.html",user);
        webview.loadData(html,"text/html","utf-1");




//        Glide.with(this).load(ImageUrl).into(cover);




    }









}