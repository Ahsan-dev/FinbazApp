package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MoreActivity extends AppCompatActivity {

    private CardView  loanCard, savingsAccountCard, creditCardCard, insuranceCard, dmatCard, creditScoreCard, miscellaneousCard;
    private Toolbar toolbar;
    private ImageView backBtn;
    private TextView tollbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        loanCard = findViewById(R.id.loan_card_id);
        savingsAccountCard = findViewById(R.id.savings_account_card);
        creditCardCard = findViewById(R.id.credit_card_card);
        insuranceCard = findViewById(R.id.insurance_card);
        dmatCard = findViewById(R.id.demat_card);
        creditScoreCard = findViewById(R.id.credit_score_card);
        miscellaneousCard = findViewById(R.id.micelleneous_card);
        toolbar = findViewById(R.id.signup_toolbar_id);
        setSupportActionBar(toolbar);
        backBtn = findViewById(R.id.savings_account_back_button);
        tollbarTitle = findViewById(R.id.savings_toolbar_title_id);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MoreActivity.this,HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK));

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });
        tollbarTitle.setText("Our Products & Services");


        loanCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoanActivity.class).putExtra("fromIntent","more");
                startActivity(intent);
            }
        });
        savingsAccountCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SavingsAccountActivity.class).putExtra("fromIntent","more");
                startActivity(intent);
            }
        });
        insuranceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),InsuranceActivity.class).putExtra("fromIntent","more");
                startActivity(intent);
            }
        });
        creditCardCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CreditCardActivity.class).putExtra("fromIntent","more");
                startActivity(intent);
            }
        });
        dmatCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DematActivity.class).putExtra("fromIntent","more");
                startActivity(intent);
            }
        });
        creditScoreCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CreditScoreActivity.class).putExtra("fromIntent","more");
                startActivity(intent);
            }
        });

        miscellaneousCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MiscellaneousActivity.class).putExtra("fromIntent","more");
                startActivity(intent);

            }
        });


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MoreActivity.this,HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}