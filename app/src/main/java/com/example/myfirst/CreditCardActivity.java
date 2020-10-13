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

import com.example.myfirst.Models.CreditCardModel;
import com.example.myfirst.Models.DematAccountCardModel;

import java.util.ArrayList;
import java.util.List;

public class CreditCardActivity extends AppCompatActivity {
    private Toolbar creditToolbar;
    private ImageView backBtn;
    private TextView creditToolbarTitle;
    private List<CreditCardModel> ccList;
    private CreditCardRecyclerAdapter ccAdapter;
    private RecyclerView creditCardRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);

        creditToolbar = findViewById(R.id.credit_card_toolbar_id);
        backBtn =findViewById(R.id.savings_account_back_button);
        setSupportActionBar(creditToolbar);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                warningAlert();
            }
        });

        creditCardRecycler = findViewById(R.id.credit_card_recycler);

        creditToolbarTitle = findViewById(R.id.savings_toolbar_title_id);

        creditToolbarTitle.setText("Credit Cards");

        ccList = new ArrayList<>();

        ccList.add(new CreditCardModel("saveSbi",R.drawable.simplysave_svi_card,R.string.simply_save_svi_card_title,true,4.9f,"₹ 499","₹ 499"));
        ccList.add(new CreditCardModel("clickSbi",R.drawable.simply_click_sbi_card,R.string.simply_click_svi_card_title,false,4.7f,"₹ 499","₹ 499"));
        ccList.add(new CreditCardModel("rblShop",R.drawable.rbl_shoprite,R.string.shoprite_rbl_card_title,false,4.8f,"₹ 0","₹ 500"));


        ccAdapter = new CreditCardRecyclerAdapter(ccList,CreditCardActivity.this);

        creditCardRecycler.setLayoutManager(new LinearLayoutManager(CreditCardActivity.this));
        creditCardRecycler.setAdapter(ccAdapter);



    }

    private void warningAlert() {

        final Dialog dialog = new Dialog(CreditCardActivity.this);
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
                Intent homeIntent = new Intent(CreditCardActivity.this,HomeActivity.class);
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