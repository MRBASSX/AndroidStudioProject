package com.example.facebook.ui.sports;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.facebook.DetailPage;
import com.example.facebook.R;
import com.example.facebook.UserClasses.CustomAdapter;
import com.example.facebook.UserClasses.CustomModel;
import com.example.facebook.UserClasses.SelectedItem;
import com.example.facebook.databinding.FragmentHomeBinding;
import com.example.facebook.databinding.FragmentItemListBinding;
import com.example.facebook.ui.home.HomeFragment;
import com.example.facebook.ui.sports.placeholder.PlaceholderContent;

import java.util.ArrayList;


public class ItemFragment extends Fragment  implements SelectedItem {


    private int mColumnCount = 2;
    ArrayList<PlaceholderContent>  arrayList,arrayList2;
    CustomAdapter adapter,adapter2;
    SearchView searchView;
    FragmentItemListBinding binding;
    RecyclerView recyclerView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentItemListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
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
        // Set the adapter

         recyclerView = binding.CustomRecycler;
         searchView  = binding.CustomSearch;


            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), mColumnCount));
            }
            recyclerView.setAdapter(new CustomAdapter(getActivity(),arrayList,this));
            SearchViews();


              return root;
    }

    @Override
    public void OnItemSelected(PlaceholderContent custom) {

        String[] Product = {custom.getName(),custom.getDesc(),custom.getTitle(),String.valueOf(custom.getImage_url())};
        Toast.makeText(getActivity(), custom.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), DetailPage.class);
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

            Toast.makeText(getActivity(), "Not Found", Toast.LENGTH_SHORT).show();
        }else {

            adapter2 = new CustomAdapter(getActivity(),arrayList2,this);
            recyclerView.setAdapter(adapter2);
        }

    }
}