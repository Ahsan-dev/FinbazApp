package com.example.myfirst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomListItemAdapter extends RecyclerView.Adapter<CustomItemViewHolder> {

    private List<String> featureList;
    private Context context;

    public CustomListItemAdapter(List<String> featureList, Context context) {
        this.featureList = featureList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_list_item_layout,parent,false);
        return new CustomItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomItemViewHolder holder, int position) {
        Picasso.get().load(R.drawable.list_arrow).into(holder.arrowImg);
        holder.listItemText.setText(featureList.get(position));


    }

    @Override
    public int getItemCount() {
        return featureList.size();
    }
}
