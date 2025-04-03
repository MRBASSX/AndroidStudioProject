package com.example.firebase.account;


import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.firebase.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.IOException;
import com.example.firebase.R;
public class Login extends AppCompatActivity {

    ActivityLoginBinding binding;
    Button btnbrowse, btnupload;
    EditText txtdata ;
    ImageView imgview;
    Uri FilePathUri;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    int Image_Request_Code = 7;
    ProgressDialog progressDialog ;
    LinearProgressIndicator linearProgressIndicator;
    CircularProgressIndicator circularProgressIndicator;
    ActivityResultLauncher<Intent> GallaryImage;
    Bitmap  imageToStore;
    uploadinfo imageUploadInfo;
    StorageReference storageReference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        storageReference = FirebaseStorage.getInstance().getReference("Images");
        databaseReference = FirebaseDatabase.getInstance().getReference("Images");
        btnbrowse = (Button)findViewById(R.id.btnbrowse);
        btnupload= (Button)findViewById(R.id.btnupload);
        txtdata = (EditText)findViewById(R.id.titledata);
        imgview = (ImageView)findViewById(R.id.images);
          linearProgressIndicator  = binding.LinearProgress;
        linearProgressIndicator.setIndicatorDirection(LinearProgressIndicator.INDICATOR_DIRECTION_RIGHT_TO_LEFT);
        linearProgressIndicator.setIndicatorColor(getResources().getColor(R.color.teal_200));
        linearProgressIndicator.setIndeterminate(true);


        circularProgressIndicator = binding.CircularProgress;
        circularProgressIndicator.setIndicatorDirection(CircularProgressIndicator.INDICATOR_DIRECTION_COUNTERCLOCKWISE);
        circularProgressIndicator.setIndicatorColor(getResources().getColor(R.color.black));
        circularProgressIndicator.setIndeterminate(true);
        circularProgressIndicator.setIndicatorSize(100);
        circularProgressIndicator.setTrackThickness(10);
        progressDialog = new ProgressDialog(this);// context name as per your project name
        storeGalaryImage();
    }


    public void  GetImage(View view){
        getGallaryImage();


    }

    public  void  getGallaryImage(){
        Intent intent =  new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        GallaryImage.launch(intent);
//       ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
//
//           @Override
//           public void onActivityResult(ActivityResult o) {
//
//           }
//       });
    }

    public  void storeGalaryImage(){

        GallaryImage = registerForActivityResult(new
                        ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {




                        try {
                            assert result.getData() != null;
                            FilePathUri = result.getData().getData();
                            imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(),FilePathUri);
                            imgview.setImageBitmap(imageToStore);

                        } catch (IOException e) {

                            Toast.makeText(getApplicationContext(), "Error Uploading", Toast.LENGTH_LONG).show();
                        }



                    }
                });
    }

    public String GetFileExtension(Uri uri) {

        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri)) ;

    }

    public void UploadImage(View view){

       try {

           UploadUploadToFirebase();

       }catch (Exception e){

           Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
       }
    }

    private void UploadUploadToFirebase() {
        if (FilePathUri != null) {

            progressDialog.setTitle("Image is Uploading...");
            progressDialog.show();
            linearProgressIndicator.setVisibility(View.VISIBLE);
            circularProgressIndicator.setVisibility(View.VISIBLE);




            storageReference2 = storageReference.child(System.currentTimeMillis()+"."+GetFileExtension(FilePathUri));
            storageReference2.putFile(FilePathUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            String TempImageName = txtdata.getText().toString().trim();

                            circularProgressIndicator.setVisibility(View.INVISIBLE);
                            linearProgressIndicator.setVisibility(View.INVISIBLE);

                            String imageUrl;
                            progressDialog.dismiss();
                            if (taskSnapshot.getMetadata().getReference() != null) {
                                Task<Uri> result = taskSnapshot.getStorage().getDownloadUrl();
                                result.addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        String imageUrl = uri.toString();
                                        imageUploadInfo = new uploadinfo(TempImageName,imageUrl);
                                        String ImageUploadId = databaseReference.push().getKey();
                                        databaseReference.child(ImageUploadId).setValue(imageUploadInfo);

                                        //createNewPost(imageUrl);
                                    }
                                });
                            }
                            Toast.makeText(getApplicationContext(), "Image Uploaded Successfully ", Toast.LENGTH_LONG).show();








                        }
                    });


        }
        else {

            Toast.makeText(getApplicationContext(), "Please Select Image or Add Image Name", Toast.LENGTH_LONG).show();

        }
    }

}

//https://stackoverflow.com/questions/50585334/tasksnapshot-getdownloadurl-method-not-working