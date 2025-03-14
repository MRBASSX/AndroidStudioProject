package com.example.instagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{



    List<CustomModel> mydata;
    Context context;
    SelectedItem selectedItem;

//  DatabaseClass  databaseClass;

    public CustomAdapter(List<CustomModel> mydata, Context context ,SelectedItem selectedItem)  {
        this.mydata = mydata;
        this.context = context;
        this.selectedItem = selectedItem;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customlayout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CustomModel customData = mydata.get(position);
        // Get element from your dataset at th is position and replace the
        // contents of the view with that element
        holder.name.setText(customData.getName());
        holder.title.setText(customData.getTitle());
//        holder.image.setImageResource(customData.getImage());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedItem.onitemClick(customData);

            }
        });


    }




    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,title;
        ImageView image;
//        CardView cardView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            name = (TextView) view.findViewById(R.id.name);
            title = (TextView) view.findViewById(R.id.title);
//            image = (ImageView) view.findViewById(R.id.imageView);
//            cardView = (CardView) view.findViewById(R.id.MyContainer);

        }


    }


    @Override
    public int getItemCount() {
        return mydata.size();
    }

}
