package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.myfirst.Models.SavingsAccountCardModel;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccountActivity extends AppCompatActivity {

    private RecyclerView savingsAccountRecycler;
    private List<SavingsAccountCardModel> saList;
    private SavingsAccountCardRecyclerAdapter saAdapter;
    private Toolbar toolbar;
    private ImageView backBtn;
    private TextView toolbarTitleTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings_account);
        savingsAccountRecycler = findViewById(R.id.savings_account_recycler);

        toolbar = findViewById(R.id.savings_toolbar_id);
        backBtn =findViewById(R.id.savings_account_back_button);
        toolbarTitleTxt = findViewById(R.id.savings_toolbar_title_id);
        setSupportActionBar(toolbar);

        toolbarTitleTxt.setText("Savings Bank Accounts");

        saList = new ArrayList<>();

        saList.add(new SavingsAccountCardModel(R.drawable.indusind_bank_logo,R.string.indusind_savAcc_title,true,"upto 6%"," ₹ 0"," ₹ 0",4.8f,"indusind"));
        saList.add(new SavingsAccountCardModel(R.drawable.kotak_mahindra_bank_logo,R.string.kotak_savAcc_title,true,"upto 4%"," ₹ 0"," ₹ 0",4.7f,"kotak"));
        saList.add(new SavingsAccountCardModel(R.drawable.digibank,R.string.digibank_savAcc_title,false,"upto 5%"," ₹ 0"," ₹ 0",4.8f,"digibank"));
        saList.add(new SavingsAccountCardModel(R.drawable.rbl_bank_logo,R.string.rbl_savAcc_title,false,"upto 6.75%"," ₹ 2,000"," ₹ 0",4.7f,"rblbank"));
        saList.add(new SavingsAccountCardModel(R.drawable.idfc_first_bank_logo,R.string.idfc_savAcc_title,false,"upto 7%"," ₹ 10,000 - 25,000"," ₹ 0",4.7f,"idfcbank"));

        saAdapter = new SavingsAccountCardRecyclerAdapter(saList,this);
        savingsAccountRecycler.setLayoutManager(new LinearLayoutManager(this));
        savingsAccountRecycler.setAdapter(saAdapter);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               warningAlert();
            }
        });


    }

    private void warningAlert() {

        final Dialog dialog = new Dialog(SavingsAccountActivity.this);
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
                Intent homeIntent = new Intent(SavingsAccountActivity.this,HomeActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(homeIntent);
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

    @Override
    public void onBackPressed() {

        warningAlert();

    }
}