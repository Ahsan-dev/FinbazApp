package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView emailTxtBtn, mobileTextBtn;
    private EditText emailEdt, mobileEdt;
    private Button continueBtn;
    private TextView signUpTxtBtn;
    private ImageView fbImgBtn, googleImgBtn;
    private String toggleTabTxt = "email";
    private String otpReceived;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTxtBtn = findViewById(R.id.sign_up_toggle_email_btn);
        mobileTextBtn = findViewById(R.id.sign_up_toggle_phn_btn);
        emailEdt = findViewById(R.id.sign_in_email_edt);
        mobileEdt = findViewById(R.id.sign_in_phone_edt);
        continueBtn = findViewById(R.id.sign_in_continue_btn_id);
        signUpTxtBtn = findViewById(R.id.sign_in_have_no_account_sign_up_btn);
//        fbImgBtn = findViewById(R.id.sign_in_fb_btn);
//        googleImgBtn = findViewById(R.id.sign_in_google_btn);

        toggleTabTxt = "email";
        emailTxtBtn.setBackgroundResource(R.drawable.back_phone);
        emailTxtBtn.setTextColor(getResources().getColor(R.color.colorTitle));


        mobileTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleTabTxt = "mobile";
                mobileTextBtn.setBackgroundResource(R.drawable.back_phone);
                mobileTextBtn.setTextColor(getResources().getColor(R.color.colorTitle));
                emailTxtBtn.setBackgroundResource(R.drawable.back_toggle_sign);
                emailTxtBtn.setTextColor(getResources().getColor(android.R.color.white));
                mobileEdt.setVisibility(View.VISIBLE);
                emailEdt.setVisibility(View.GONE);

            }
        });
        emailTxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleTabTxt = "email";
                emailTxtBtn.setBackgroundResource(R.drawable.back_phone);
                emailTxtBtn.setTextColor(getResources().getColor(R.color.colorTitle));
                mobileTextBtn.setBackgroundResource(R.drawable.back_toggle_sign);
                mobileTextBtn.setTextColor(getResources().getColor(android.R.color.white));
                emailEdt.setVisibility(View.VISIBLE);
                mobileEdt.setVisibility(View.GONE);

            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(toggleTabTxt.equals("email")){
                    functionForOtp();
                }else {
                    functionForOtpMobile();
                }
            }
        });

        signUpTxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent signupIntent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(signupIntent);

            }
        });





    }

    @Override
    public void onBackPressed() {

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_layout);

        TextView message = (TextView) dialog.findViewById(R.id.alertDialogMessageId);
        message.setText("Do you want to exit?");

        TextView yesBtn = dialog.findViewById(R.id.alert_positive_btn_id);
        TextView noBtn = dialog.findViewById(R.id.alert_negative_btn_id);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
                System.exit(0);
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

    private void functionForOtp() {

        if(toggleTabTxt.equals("email")){
            String email = emailEdt.getText().toString();
            if(TextUtils.isEmpty(email)){
                emailEdt.setError("Email is mandatory !!!");
                emailEdt.requestFocus();
                return;
            }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailEdt.setError("Enter a valid email !!!");
                emailEdt.requestFocus();
                return;
            }else {

                Intent otpIntent = new Intent(MainActivity.this,OTPActivity.class);
                otpIntent.putExtra("otpKey",toggleTabTxt);
                startActivity(otpIntent);

            }
        }

    }

    private void functionForOtpMobile() {

        if(toggleTabTxt.equals("mobile")){
            String mobile = mobileEdt.getText().toString();
            if(TextUtils.isEmpty(mobile)){
                mobileEdt.setError("Mobile Number is mandatory !!!");
                mobileEdt.requestFocus();
                return;
            }else if(mobile.length()<10){
                mobileEdt.setError("Enter a 10 digit number!!!");
                mobileEdt.requestFocus();
                return;
            } else if(mobile.startsWith("0")){
            mobileEdt.setError("Enter number after 0");
            mobileEdt.requestFocus();
            return;
        }
            else {

                Intent otpIntent = new Intent(MainActivity.this,OTPActivity.class);
                otpIntent.putExtra("otpKey",toggleTabTxt);
                startActivity(otpIntent);

            }
        }

    }
}