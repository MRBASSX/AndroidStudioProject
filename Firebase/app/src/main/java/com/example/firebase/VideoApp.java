package com.example.firebase;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URI;
import java.util.Objects;

public class VideoApp extends AppCompatActivity {
    ImageView imageView;
    VideoView videoView;
    Button button;
    ActivityResultLauncher<Intent> myresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_app);
        imageView = findViewById(R.id.profileimage);
        videoView = findViewById(R.id.videoView);
        button = findViewById(R.id.button);
        imageView.setImageResource(R.drawable.ic_launcher_background);

//        String imagePath = "android.resource://"+getPackageName()+"/"+R.raw.vedio;
//        Uri uri = Uri.parse(imagePath);
//        videoView.setVideoURI(uri);
//        videoView.setMediaController(new MediaController(this));
//        RegisterResult();
//        button.setOnClickListener(View ->pickImage());



//                String url = "https://" +"pending" + "?alt=media&token=sadftewfdteyterrteqwy";
//        String imagePath2 = "android.resource://"+getPackageName()+"/"+R.raw.vedio;
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagePath2));
//        intent.setDataAndType(Uri.parse(imagePath2),"video/*");
//        videoView.setVideoURI(Uri.parse(imagePath2));
//        videoView.setMediaController(new MediaController(this));
//        startActivity(intent);

        RegisterResult();
        button.setOnClickListener(View ->pickImage());

    }

    private void pickImage(){
        Intent intent = new Intent(MediaStore.ACTION_PICK_IMAGES);
        myresult.launch(intent);


    }
    private void RegisterResult(){
        myresult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                try {
                    Uri images = Objects.requireNonNull(result.getData()).getData();
                    imageView.setImageURI(images);



                }catch (Exception e){

                    Toast.makeText(getApplicationContext(), "File Selection Fail", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}