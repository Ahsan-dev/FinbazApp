package com.example.myfirst;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class SavingsAccountViewHolder extends RecyclerView.ViewHolder {

    public TextView featuredText, saBankTitle, irTxt, mbTxt, aocTxt, applyBtn, detailsBtn;
    public RatingBar cardRatingBar;
    public ImageView bankLogoImage;


    public SavingsAccountViewHolder(@NonNull View itemView) {
        super(itemView);

        featuredText = itemView.findViewById(R.id.savings_account_item_featured_text_id);
        saBankTitle = itemView.findViewById(R.id.savings_account_item_bank_title);
        irTxt = itemView.findViewById(R.id.savings_account_item_interest_rate_txt_id);
        mbTxt = itemView.findViewById(R.id.savings_account_item_minimum_balance_txt_id);
        aocTxt = itemView.findViewById(R.id.savings_account_item_aoc_txt_id);
        cardRatingBar = itemView.findViewById(R.id.savings_account_item_rating_bar_id);
        bankLogoImage = itemView.findViewById(R.id.savings_account_item_bank_logo);
        applyBtn = itemView.findViewById(R.id.savings_account_item_apply_btn_id);
        detailsBtn = itemView.findViewById(R.id.savings_account_item_view_details_btn_id);




    }
}
