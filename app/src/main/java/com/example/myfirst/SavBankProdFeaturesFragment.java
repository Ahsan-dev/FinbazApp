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

public class SavBankProdFeaturesFragment extends Fragment {

    private TextView titleText;
    private View view;
    private String bankName;
    private RecyclerView featuresRecycler;
    private List<String> featureList;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sav_bank_prod_features, container, false);

        bankName = getArguments().getString("bankName");

        titleText = view.findViewById(R.id.bank_prod_feature_title_id);
        featuresRecycler = view.findViewById(R.id.custom_list_recyclerId);
        featureList = new ArrayList<>();

        if(bankName=="indusind"){

            titleText.setText("Features of Indusind Bank Savings Account:");
            featureList.addAll(Arrays.asList(getResources().getStringArray(R.array.indusind_features_array)));

        }
        if(bankName=="kotak"){

            titleText.setText("Features of Kotak 811 Bank Savings Account:");
            featureList.addAll(Arrays.asList(getResources().getStringArray(R.array.kotak_features_array)));

        }
        if(bankName=="digibank"){

            titleText.setText("Features of Digibank by DBS Savings Account:");
            featureList.addAll(Arrays.asList(getResources().getStringArray(R.array.digibank_features_array)));

        }
        if(bankName=="rbl"){

            titleText.setText(" An RBL Bank Digital Savings Account will make your life easier in so many ways. Here are some of them:");
            featureList.addAll(Arrays.asList(getResources().getStringArray(R.array.rblbank_features_array)));

        }
        if(bankName=="idfc"){

            titleText.setText("Features of IDFC First Bank Savings Account:");
            featureList.addAll(Arrays.asList(getResources().getStringArray(R.array.idfc_features_array)));

        }

        CustomListItemAdapter adapter = new CustomListItemAdapter(featureList,view.getContext());
        featuresRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        featuresRecycler.setAdapter(adapter);



        return view;
    }
}