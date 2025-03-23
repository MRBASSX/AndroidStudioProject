package com.example.facebook.ui.sports;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.facebook.R;
import com.example.facebook.UserClasses.SelectedItem;
import com.example.facebook.ui.sports.placeholder.PlaceholderContent;
import com.example.facebook.databinding.FragmentItemBinding;
import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderContent> mValues;
    SelectedItem selectedItem;

    public MyItemRecyclerViewAdapter(List<PlaceholderContent> items,SelectedItem selectedItem) {

        this.mValues = items;
        this.selectedItem = selectedItem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        PlaceholderContent content= mValues.get(position);
        holder.imageView.setImageResource(content.getImage_url());
        holder.textView.setText(content.getName());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedItem.OnItemSelected(content);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;


        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            imageView = binding.CustomImage;
            textView = binding.CustomName;

        }


    }
}