package com.example.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebook.UserClasses.CustomAdapter;
import com.example.facebook.UserClasses.SelectedItem;
import com.example.facebook.ui.sports.placeholder.PlaceholderContent;

import java.util.ArrayList;

public class RecyclerDisplay extends AppCompatActivity implements SelectedItem{

    RecyclerView recyclerView;
    ArrayList<PlaceholderContent>  arrayList,arrayList2;
    CustomAdapter adapter,adapter2;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        searchView = findViewById(R.id.CustomSearch);
        recyclerView = findViewById(R.id.CustomRecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);
        arrayList = new ArrayList<>();
        arrayList.add(new PlaceholderContent(R.drawable.product1,"Camera","Good Camera","Images"));
        arrayList.add(new PlaceholderContent(R.drawable.product2,"Shirt","Good Camera","Images"));
        arrayList.add(new PlaceholderContent(R.drawable.product3,"Lamps","Good Camera","Images"));
        arrayList.add(new PlaceholderContent(R.drawable.product4,"Shoes","Good Camera","Images"));
        arrayList.add(new PlaceholderContent(R.drawable.product5,"Drones","Good Camera","Images"));
        arrayList.add(new PlaceholderContent(R.drawable.product6,"SmartWatch","Good Camera","Images"));
        arrayList.add(new PlaceholderContent(R.drawable.product7,"Tshirt","Good Camera","Images"));
        arrayList.add(new PlaceholderContent(R.drawable.product8,"Cream","Good Camera","Images"));
        arrayList.add(new PlaceholderContent(R.drawable.product9,"Chair","Good Camera","Images"));
        adapter = new CustomAdapter(this,arrayList,this);
        recyclerView.setAdapter(adapter);
        SearchViews();
    }

    @Override
    public void OnItemSelected(PlaceholderContent custom) {


        String[] Product = {custom.getName(),custom.getDesc(),custom.getTitle(),String.valueOf(custom.getImage_url())};
        Toast.makeText(this, custom.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), DetailPage.class);
        intent.putExtra("product",Product);
        startActivity(intent);
    }


    private void SearchViews(){

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                FilterLister(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                FilterLister(s);
                return false;
            }
        });

    }

    private void FilterLister(String text) {
        arrayList2 = new ArrayList<>();
        for (PlaceholderContent object: arrayList ){

           if(object.getName().toLowerCase().contains(text.toLowerCase())){

               arrayList2.add(object);

           }

        }

        if (arrayList2.isEmpty()){

            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        }else {

            adapter2 = new CustomAdapter(this,arrayList2,this);
            recyclerView.setAdapter(adapter2);
        }

    }
}