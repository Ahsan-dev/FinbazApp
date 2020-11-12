package com.example.myfirst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class DisclaimTermsPoliciesActivities extends AppCompatActivity {

    private TabLayout termsPolicyTab;
    private ViewPager termsPolicypager;
    private Toolbar toolbar;
    private TextView toolTile;
    private ImageView backBtn;
    private String fronIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaim_terms_policies_activities);

        termsPolicyTab = findViewById(R.id.terms_policy_tablayout);
        termsPolicypager = findViewById(R.id.terms_policy_viewpager_id);
        toolbar = findViewById(R.id.terms_policy_toolbar);
        toolTile = findViewById(R.id.savings_toolbar_title_id);
        backBtn = findViewById(R.id.savings_account_back_button);

        fronIntent = getIntent().getStringExtra("fromIntent");

        setSupportActionBar(toolbar);
        toolTile.setText("Our Policies");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(fronIntent.equals("sign_up")){
                    startActivity(new Intent(getApplicationContext(),SignUpActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                }else {
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                }

            }
        });


        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        termsPolicypager.setAdapter(pagerAdapter);
        termsPolicyTab.setupWithViewPager(termsPolicypager);

    }


    @Override
    public void onBackPressed() {

        if(fronIntent.equals("sign_up")){
            startActivity(new Intent(getApplicationContext(),SignUpActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
        }else {
            startActivity(new Intent(getApplicationContext(),HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
        }

    }

    private class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new PrivacyPolicyFragment();
                case 1:
                    return new DataPolicyFragment();
                case 2:
                    return new TermsUseFragment();
            }
            return null;

        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            super.getPageTitle(position);
            switch(position){

                case 0:
                    return getResources().getText(R.string.privacy_policy_tab_title);
                case 1:
                    return getResources().getText(R.string.data_policy_tab_title);
                case 2:
                    return getResources().getText(R.string.terms_use_tab_title);

            }
            return null;
        }


    }
}