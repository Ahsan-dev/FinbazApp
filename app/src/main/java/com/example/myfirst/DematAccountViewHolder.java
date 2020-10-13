package com.example.myfirst;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DematAccountViewHolder extends RecyclerView.ViewHolder {

    public TextView featuredText, accountTitle, dmatViewDetailsBtn, dmatApplyBtn;
    public ImageView companyLogo;
    public RatingBar dematRating;


    public DematAccountViewHolder(@NonNull View itemView) {
        super(itemView);

        featuredText = itemView.findViewById(R.id.demat_account_item_featured_text_id);
        accountTitle = itemView.findViewById(R.id.demat_account_item_account_title);
        dmatViewDetailsBtn = itemView.findViewById(R.id.demat_account_item_view_details_btn_id);
        dmatApplyBtn = itemView.findViewById(R.id.demat_account_item_apply_btn_id);
        companyLogo = itemView.findViewById(R.id.demat_account_item_company_logo);
        dematRating = itemView.findViewById(R.id.demat_account_item_rating_bar_id);


    }
}
