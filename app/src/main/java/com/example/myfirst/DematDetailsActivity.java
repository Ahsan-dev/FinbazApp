package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DematDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView dematCompanyLogo;
    private TextView dematAccountTitle, ratingDetail, aboutBtn, featuresBtn, brokChargeBtn, docReqBtn;
    private RatingBar ratingBar;
    private RelativeLayout fragRelative;
    private TextView applyBtn;
    private String companyName;
    private Fragment fragment;
    private Toolbar dematDetailsToolbar;
    private ImageView backBtn;
    private TextView toolbarTitle;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demat_details);

        dematDetailsToolbar = findViewById(R.id.demate_details_toolbar);
        setSupportActionBar(dematDetailsToolbar);

        backBtn = findViewById(R.id.savings_account_back_button);
        toolbarTitle = findViewById(R.id.savings_toolbar_title_id);

        toolbarTitle.setText("Features & More");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DematActivity.class));

            }
        });


        companyName = getIntent().getStringExtra("companyName");

        dematAccountTitle = findViewById(R.id.demat_details_account_title_id);
        ratingDetail = findViewById(R.id.demat_details_company_rating_detail_id);
        aboutBtn = findViewById(R.id.demat_details_about_txt_btn);
        featuresBtn = findViewById(R.id.demata_details_prod_features_txt_btn);
        brokChargeBtn = findViewById(R.id.demat_details_brokerage_charge_txt_btn);
        ratingBar = findViewById(R.id.demat_details_company_rating_id);
        fragRelative = findViewById(R.id.demat_details_functions_details_relative);
        applyBtn = findViewById(R.id.demat_details_apply_txt_btn);
        dematCompanyLogo = findViewById(R.id.demat_details_item_company_logo);
        docReqBtn = findViewById(R.id.demata_details_docs_required_txt_btn);


        aboutBtn.setOnClickListener(this);
        featuresBtn.setOnClickListener(this);
        brokChargeBtn.setOnClickListener(this);
        docReqBtn.setOnClickListener(this);


        if(companyName.equals("upstox")){
            dematAccountTitle.setText(R.string.upstox_account);
            Picasso.get().load(R.drawable.upstox_icon).into(dematCompanyLogo);
            ratingBar.setRating(4.9f);
            ratingDetail.setText("(4/5) 4,540 ratings)");

        }
        if(companyName.equals("angelBroking")){
            dematAccountTitle.setText(R.string.angel_broking_account);
            Picasso.get().load(R.drawable.angel_broking_icon).into(dematCompanyLogo);
            ratingBar.setRating(4.8f);
            ratingDetail.setText("(4/5) 4,740 ratings)");

        }
        if(companyName.equals("icici")){
            dematAccountTitle.setText(R.string.icici_account);
            Picasso.get().load(R.drawable.icici_bank_logo).into(dematCompanyLogo);
            ratingBar.setRating(4.7f);
            ratingDetail.setText("(4/5) 4,560 ratings)");

        }
        if(companyName.equals("5paisa")){
            dematAccountTitle.setText(R.string.five_paisa_account);
            Picasso.get().load(R.drawable.five_paisa_logo).into(dematCompanyLogo);
            ratingBar.setRating(4.7f);
            ratingDetail.setText("(4/5) 4,140 ratings)");

        }
        if(companyName.equals("iifl")){
            dematAccountTitle.setText(R.string.iifl_account);
            Picasso.get().load(R.drawable.iifl_company_logo).into(dematCompanyLogo);
            ratingBar.setRating(4.8f);
            ratingDetail.setText("(4/5) 4,540 ratings)");

        }
        if(companyName.equals("sharekhan")){
            dematAccountTitle.setText(R.string.sharekhan_account);
            Picasso.get().load(R.drawable.sharekhan_icon).into(dematCompanyLogo);
            ratingBar.setRating(4.7f);
            ratingDetail.setText("(4/5) 4,840 ratings)");

        }

        if(savedInstanceState == null){

            Bundle b = new Bundle();
            b.putString("companyName",companyName);
            DematAboutFragment aboutFragment= new DematAboutFragment();
            aboutFragment.setArguments(b);

            getSupportFragmentManager().beginTransaction().replace(R.id.demat_details_functions_details_relative,aboutFragment).commit();

        }else {

            getSupportFragmentManager().beginTransaction().replace(R.id.rblbank_savings_bank_details_functions_details_relative, fragment).commit();

        }





    }

    @Override
    public void onClick(View view) {

        fragment = null;

        if(view.getId()==R.id.demat_details_about_txt_btn){
            fragment = new DematAboutFragment();
            aboutBtn.setBackgroundResource(R.drawable.back_phone_four);
            aboutBtn.setTextColor(getResources().getColor(android.R.color.white));
            docReqBtn.setBackgroundResource(R.drawable.back_phone_two);
            docReqBtn.setTextColor(getResources().getColor(android.R.color.black));
            featuresBtn.setBackgroundResource(R.drawable.back_phone_two);
            featuresBtn.setTextColor(getResources().getColor(android.R.color.black));
            brokChargeBtn.setBackgroundResource(R.drawable.back_phone_two);
            brokChargeBtn.setTextColor(getResources().getColor(android.R.color.black));

            Bundle b = new Bundle();
            b.putString("companyName",companyName);
            fragment.setArguments(b);

        }

        if(view.getId()==R.id.demata_details_docs_required_txt_btn){
            fragment = new DematDocsRequiredFragment();
            docReqBtn.setBackgroundResource(R.drawable.back_phone_four);
            docReqBtn.setTextColor(getResources().getColor(android.R.color.white));
            aboutBtn.setBackgroundResource(R.drawable.back_phone_two);
            aboutBtn.setTextColor(getResources().getColor(android.R.color.black));
            featuresBtn.setBackgroundResource(R.drawable.back_phone_two);
            featuresBtn.setTextColor(getResources().getColor(android.R.color.black));
            brokChargeBtn.setBackgroundResource(R.drawable.back_phone_two);
            brokChargeBtn.setTextColor(getResources().getColor(android.R.color.black));

            Bundle b = new Bundle();
            b.putString("companyName",companyName);
            fragment.setArguments(b);

        }

        if(view.getId()==R.id.demata_details_prod_features_txt_btn){
            fragment = new DematFeaturesFragment();
            featuresBtn.setBackgroundResource(R.drawable.back_phone_four);
            featuresBtn.setTextColor(getResources().getColor(android.R.color.white));
            aboutBtn.setBackgroundResource(R.drawable.back_phone_two);
            aboutBtn.setTextColor(getResources().getColor(android.R.color.black));
            docReqBtn.setBackgroundResource(R.drawable.back_phone_two);
            docReqBtn.setTextColor(getResources().getColor(android.R.color.black));
            brokChargeBtn.setBackgroundResource(R.drawable.back_phone_two);
            brokChargeBtn.setTextColor(getResources().getColor(android.R.color.black));
            Bundle b = new Bundle();
            b.putString("companyName",companyName);
            fragment.setArguments(b);

        }


        if(view.getId()==R.id.demat_details_brokerage_charge_txt_btn){
            fragment = new DematBrokChargeFragment();
            brokChargeBtn.setBackgroundResource(R.drawable.back_phone_four);
            brokChargeBtn.setTextColor(getResources().getColor(android.R.color.white));
            featuresBtn.setBackgroundResource(R.drawable.back_phone_two);
            featuresBtn.setTextColor(getResources().getColor(android.R.color.black));
            aboutBtn.setBackgroundResource(R.drawable.back_phone_two);
            aboutBtn.setTextColor(getResources().getColor(android.R.color.black));
            docReqBtn.setBackgroundResource(R.drawable.back_phone_two);
            docReqBtn.setTextColor(getResources().getColor(android.R.color.black));
            Bundle b = new Bundle();
            b.putString("companyName",companyName);
            fragment.setArguments(b);

        }

        getSupportFragmentManager().beginTransaction().replace(R.id.demat_details_functions_details_relative,fragment).commit();

    }
}