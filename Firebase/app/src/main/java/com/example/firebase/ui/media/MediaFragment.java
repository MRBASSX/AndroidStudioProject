package com.example.firebase.ui.media;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.firebase.MainActivity;
import com.example.firebase.R;
import com.example.firebase.RecyclerList;
import com.example.firebase.classes.CustomInterface;
import com.example.firebase.classes.CustomModel;
import com.example.firebase.databinding.FragmentGalleryBinding;
import com.example.firebase.databinding.FragmentMediaBinding;
import com.example.firebase.databinding.FragmentMediaListBinding;
import com.example.firebase.ui.media.placeholder.PlaceholderContent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class MediaFragment extends Fragment  implements CustomInterface {

    FragmentMediaListBinding binding;
    RecyclerView recyclerView;
    ArrayList<PlaceholderContent>  arrayList;
    MyItemRecyclerViewAdapter  Adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMediaListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = binding.recycler;
        MainActivity mainActivity = new MainActivity();
        mainActivity.FirebaseData();
        // Set the adapter
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        Adapter =  new MyItemRecyclerViewAdapter(mainActivity.FirebaseData(),getActivity(),this);
        recyclerView.setAdapter(Adapter);
        Adapter.notifyDataSetChanged();
        return root;
    }

//    public void FirebaseData(){
//        arrayList = new ArrayList<PlaceholderContent>();
//
//        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Images");
//
//        myRef.addValueEventListener(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//
//                for (DataSnapshot model: snapshot.getChildren()){
//                    PlaceholderContent customModel = model.getValue(PlaceholderContent.class);
//                    arrayList.add(customModel);
//                    Adapter.notifyDataSetChanged();
//
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//
//            }
//        });
//    }


    @Override
    public void OnItemClick(CustomModel customModel) {

    }

    @Override
    public void OnItemClick2(PlaceholderContent customModel) {

    }


}