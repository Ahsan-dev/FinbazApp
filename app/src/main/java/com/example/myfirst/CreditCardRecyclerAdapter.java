package com.example.myfirst;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfirst.Models.CreditCardModel;
import com.example.myfirst.Models.SavingsAccountCardModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class CreditCardRecyclerAdapter extends RecyclerView.Adapter<CreditCardViewHolder> {

    private List<CreditCardModel> ccList;
    private Context context;

    public CreditCardRecyclerAdapter(List<CreditCardModel> ccList, Context context) {
        this.ccList = ccList;
        this.context = context;
    }

    @NonNull
    @Override
    public CreditCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.credit_card_item_layout,parent,false);
        return new CreditCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditCardViewHolder holder, int position) {

        final CreditCardModel cardModel = ccList.get(position);

        Picasso.get().load(cardModel.getCardLogoResource()).into(holder.creditCardImage);
        holder.creditCardTitle.setText(cardModel.getCardTitleResource());
        holder.cardRating.setRating(cardModel.getRatingNumber());
        holder.cardFyf.setText(cardModel.getFyf());
        holder.cardRf.setText(cardModel.getRf());
        if(cardModel.isFeatured()){
            holder.cardFeaturedText.setVisibility(View.VISIBLE);
        }else {
            holder.cardFeaturedText.setVisibility(View.GONE);

        }

        holder.cardtviewDetailsBTn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent carditDetailIntent = new Intent(context,CreditCardDetailsActivity.class);
                carditDetailIntent.putExtra("cardName",cardModel.getCardName());
                carditDetailIntent.putExtra("fromIntent",cardModel.getCreditParentPage());
                context.startActivity(carditDetailIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ccList.size();
    }
}
