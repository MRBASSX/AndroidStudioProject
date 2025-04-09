package com.example.firebase.ui.media;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firebase.classes.CustomInterface;
import com.example.firebase.ui.media.placeholder.PlaceholderContent;
import com.example.firebase.databinding.FragmentMediaBinding;

import java.util.ArrayList;
import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<PlaceholderContent> mValues;
    CustomInterface customInterface;
    Context context;

    public MyItemRecyclerViewAdapter(ArrayList<PlaceholderContent> mValues, Context context, CustomInterface customInterface) {
        this.mValues = mValues;
        this.context = context;
        this.customInterface = customInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentMediaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        PlaceholderContent model = mValues.get(position);
        holder.name.setText(model.getImageName());
        holder.image_url.setText(model.getImageURL());
        holder.image_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customInterface.OnItemClick2(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView name;
        public final TextView image_url;


        public ViewHolder(FragmentMediaBinding binding) {
            super(binding.getRoot());
            name = binding.itemNumber;
            image_url = binding.content;
        }

    }
}