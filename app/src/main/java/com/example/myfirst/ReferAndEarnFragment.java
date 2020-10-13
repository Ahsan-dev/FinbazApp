package com.example.myfirst;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.tabs.TabLayout;


public class ReferAndEarnFragment extends Fragment {

    private View view;
    private ViewPager pager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private TextView toolTile;
    private ImageView backBtn;




    public ReferAndEarnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_refer_and_earn, container, false);

        pager = view.findViewById(R.id.refer_and_earn_viewpagerId);
        tabLayout = view.findViewById(R.id.refer_and_earn_tablayout_id);
        toolbar = view.findViewById(R.id.savings_toolbar_id);
        toolTile = view.findViewById(R.id.savings_toolbar_title_id);
        backBtn = view.findViewById(R.id.savings_account_back_button);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolTile.setText("Refer A Friend");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),HomeActivity.class));
            }
        });

        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager());
        pager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(pager);


        return view;


    }


    private class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new ReferFragment();
                case 1:
                    return new RewardsFragment();
                case 2:
                    return new KnowMoreFragment();
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
                    return getResources().getText(R.string.refer_tab_title);
                case 1:
                    return getResources().getText(R.string.rewards_tab_title);
                case 2:
                    return getResources().getText(R.string.knowmore_tab_title);

            }
            return null;
        }


    }




}