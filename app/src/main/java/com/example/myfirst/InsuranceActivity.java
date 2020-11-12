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

public class InsuranceActivity extends AppCompatActivity {

    private CardView twoWheelerInsurance, fourWheelerInsurance, healthInsurance, lifeInsurance;
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private ImageView backBtn;
    private String fromIntent;

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

        fromIntent = getIntent().getStringExtra("fromIntent");

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

        final Dialog dialog = new Dialog(InsuranceActivity.this);
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

                    Intent homeIntent = new Intent(InsuranceActivity.this,HomeActivity.class);
                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(homeIntent);

                }else {

                    Intent moreIntent = new Intent(InsuranceActivity.this,MoreActivity.class);
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