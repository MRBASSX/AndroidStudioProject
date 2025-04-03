package com.example.firebase.classes;

import android.content.Context;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.firebase.R;

import java.net.URI;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    Context context;
    CustomInterface selectedItem;
    ArrayList<CustomModel> arrayList;
    LayoutInflater layoutInflater;


    public CustomAdapter(ArrayList<CustomModel> arrayList, Context context, CustomInterface selectedItem) {
        this.arrayList = arrayList;
        this.context = context;
        this.selectedItem = selectedItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.custom_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CustomModel customModel = arrayList.get(position);
        holder.textView.setText(customModel.getImageName());
        Glide.with(context).load(customModel.getImageURL().trim()).into(holder.imageView);
//        Glide.with(context).load("https://moviegains.pythonanywhere.com/static/imagefolder/africa/africa%20(3).jpg").into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedItem.OnItemClick(customModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.images);
            textView = itemView.findViewById(R.id.titledata);


        }
    }
}
