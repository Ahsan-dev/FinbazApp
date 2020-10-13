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

import com.example.myfirst.Models.DematAccountCardModel;
import com.example.myfirst.Models.SavingsAccountCardModel;

import java.util.ArrayList;
import java.util.List;

public class DematActivity extends AppCompatActivity {

    private Toolbar dmatToolbar;
    private ImageView backBtn;
    private TextView dmatToolbarTitle;
    private List<DematAccountCardModel> daList;
    private DematAccountCardRecyclerAdapter daAdapter;
    private RecyclerView dmatRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demat);

        dmatToolbar = findViewById(R.id.demat_toolbar_id);
        backBtn =findViewById(R.id.savings_account_back_button);
        setSupportActionBar(dmatToolbar);

        dmatRecycler = findViewById(R.id.demat_account_recycler);

        dmatToolbarTitle = findViewById(R.id.savings_toolbar_title_id);

        dmatToolbarTitle.setText("Demat & Trading Accounts");

        daList = new ArrayList<>();

        daList.add(new DematAccountCardModel("upstox",R.drawable.upstox_icon,R.string.upstox_account,true,4.9f));
        daList.add(new DematAccountCardModel("angelBroking",R.drawable.angel_broking_icon,R.string.angel_broking_account,true,4.8f));
        daList.add(new DematAccountCardModel("icici",R.drawable.icici_bank_logo,R.string.icici_account,false,4.7f));
        daList.add(new DematAccountCardModel("5paisa",R.drawable.five_paisa_logo,R.string.five_paisa_account,false,4.7f));
        daList.add(new DematAccountCardModel("iifl",R.drawable.iifl_company_logo,R.string.iifl_account,false,4.8f));
        daList.add(new DematAccountCardModel("sharekhan",R.drawable.sharekhan_icon,R.string.sharekhan_account,false,4.7f));


        daAdapter = new DematAccountCardRecyclerAdapter(daList,DematActivity.this);

        dmatRecycler.setLayoutManager(new LinearLayoutManager(DematActivity.this));
        dmatRecycler.setAdapter(daAdapter);


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

        final Dialog dialog = new Dialog(DematActivity.this);
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
                Intent homeIntent = new Intent(DematActivity.this,HomeActivity.class);
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


}