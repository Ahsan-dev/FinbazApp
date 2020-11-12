package com.example.myfirst;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirst.Models.SliderItem;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private CardView moreCard;
    private List<SliderItem> imageList;
    private SliderView sliderView;
    private String[] queryItems;
    private String spinnerValue;
    private String spinnerMessage;
    private StringBuilder querySubmission;
    private CardView loanCard, savAccCard, insuranceCard, credtCard, dematCard, credtScoreCard, doctorConsultCard, gamePlayCard, utilityBillCard;
    private View view;
    private TextView scoreTxtBtn;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);


        sliderView = view.findViewById(R.id.imageSlider);
        moreCard = view.findViewById(R.id.more_cardview);
        loanCard = view.findViewById(R.id.loan_card_id);
        savAccCard = view.findViewById(R.id.savings_account_card);
        insuranceCard = view.findViewById(R.id.insurance_card);
        credtCard = view.findViewById(R.id.credit_card_card);
        dematCard = view.findViewById(R.id.demat_card);
        credtScoreCard = view.findViewById(R.id.credit_score_card);
        scoreTxtBtn = view.findViewById(R.id.score_click_btn);
        doctorConsultCard = view.findViewById(R.id.doctor_consultation_cardview);
        gamePlayCard = view.findViewById(R.id.play_games_cardview);
        utilityBillCard = view.findViewById(R.id.utility_bill_cardview);


        loanCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),LoanActivity.class).putExtra("fromIntent","home"));
            }
        });
        savAccCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),SavingsAccountActivity.class).putExtra("fromIntent","home"));
            }
        });
        insuranceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),InsuranceActivity.class).putExtra("fromIntent","home"));
            }
        });
        credtCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),CreditCardActivity.class).putExtra("fromIntent","home"));
            }
        });
        dematCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),DematActivity.class).putExtra("fromIntent","home"));
            }
        });
        credtScoreCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),CreditScoreActivity.class).putExtra("fromIntent","home"));
            }
        });




        moreCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MoreActivity.class);
                startActivity(intent);
            }
        });

        doctorConsultCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(view.getContext(),DoctorConsultActivity.class));

            }
        });

        gamePlayCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(view.getContext(),PlayGameActivity.class));

            }
        });

        utilityBillCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(view.getContext(),UtilityBillActivity.class));

            }
        });






        imageList = new ArrayList<>();
        imageList.add(new SliderItem(R.drawable.finbaz1));
        imageList.add(new SliderItem(R.drawable.finbaz2));
        imageList.add(new SliderItem(R.drawable.finbaz3));
        imageList.add(new SliderItem(R.drawable.finbaz4));
        imageList.add(new SliderItem(R.drawable.finbaz5));


        SliderAdapterExample adapter = new SliderAdapterExample(view.getContext(),imageList);



        //sliderView.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        //sliderView.setIndicatorSelectedColor(Color.BLACK);
        //sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        sliderView.setSliderAdapter(adapter);





        scoreTxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),CreditScoreActivity.class).putExtra("fromIntent","home"));
            }
        });


        return view;
    }


}