package com.example.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase.account.Login;
import com.example.firebase.classes.CustomAdapter;
import com.example.firebase.classes.CustomInterface;
import com.example.firebase.classes.CustomModel;
import com.example.firebase.databinding.ActivityRecyclerListBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RecyclerList extends AppCompatActivity  implements CustomInterface {

    ActivityRecyclerListBinding binding;
    RecyclerView recyclerView;
    ArrayList<CustomModel> arrayList;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        recyclerView = binding.recycler;
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setHasFixedSize(true);
        FirebaseData();
        customAdapter = new CustomAdapter(arrayList,this,this);
        customAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(customAdapter);


    }

    @Override
    public void OnItemClick(CustomModel customModel) {

        Toast.makeText(this, customModel.getImageName(), Toast.LENGTH_SHORT).show();


    }


    public void FirebaseData(){
        arrayList = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Images");

        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


             for (DataSnapshot model: snapshot.getChildren()){
                 CustomModel customModel = model.getValue(CustomModel.class);
                 arrayList.add(customModel);

             }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(RecyclerList.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public  void AddRecord(View view){
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }
}