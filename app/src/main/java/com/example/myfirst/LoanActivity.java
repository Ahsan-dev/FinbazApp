package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LoanActivity extends AppCompatActivity {

    private CardView personalLoanCard, businessLoanCard, homeLoanCard;
    private Toolbar toolbar;
    private ImageView backBtn;
    private TextView toolTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        personalLoanCard = findViewById(R.id.loan_personal_loan_card_view);
        businessLoanCard = findViewById(R.id.loan_business_loan_card_view);
        homeLoanCard = findViewById(R.id.loan_home_loan_card_view);

        toolbar = findViewById(R.id.loan_toolbar_id);
        toolTitle = findViewById(R.id.savings_toolbar_title_id);
        backBtn = findViewById(R.id.savings_account_back_button);
        setSupportActionBar(toolbar);
        toolTitle.setText("Loan Products");

    }
}