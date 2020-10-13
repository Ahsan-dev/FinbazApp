package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class SavingsBankDetailsActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private String bankName;
    private Fragment fragment;
    private Toolbar toolbar;
    private ImageView backBtn;
    private TextView tollbarTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings_bank_details);

        toolbar = findViewById(R.id.savings_bank_details_toolbar_id);
        backBtn =findViewById(R.id.savings_account_back_button);
        tollbarTitle = findViewById(R.id.savings_toolbar_title_id);
        setSupportActionBar(toolbar);

        frameLayout = findViewById(R.id.savings_bank_details_frame_id);
        bankName = getIntent().getStringExtra("bankName");
        tollbarTitle.setText("Features & More");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SavingsAccountActivity.class));
            }
        });


//        if(savedInstanceState == null){
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.savings_bank_details_frame_id,new IndusindBankFragment()).commit();
//
//        }else {
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_id, fragment).commit();
//
//        }

        if(bankName.equals("indusind")){
            fragment = new IndusindBankFragment();

        }
        if(bankName.equals("kotak")){
            fragment = new KotakBankFragment();
        }
        if(bankName.equals("digibank")){
            fragment = new DigiBankFragment();
        }
        if(bankName.equals("rblbank")){
            fragment = new RBLBankFragment();
        }
        if(bankName.equals("idfcbank")){
            fragment = new IDFCBankFragment();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.savings_bank_details_frame_id, fragment).commit();









    }
}