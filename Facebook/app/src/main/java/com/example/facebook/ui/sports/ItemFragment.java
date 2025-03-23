package com.example.facebook.ui.sports;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.facebook.R;
import com.example.facebook.UserClasses.CustomModel;
import com.example.facebook.UserClasses.SelectedItem;
import com.example.facebook.databinding.FragmentHomeBinding;
import com.example.facebook.databinding.FragmentItemListBinding;
import com.example.facebook.ui.sports.placeholder.PlaceholderContent;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class ItemFragment extends Fragment  implements SelectedItem {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;

    ArrayList<PlaceholderContent> arrayList;
    FragmentItemListBinding binding;
    RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ItemFragment newInstance(int columnCount) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

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


            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), mColumnCount));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(arrayList,this));



        return root;
    }

    @Override
    public void OnItemSelected(PlaceholderContent customModel) {

    }
}