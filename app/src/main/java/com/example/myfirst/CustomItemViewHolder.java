package com.example.myfirst;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomItemViewHolder extends RecyclerView.ViewHolder {
    public ImageView arrowImg;
    public TextView listItemText;
    public CustomItemViewHolder(@NonNull View itemView) {
        super(itemView);
        arrowImg = itemView.findViewById(R.id.custom_list_item_img);
        listItemText = itemView.findViewById(R.id.custom_list_item_text);

    }
}
