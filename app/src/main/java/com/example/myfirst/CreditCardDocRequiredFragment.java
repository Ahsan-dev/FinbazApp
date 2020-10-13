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


public class CreditCardDocRequiredFragment extends Fragment {

    private TextView cardDocReqTitleText;
    private View view;
    private String cardName;
    private RecyclerView cardDocReqRecycler;
    private List<String> cardDocReqList;



    public CreditCardDocRequiredFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_credit_card_doc_required, container, false);



        cardDocReqTitleText = view.findViewById(R.id.credit_card_details_doc_req_title_id);
        cardDocReqRecycler = view.findViewById(R.id.credit_card_details_doc_req_recyclerId);
        cardDocReqList = new ArrayList<>();
        cardDocReqTitleText.setText(R.string.credit_card_docs_req_about);
        cardDocReqList.addAll(Arrays.asList(getResources().getStringArray(R.array.credit_card_doc_req_array)));

        CustomListItemAdapter adapter = new CustomListItemAdapter(cardDocReqList,view.getContext());
        cardDocReqRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        cardDocReqRecycler.setAdapter(adapter);



        return view;

    }
}