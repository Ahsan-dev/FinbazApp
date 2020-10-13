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
import android.widget.Toast;

import com.example.myfirst.Models.SliderItem;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private EditText spinnerMsgEdt;
    private Button spinnerSubmitBtn;
    private CardView moreCard;
    private List<SliderItem> imageList;
    private SliderItem sliderItem;
    private SliderView sliderView;
    private Spinner querySpinner;
    private String[] queryItems;
    private String spinnerValue;
    private String spinnerMessage;
    private StringBuilder querySubmission;
    private CardView queryCard, thankYouCard;
    private CardView loanCard, savAccCard, insuranceCard, credtCard, dematCard, credtScoreCard;
    private Button shareBtn, gotItBtn;
    private View view;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        spinnerMsgEdt = view.findViewById(R.id.query_spinner_msg_edt);
        spinnerSubmitBtn = view.findViewById(R.id.query_spinner_submit_btn);
        querySpinner = view.findViewById(R.id.querySpinnerId);
        sliderView = view.findViewById(R.id.imageSlider);
        queryCard =  view.findViewById(R.id.need_help_cardView);
        thankYouCard = view.findViewById(R.id.thank_you_cardView);
        moreCard = view.findViewById(R.id.more_cardview);
        loanCard = view.findViewById(R.id.loan_card_id);
        savAccCard = view.findViewById(R.id.savings_account_card);
        insuranceCard = view.findViewById(R.id.insurance_card);
        credtCard = view.findViewById(R.id.credit_card_card);
        dematCard = view.findViewById(R.id.demat_card);
        credtScoreCard = view.findViewById(R.id.credit_score_card);
        shareBtn = view.findViewById(R.id.home_refer_fnd_share_btn);
        gotItBtn = view.findViewById(R.id.home_thankyou_got_it_btn);


        loanCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),LoanActivity.class));
            }
        });
        savAccCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),SavingsAccountActivity.class));
            }
        });
        insuranceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),InsuranceActivity.class));
            }
        });
        credtCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),CreditCardActivity.class));
            }
        });
        dematCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),DematActivity.class));
            }
        });
        credtScoreCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),CreditScoreActivity.class));
            }
        });


        thankYouCard.setVisibility(View.GONE);


        querySubmission = new StringBuilder();
        queryItems = getResources().getStringArray(R.array.query_items_spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(view.getContext(),R.layout.spinner_item_layout,R.id.spinner_item_txt,queryItems);
        querySpinner.setAdapter(spinnerAdapter);



        spinnerSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                spinnerValue = querySpinner.getSelectedItem().toString();
                spinnerMessage = spinnerMsgEdt.getText().toString();
                querySubmission.append(spinnerValue);
                querySubmission.append("\n\n");
                querySubmission.append(spinnerMessage);

                if(spinnerValue.equals("--Query Type--")){
                    Toast.makeText(view.getContext(),"Please select a query type!!",Toast.LENGTH_LONG).show();
                }else if(spinnerMessage.equals("") || spinnerMessage.length()<30){
                    spinnerMsgEdt.setError("Message is mandatory and must be min 30 characters...");
                    spinnerMsgEdt.requestFocus();
                    return;
                } else {
                    thankYouCard.setVisibility(View.VISIBLE);
                    queryCard.setVisibility(View.GONE);
                    Toast.makeText(view.getContext(),querySubmission,Toast.LENGTH_LONG).show();
                }
            }
        });

        gotItBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),HomeActivity.class));
            }
        });


        moreCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MoreActivity.class);
                startActivity(intent);
            }
        });






        imageList = new ArrayList<>();
        imageList.add(new SliderItem(R.drawable.account));
        imageList.add(new SliderItem(R.drawable.demat));
        imageList.add(new SliderItem(R.drawable.credit_card));
        imageList.add(new SliderItem(R.drawable.insurance));


        SliderAdapterExample adapter = new SliderAdapterExample(view.getContext(),imageList);



        //sliderView.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        //sliderView.setIndicatorSelectedColor(Color.BLACK);
        //sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        sliderView.setSliderAdapter(adapter);



        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new ReferAndEarnFragment();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.home_frame_id, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
            }
        });


        return view;
    }


}