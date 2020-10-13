package com.example.myfirst;

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


public class DematFeaturesFragment extends Fragment {

    private TextView dmattitleText;
    private View view;
    private String dematcompanyName;
    private RecyclerView featuresRecycler;
    private List<String> dmatfeatureList;



    public DematFeaturesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_demat_features, container, false);
        dematcompanyName = getArguments().getString("companyName");

        dmattitleText = view.findViewById(R.id.demat_details_feature_title_id);
        featuresRecycler = view.findViewById(R.id.demat_details_features_recyclerId);
        dmatfeatureList = new ArrayList<>();

        if(dematcompanyName.equals("upstox")){

            dmattitleText.setText("Features of Upstox Demat Account:");
            dmatfeatureList.addAll(Arrays.asList(getResources().getStringArray(R.array.upstox_features_array)));

        }
        if(dematcompanyName.equals("angelBroking")){

            dmattitleText.setText("Features of Angel Broking Demat Account:");
            dmatfeatureList.addAll(Arrays.asList(getResources().getStringArray(R.array.angel_broking_features_array)));

        }
        if(dematcompanyName.equals("icici")){

            dmattitleText.setText("Features of ICICI securities Demat Account:");
            dmatfeatureList.addAll(Arrays.asList(getResources().getStringArray(R.array.idfc_features_array)));

        }
        if(dematcompanyName.equals("5paisa")){

            dmattitleText.setText(" Features of 5paisa Demat Account");
            dmatfeatureList.addAll(Arrays.asList(getResources().getStringArray(R.array.five_paisa_features_array)));

        }
        if(dematcompanyName.equals("iifl")){

            dmattitleText.setText("Features of IIFL Demat Account:");
            dmatfeatureList.addAll(Arrays.asList(getResources().getStringArray(R.array.iifl_features)));

        }
        if(dematcompanyName.equals("sharekhan")){

            dmattitleText.setText("Features of Sharekhan Demat Account:");
            dmatfeatureList.addAll(Arrays.asList(getResources().getStringArray(R.array.sharekhan_features_array)));

        }

        CustomListItemAdapter adapter = new CustomListItemAdapter(dmatfeatureList,view.getContext());
        featuresRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        featuresRecycler.setAdapter(adapter);



        return view;



    }
}