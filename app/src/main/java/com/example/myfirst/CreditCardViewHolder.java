package com.example.myfirst;

import android.support.v4.media.session.IMediaControllerCallback;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CreditCardViewHolder extends RecyclerView.ViewHolder {

    public ImageView creditCardImage;
    public TextView creditCardTitle;
    public TextView cardFyf, cardRf;
    public TextView cardtviewDetailsBTn, cardApplyBtn;
    public TextView cardFeaturedText;
    public RatingBar cardRating;

    public CreditCardViewHolder(@NonNull View itemView) {
        super(itemView);

        creditCardImage = itemView.findViewById(R.id.credit_card_item_card_image);
        creditCardTitle = itemView.findViewById(R.id.credit_card_item_card_title);
        cardFyf = itemView.findViewById(R.id.credit_card_item_fyf_txt_id);
        cardRf = itemView.findViewById(R.id.credit_card_item_rf_txt_id);
        cardtviewDetailsBTn = itemView.findViewById(R.id.credit_card_item_view_details_btn_id);
        cardApplyBtn = itemView.findViewById(R.id.credit_card_item_apply_btn_id);
        cardFeaturedText = itemView.findViewById(R.id.credit_card_item_featured_text_id);
        cardRating = itemView.findViewById(R.id.credit_card_item_rating_bar_id);


    }
}
