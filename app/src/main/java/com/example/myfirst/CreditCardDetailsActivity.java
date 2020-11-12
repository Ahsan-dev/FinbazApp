package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreditCardDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView cardImage;
    private TextView creditCardTitle, creditRatingDetail, aboutBtn, featuresBtn, chargeBtn, docReqBtn;
    private RatingBar ratingBar;
    private RelativeLayout fragRelative;
    private TextView applyBtn;
    private String cardName, fromIntent;
    private Fragment fragment;
    private Toolbar creditCardDetailsToolbar;
    private ImageView backBtn;
    private TextView toolbarTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_details);

        creditCardDetailsToolbar = findViewById(R.id.credit_card_details_toolbar);
        setSupportActionBar(creditCardDetailsToolbar);

        fromIntent = getIntent().getStringExtra("fromIntent");

        backBtn = findViewById(R.id.savings_account_back_button);
        toolbarTitle = findViewById(R.id.savings_toolbar_title_id);

        toolbarTitle.setText("Features & More");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CreditCardActivity.class).putExtra("fromIntent",fromIntent).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK));

            }
        });


        cardName = getIntent().getStringExtra("cardName");

        creditCardTitle = findViewById(R.id.credit_card_details_card_title_id);
        creditRatingDetail = findViewById(R.id.credit_card_details_card_rating_detail_id);
        aboutBtn = findViewById(R.id.credit_card_details_about_txt_btn);
        featuresBtn = findViewById(R.id.credit_card_details_features_benefits_txt_btn);
        chargeBtn = findViewById(R.id.credit_card_details_fees_charge_txt_btn);
        ratingBar = findViewById(R.id.credit_card_details_card_rating_id);
        fragRelative = findViewById(R.id.credit_card_details_functions_details_relative);
        applyBtn = findViewById(R.id.credit_card_details_apply_txt_btn);
        cardImage = findViewById(R.id.credit_card_details_card_logo);
        docReqBtn = findViewById(R.id.credit_card_details_docs_required_txt_btn);


        aboutBtn.setOnClickListener(this);
        featuresBtn.setOnClickListener(this);
        chargeBtn.setOnClickListener(this);
        docReqBtn.setOnClickListener(this);




        if(cardName.equals("saveSbi")){
            creditCardTitle.setText(R.string.simply_save_svi_card_title);
            Picasso.get().load(R.drawable.simplysave_svi_card).into(cardImage);
            ratingBar.setRating(4.9f);
            creditRatingDetail.setText("(4/5) 4,840 ratings)");


        }
        if(cardName.equals("clickSbi")){
            creditCardTitle.setText(R.string.simply_click_svi_card_title);
            Picasso.get().load(R.drawable.simply_click_sbi_card).into(cardImage);
            ratingBar.setRating(4.7f);
            creditRatingDetail.setText("(4/5) 4,120 ratings)");

        }
        if(cardName.equals("rblShop")){
            creditCardTitle.setText(R.string.shoprite_rbl_card_title);
            Picasso.get().load(R.drawable.rbl_shoprite).into(cardImage);
            ratingBar.setRating(4.8f);
            creditRatingDetail.setText("(4/5) 4,310 ratings)");

        }




        if(savedInstanceState == null){

            Bundle b = new Bundle();
            b.putString("cardName",cardName);
            CreditCardAboutFragment aboutFragment= new CreditCardAboutFragment();
            aboutFragment.setArguments(b);

            getSupportFragmentManager().beginTransaction().replace(R.id.credit_card_details_functions_details_relative,aboutFragment).commit();

        }else {

            getSupportFragmentManager().beginTransaction().replace(R.id.credit_card_details_functions_details_relative, fragment).commit();

        }





    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),CreditCardActivity.class).putExtra("fromIntent",fromIntent).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK));

    }

    @Override
    public void onClick(View view) {
        fragment = null;

        if(view.getId()==R.id.credit_card_details_about_txt_btn){

            fragment = new CreditCardAboutFragment();
            aboutBtn.setBackgroundResource(R.drawable.back_phone_four);
            aboutBtn.setTextColor(getResources().getColor(android.R.color.white));
            docReqBtn.setBackgroundResource(R.drawable.back_phone_two);
            docReqBtn.setTextColor(getResources().getColor(android.R.color.black));
            featuresBtn.setBackgroundResource(R.drawable.back_phone_two);
            featuresBtn.setTextColor(getResources().getColor(android.R.color.black));
            chargeBtn.setBackgroundResource(R.drawable.back_phone_two);
            chargeBtn.setTextColor(getResources().getColor(android.R.color.black));

            Bundle b = new Bundle();
            b.putString("cardName",cardName);
            fragment.setArguments(b);

        }

        if(view.getId()==R.id.credit_card_details_docs_required_txt_btn){

            fragment = new CreditCardDocRequiredFragment();
            docReqBtn.setBackgroundResource(R.drawable.back_phone_four);
            docReqBtn.setTextColor(getResources().getColor(android.R.color.white));
            aboutBtn.setBackgroundResource(R.drawable.back_phone_two);
            aboutBtn.setTextColor(getResources().getColor(android.R.color.black));
            featuresBtn.setBackgroundResource(R.drawable.back_phone_two);
            featuresBtn.setTextColor(getResources().getColor(android.R.color.black));
            chargeBtn.setBackgroundResource(R.drawable.back_phone_two);
            chargeBtn.setTextColor(getResources().getColor(android.R.color.black));

            Bundle b = new Bundle();
            b.putString("cardName",cardName);
            fragment.setArguments(b);



        }

        if(view.getId()==R.id.credit_card_details_features_benefits_txt_btn){

            fragment = new CreditCardFeaturesFragment();
            featuresBtn.setBackgroundResource(R.drawable.back_phone_four);
            featuresBtn.setTextColor(getResources().getColor(android.R.color.white));
            aboutBtn.setBackgroundResource(R.drawable.back_phone_two);
            aboutBtn.setTextColor(getResources().getColor(android.R.color.black));
            docReqBtn.setBackgroundResource(R.drawable.back_phone_two);
            docReqBtn.setTextColor(getResources().getColor(android.R.color.black));
            chargeBtn.setBackgroundResource(R.drawable.back_phone_two);
            chargeBtn.setTextColor(getResources().getColor(android.R.color.black));
            Bundle b = new Bundle();
            b.putString("cardName",cardName);
            fragment.setArguments(b);

        }

        if(view.getId()==R.id.credit_card_details_fees_charge_txt_btn){

            fragment = new CreditCardChargesFragment();
            chargeBtn.setBackgroundResource(R.drawable.back_phone_four);
            chargeBtn.setTextColor(getResources().getColor(android.R.color.white));
            featuresBtn.setBackgroundResource(R.drawable.back_phone_two);
            featuresBtn.setTextColor(getResources().getColor(android.R.color.black));
            aboutBtn.setBackgroundResource(R.drawable.back_phone_two);
            aboutBtn.setTextColor(getResources().getColor(android.R.color.black));
            docReqBtn.setBackgroundResource(R.drawable.back_phone_two);
            docReqBtn.setTextColor(getResources().getColor(android.R.color.black));
            Bundle b = new Bundle();
            b.putString("cardName",cardName);
            fragment.setArguments(b);

        }

        getSupportFragmentManager().beginTransaction().replace(R.id.credit_card_details_functions_details_relative,fragment).commit();



    }
}