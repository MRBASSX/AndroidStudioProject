package com.example.instagram;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class Recycler extends AppCompatActivity implements SelectedItem {

    RecyclerView recycler;
    SearchView searchView;
    ArrayList<CustomModel> itemIds;
    CustomAdapter Apter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        searchView = findViewById(R.id.mysearch2);
        recycler = findViewById(R.id.RecyclerId);
        recycler.setLayoutManager(new GridLayoutManager(this,2));
        recycler.setHasFixedSize(true);
        itemIds = new ArrayList<CustomModel>();

        itemIds.add(new CustomModel("Iddrisu","THE","Men",11));
        itemIds.add(new CustomModel("Abass","THE","Men",11));
        itemIds.add(new CustomModel("Giscard","THE","Men",11));

        Apter = new CustomAdapter(itemIds,this,this);
        recycler.setAdapter(Apter);
        SearchQuery();
//        Apter.notifyDataSetChanged();

    }

    @Override
    public void onitemClick(CustomModel customData) {

        Intent intent = new Intent(getApplicationContext(),List.class);
        String[] product = {customData.getName(),customData.getTitle(),customData.getDes(),String.valueOf(customData.getImage())};
        intent.putExtra("key",product);
        startActivity(intent);

    }


    private void filterList(String text) {

        ArrayList<CustomModel> filteredList = new ArrayList<>();

        for (CustomModel EachData : itemIds) {

            if (EachData.getName().contains(text)) {

                filteredList.add(EachData);

            }
            ;

        }
        if (filteredList.isEmpty()) {

            Toast.makeText(this, "That All "+ text, Toast.LENGTH_SHORT).show();
        } else {
            CustomAdapter myadapter2 = new CustomAdapter(filteredList, this, this);

            recycler.setAdapter(myadapter2);

        }


    }


    public void SearchQuery(){

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterList(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);

                return false;
            }
        });

    }
}