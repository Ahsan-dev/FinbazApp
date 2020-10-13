package com.example.myfirst;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfirst.Models.DematAccountCardModel;
import com.example.myfirst.Models.SavingsAccountCardModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class DematAccountCardRecyclerAdapter extends RecyclerView.Adapter<DematAccountViewHolder> {

    private List<DematAccountCardModel> daList;
    private Context context;

    public DematAccountCardRecyclerAdapter(List<DematAccountCardModel> daList, Context context) {
        this.daList = daList;
        this.context = context;
    }


    @NonNull
    @Override
    public DematAccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.demat_account_item_layout,parent,false);
        return new DematAccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DematAccountViewHolder holder, int position) {

        final DematAccountCardModel dmat = daList.get(position);
        holder.accountTitle.setText(dmat.getAccountTitleResource());
        Picasso.get().load(dmat.getCompanyLogoResource()).into(holder.companyLogo);
        if(dmat.isFeatured()){

            holder.featuredText.setVisibility(View.VISIBLE);

        }else {

            holder.featuredText.setVisibility(View.GONE);

        }

        holder.dematRating.setRating(dmat.getRatingNumber());
        holder.dmatViewDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent companyDetailIntent = new Intent(context,DematDetailsActivity.class);
                companyDetailIntent.putExtra("companyName",dmat.getCompanyName());
                context.startActivity(companyDetailIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return daList.size();
    }
}
