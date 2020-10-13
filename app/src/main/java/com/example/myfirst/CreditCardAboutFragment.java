package com.example.myfirst;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreditCardAboutFragment extends Fragment {

    private TextView cardAboutTitleText;
    private View view;
    private String cardName;
    private RecyclerView cardAboutRecycler;
    private List<String> cardAboutList;


    public CreditCardAboutFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_credit_card_about, container, false);

        cardName = getArguments().getString("cardName");

        cardAboutTitleText = view.findViewById(R.id.credit_card_details_about_title_id);
        cardAboutRecycler = view.findViewById(R.id.credit_card_details_about_recyclerId);
        cardAboutList = new ArrayList<>();

        if(cardName.equals("saveSbi")){

            cardAboutTitleText.setText(R.string.simply_save_svi_about_title);
            cardAboutTitleText.setTypeface(null, Typeface.BOLD);
            cardAboutList.addAll(Arrays.asList(getResources().getStringArray(R.array.simply_save_svi_about_array)));

        }
        if(cardName.equals("clickSbi")){

            cardAboutTitleText.setVisibility(View.GONE);
            cardAboutList.addAll(Arrays.asList(getResources().getStringArray(R.array.simply_click_about_array)));

        }
        if(cardName.equals("rblShop")){

            cardAboutTitleText.setVisibility(View.GONE);
            cardAboutList.addAll(Arrays.asList(getResources().getStringArray(R.array.shop_rbl_about_array)));

        }

        CustomListItemAdapter adapter = new CustomListItemAdapter(cardAboutList,view.getContext());
        cardAboutRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        cardAboutRecycler.setAdapter(adapter);



        return view;


    }
}