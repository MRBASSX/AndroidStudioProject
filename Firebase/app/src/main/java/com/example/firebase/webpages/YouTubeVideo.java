package com.example.firebase.webpages;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.firebase.R;

import java.util.HashMap;
import java.util.Map;

public class YouTubeVideo extends AppCompatActivity {

    WebView webView;
    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_you_tube_video);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        webView = findViewById(R.id.webView);
//        webView.loadUrl("file:///android_asset/youtube.html");
        Map<String, String> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", "1815");

        String Url = "https://www.youtube.com/embed/DeBNMd2xA2w?si=Fhg0XXjmrfbUVIai";

        String html =  "<html> <head><title> Youtube </title>  </head> <body> " +
                "<iframe width=\"560\" height=\"315\" src=\""+Url+"\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
               + " </body>" +
                "</html> ";

//        webView.loadUrl("file:///android_asset/youtube.html",user);
        webView.getSettings().getJavaScriptEnabled();
//        webView.addJavascriptInterface(new WebViewClient(),"");
        webView.loadData(html,"text/html","UTF-8");
        webView.loadUrl(html);

//
    }
}