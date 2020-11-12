package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {

    private TextView aboutUsTitle;
    private Toolbar aboutUsToolbar;
    private TextView toolTitle;
    private ImageView backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        aboutUsToolbar = findViewById(R.id.about_us_toolbar_id);
        toolTitle = findViewById(R.id.savings_toolbar_title_id);
        backBtn = findViewById(R.id.savings_account_back_button);
        setSupportActionBar(aboutUsToolbar);
        toolTitle.setText("About Us");

        aboutUsTitle = findViewById(R.id.about_us_title_text);




        aboutUsTitle.bringToFront();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(getApplicationContext(),HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));

    }
}