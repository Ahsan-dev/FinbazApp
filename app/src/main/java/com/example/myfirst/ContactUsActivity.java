package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContactUsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolTitle;
    private ImageView backBtn;
    private Spinner spinner;
    private EditText spinnerEdt;
    private Button submitBtn, gotItBtn;
    private String[] queryItems;
    private StringBuilder querySubmission;
    private String spinnerValue;
    private String spinnerMessage;
    private CardView thankYouCard;
    private RelativeLayout queryRelative;
    private ImageView contactUsImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        toolbar = findViewById(R.id.contact_us_toolbar);
        toolTitle = findViewById(R.id.savings_toolbar_title_id);
        backBtn = findViewById(R.id.savings_account_back_button);
        setSupportActionBar(toolbar);

        spinner = findViewById(R.id.contact_us_query_spinner_id);
        spinnerEdt = findViewById(R.id.contact_us_query_spinner_msg_edt);
        submitBtn = findViewById(R.id.contact_us_query_spinner_submit_btn);
        gotItBtn = findViewById(R.id.contact_us_thankyou_got_it_btn);
        contactUsImg = findViewById(R.id.contact_us_image);

        thankYouCard = findViewById(R.id.contact_us_thank_you_cardView);
        queryRelative = findViewById(R.id.contact_us_query_relative);

        toolTitle.setText("Contact Us");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                finish();
                startActivity(new Intent(ContactUsActivity.this,HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });



        querySubmission = new StringBuilder();
        queryItems = getResources().getStringArray(R.array.query_items_spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_item_layout,R.id.spinner_item_txt,queryItems);
        spinner.setAdapter(spinnerAdapter);



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                spinnerValue = spinner.getSelectedItem().toString();
                spinnerMessage = spinnerEdt.getText().toString();
                querySubmission.append(spinnerValue);
                querySubmission.append("\n\n");
                querySubmission.append(spinnerMessage);

                if(spinnerValue.equals("--Query Type--")){
                    Toast.makeText(view.getContext(),"Please select a query type!!",Toast.LENGTH_LONG).show();
                }else if(spinnerMessage.equals("") || spinnerMessage.length()<30){
                    spinnerEdt.setError("Message is mandatory and must be min 30 characters...");
                    spinnerEdt.requestFocus();
                    return;
                } else {
                    thankYouCard.setVisibility(View.VISIBLE);
                    queryRelative.setVisibility(View.GONE);
                    contactUsImg.setVisibility(View.GONE);
                    Toast.makeText(view.getContext(),querySubmission,Toast.LENGTH_LONG).show();
                }
            }
        });

        gotItBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                finish();
                startActivity(new Intent(ContactUsActivity.this,HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));


            }
        });



    }


    @Override
    public void onBackPressed() {
//        finish();
        startActivity(new Intent(ContactUsActivity.this,HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));

    }
}