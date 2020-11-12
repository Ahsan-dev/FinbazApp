package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class LoanActivity extends AppCompatActivity {

    private CardView personalLoanCard, businessLoanCard, homeLoanCard;
    private Toolbar toolbar;
    private ImageView backBtn;
    private TextView toolTitle;
    private String fromIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        personalLoanCard = findViewById(R.id.loan_personal_loan_card_view);
        businessLoanCard = findViewById(R.id.loan_business_loan_card_view);
        homeLoanCard = findViewById(R.id.loan_home_loan_card_view);

        fromIntent = getIntent().getStringExtra("fromIntent");

        toolbar = findViewById(R.id.loan_toolbar_id);
        toolTitle = findViewById(R.id.savings_toolbar_title_id);
        backBtn = findViewById(R.id.savings_account_back_button);
        setSupportActionBar(toolbar);
        toolTitle.setText("Loan Products");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               warningAlert();
            }
        });

    }

    @Override
    public void onBackPressed() {
        warningAlert();
    }

    private void warningAlert() {

        final Dialog dialog = new Dialog(LoanActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView message = (TextView) dialog.findViewById(R.id.alertDialogMessageId);
        message.setText("Do you want to discontinue?");

        TextView yesBtn = dialog.findViewById(R.id.alert_positive_btn_id);
        TextView noBtn = dialog.findViewById(R.id.alert_negative_btn_id);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fromIntent.equals("home")){

                    Intent homeIntent = new Intent(LoanActivity.this,HomeActivity.class);
                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(homeIntent);

                }else {

                    Intent moreIntent = new Intent(LoanActivity.this,MoreActivity.class);
                    moreIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(moreIntent);

                }
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

}