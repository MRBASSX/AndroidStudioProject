package com.example.facebook.UserClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebook.R;
import com.example.facebook.ui.sports.placeholder.PlaceholderContent;

import java.util.ArrayList;

public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    Context context;
    ArrayList<PlaceholderContent> list;
    SelectedItem selectedItem;

    public CustomAdapter(Context context, ArrayList<PlaceholderContent> list, SelectedItem selectedItem) {
        this.context = context;
        this.list = list;
        this.selectedItem = selectedItem;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.custom_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        PlaceholderContent customModel =  list.get(position);
        holder.imageView.setImageResource(customModel.getImage_url());
        holder.textView.setText(customModel.getName());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedItem.OnItemSelected(customModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.CustomImage);
            textView = itemView.findViewById(R.id.CustomName);
        }
    }
}
