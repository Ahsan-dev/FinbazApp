package com.example.myfirst;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfirst.Models.SavingsAccountCardModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;




public class SavingsAccountCardRecyclerAdapter extends RecyclerView.Adapter<SavingsAccountViewHolder> {

    private List<SavingsAccountCardModel> saList;
    private Context context;

    public SavingsAccountCardRecyclerAdapter(List<SavingsAccountCardModel> saList, Context context) {
        this.saList = saList;
        this.context = context;
    }

    @NonNull
    @Override
    public SavingsAccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.savings_account_item_layout,parent,false);
        return new SavingsAccountViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SavingsAccountViewHolder holder, int position) {

        final SavingsAccountCardModel saAccModel = saList.get(position);

        Picasso.get().load(saAccModel.getBankLogoResource()).into(holder.bankLogoImage);
        holder.saBankTitle.setText(saAccModel.getBankTitleResource());
        if(saAccModel.isFeatured()){

            holder.featuredText.setVisibility(View.VISIBLE);

        }else {

            holder.featuredText.setVisibility(View.GONE);

        }

        holder.irTxt.setText(saAccModel.getIr());
        holder.mbTxt.setText(saAccModel.getMb());
        holder.aocTxt.setText(saAccModel.getAoc());

        holder.cardRatingBar.setRating(saAccModel.getRatingNumber());
        holder.detailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bankDetailIntent = new Intent(context,SavingsBankDetailsActivity.class);
                bankDetailIntent.putExtra("bankName",saAccModel.getBankname());
                bankDetailIntent.putExtra("fromIntent",saAccModel.getParentPage());
                context.startActivity(bankDetailIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return saList.size();
    }
}
