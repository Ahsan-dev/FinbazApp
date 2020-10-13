package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InsuranceActivity extends AppCompatActivity {

    private CardView twoWheelerInsurance, fourWheelerInsurance, healthInsurance, lifeInsurance;
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);

        twoWheelerInsurance = findViewById(R.id.insurance_two_wheeler_card_view);
        fourWheelerInsurance = findViewById(R.id.insurance_four_wheeler_insurance_card_view);
        healthInsurance = findViewById(R.id.insurance_health_insurance_card_view);
        lifeInsurance = findViewById(R.id.insurance_life_insurance_card_view);
        toolbar = findViewById(R.id.insurance_toolbar_id);
        toolbarTitle = findViewById(R.id.savings_toolbar_title_id);
        backBtn = findViewById(R.id.savings_account_back_button);

        setSupportActionBar(toolbar);
        toolbarTitle.setText("Insurance Products");


    }
}