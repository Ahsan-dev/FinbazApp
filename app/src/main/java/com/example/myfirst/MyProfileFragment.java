package com.example.myfirst;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class MyProfileFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Fragment fragment;
    private LinearLayout personalLinearBtn, employmentLinearBtn, lifestyleLinearBtn;
    private ImageView logoutBtn, backBtn;
    private CharSequence[] logoutAlerCharSeq;
    private Toolbar toolbar;



    public MyProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        personalLinearBtn = view.findViewById(R.id.personal_details_linear_btn);
        employmentLinearBtn = view.findViewById(R.id.employment_details_linear_btn);
        lifestyleLinearBtn = view.findViewById(R.id.lifestyle_details_linear_btn);
        logoutBtn = view.findViewById(R.id.my_profile_logout_button);
        backBtn = view.findViewById(R.id.my_profile_back_button);
        toolbar = view.findViewById(R.id.my_profile_toolbar_id);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final Dialog dialog = new Dialog(view.getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dialog_layout);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

                TextView message = (TextView) dialog.findViewById(R.id.alertDialogMessageId);
                message.setText("Do you want to logout?");

                TextView yesBtn = dialog.findViewById(R.id.alert_positive_btn_id);
                TextView noBtn = dialog.findViewById(R.id.alert_negative_btn_id);
                yesBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent logoutIntent = new Intent(view.getContext(),MainActivity.class);
                        logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(logoutIntent);
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
        });


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent backIntent = new Intent(view.getContext(),HomeActivity.class);
                startActivity(backIntent);

            }
        });

        personalLinearBtn.setOnClickListener(this);
        employmentLinearBtn.setOnClickListener(this);
        lifestyleLinearBtn.setOnClickListener(this);


        if(savedInstanceState == null){

            getChildFragmentManager().beginTransaction().replace(R.id.frameId,new PersonalDetailsFragment()).commit();

        }else {

            getChildFragmentManager().beginTransaction().replace(R.id.frameId, fragment).commit();

        }


        return view;
    }

    @Override
    public void onClick(View view) {

        fragment = null;

        if(view.getId() == R.id.personal_details_linear_btn){

            fragment = new PersonalDetailsFragment();
            personalLinearBtn.setBackground(getResources().getDrawable(R.drawable.back_eight));
            employmentLinearBtn.setBackground(getResources().getDrawable(R.drawable.back_phone));
            lifestyleLinearBtn.setBackground(getResources().getDrawable(R.drawable.back_phone));

        }
        if(view.getId() == R.id.employment_details_linear_btn){

            fragment = new EmploymentDetailsFragment();
            personalLinearBtn.setBackground(getResources().getDrawable(R.drawable.back_phone));
            employmentLinearBtn.setBackground(getResources().getDrawable(R.drawable.back_eight));
            lifestyleLinearBtn.setBackground(getResources().getDrawable(R.drawable.back_phone));

        }
        if(view.getId() == R.id.lifestyle_details_linear_btn){

            fragment = new LifestyleDetailsFragment();
            personalLinearBtn.setBackground(getResources().getDrawable(R.drawable.back_phone));
            employmentLinearBtn.setBackground(getResources().getDrawable(R.drawable.back_phone));
            lifestyleLinearBtn.setBackground(getResources().getDrawable(R.drawable.back_eight));

        }

        getChildFragmentManager().beginTransaction().replace(R.id.frameId,fragment).commit();

    }
}