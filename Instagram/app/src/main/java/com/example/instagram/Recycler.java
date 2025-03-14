package com.example.instagram;

import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


public class RecyclerView extends AppCompatActivity implements SelectedItem {

        RecyclerView recycler;
//    SearchView searchView;
//    ArrayList<CustomModel> itemIds;
//    CustomAdapter Apter;
//    ActivityRecyclerViewBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        recycler = findViewById(R.id.Data);
//        recycler =  binding.Data;
//        searchView = (SearchView) findViewById(R.id.mysearch2);
//        recycler.setLayoutManager(new GridLayoutManager(this,2));
//        recycler.setHasFixedSize(true);
//        itemIds = new ArrayList<CustomModel>();
//        itemIds.add(new CustomModel("Abass","THE","Men",1));
//        Apter = new CustomAdapter(itemIds,this,this);
//        recycler.setAdapter(Apter);
//        Apter.notifyDataSetChanged();
//        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onitemClick(CustomModel customData) {

    }
}