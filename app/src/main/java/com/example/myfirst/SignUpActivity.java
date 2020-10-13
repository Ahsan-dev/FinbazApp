package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rey.material.widget.CheckBox;

import java.util.regex.Matcher;

public class SignUpActivity extends AppCompatActivity {


    private EditText fNameEdt, lNameEdt, phnEdt, emailEdt, referralEdt, otpMobileEdt, otpEmailEdt;
    private CheckBox termChech;
    private TextView ourPoliciesTxt;
    private Button signUpBtn;
    private String fName, lName, phone, email, referral;
    private Toolbar toolbar;
    private ImageView backBtn;
    private TextView tollbarTitle;
    private TextView sendOTPBtnMobile, sendOTPBtnEmail, verifyMobileOTPBtn, verifyEmailOTPBtn;
    private RelativeLayout otpMobileRelative, otpEmailRelative;
    private ImageView mobVerifiedIcon, emailVerifiedIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fNameEdt = findViewById(R.id.sign_up_first_name_edt);
        lNameEdt = findViewById(R.id.sign_up_last_name_edt);
        phnEdt = findViewById(R.id.sign_up_phone_edt);
        emailEdt = findViewById(R.id.sign_up_email_edt);
        referralEdt = findViewById(R.id.sign_up_referral_edt);
        termChech = findViewById(R.id.sign_up_terms_policy_checker);
        ourPoliciesTxt = findViewById(R.id.sign_up_ourpolicyTxtBtn);
        signUpBtn = findViewById(R.id.sign_up_sign_up_btn);
        sendOTPBtnMobile = findViewById(R.id.sign_up_mobile_send_otp_txt_btn);
        sendOTPBtnEmail = findViewById(R.id.sign_up_email_send_otp_txt_btn);
        verifyMobileOTPBtn = findViewById(R.id.sign_up_mobile_verify_otp_txt_btn);
        verifyEmailOTPBtn = findViewById(R.id.sign_up_email_verify_otp_txt_btn);
        otpMobileRelative = findViewById(R.id.sign_up_mobile_otp_linear);
        otpEmailRelative = findViewById(R.id.sign_up_email_otp_linear);
        mobVerifiedIcon = findViewById(R.id.sign_up_mobile_verified_icon);
        emailVerifiedIcon = findViewById(R.id.sign_up_email_verified_icon);
         otpMobileEdt = findViewById(R.id.sign_up_mobile_otp_edt);
         otpEmailEdt = findViewById(R.id.sign_up_email_otp_edt);



        toolbar = findViewById(R.id.signup_toolbar_id);
        backBtn =findViewById(R.id.savings_account_back_button);
        setSupportActionBar(toolbar);

        tollbarTitle = findViewById(R.id.savings_toolbar_title_id);

        fieldsValidate();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpProcess();
            }
        });


        tollbarTitle.setText("Sign Up");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                warningAlert();
            }
        });


        ourPoliciesTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DisclaimTermsPoliciesActivities.class).putExtra("fromIntent","sign_up"));
            }
        });



    }

    private void fieldsValidate() {


        lName = lNameEdt.getText().toString();
        phone = phnEdt.getText().toString();
        email = emailEdt.getText().toString();
        referral = referralEdt.getText().toString();



        fNameEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {




            }

            @Override
            public void afterTextChanged(Editable edit) {

                if(fNameEdt.getText().toString().contains(" ")){
                    fNameEdt.setText(fNameEdt.getText().toString().replaceAll(" ",""));
                    fNameEdt.setSelection(fNameEdt.getText().length());

                }



            }
        });

        lNameEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {



            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(lNameEdt.getText().toString().contains("  ")){
                    lNameEdt.setText(lNameEdt.getText().toString().replaceAll("  "," "));
                    lNameEdt.setSelection(lNameEdt.getText().length());
                }

            }
        });

        phnEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {



                if(phnEdt.getText().toString().length()==10){

                    sendOTPBtnMobile.setVisibility(View.VISIBLE);

                    sendOTPBtnMobile.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            otpMobileRelative.setVisibility(View.VISIBLE);
                            sendOTPBtnMobile.setText("OTP sent");
                            phnEdt.setEnabled(false);
                            new CountDownTimer(60000,1000){

                                @Override
                                public void onTick(long l) {

                                    otpMobileEdt.addTextChangedListener(new TextWatcher() {
                                        @Override
                                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                        }

                                        @Override
                                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                        }

                                        @Override
                                        public void afterTextChanged(Editable editable) {

                                            if(otpMobileEdt.getText().toString().length()==6){
                                                verifyMobileOTPBtn.setVisibility(View.VISIBLE);

                                                verifyMobileOTPBtn.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        if(otpMobileEdt.getText().toString().trim().equals("123456")){
                                                            sendOTPBtnMobile.setVisibility(View.GONE);
                                                            mobVerifiedIcon.setVisibility(View.VISIBLE);
                                                            otpMobileRelative.setVisibility(View.GONE);
                                                            otpMobileEdt.setText("");
                                                            verifyMobileOTPBtn.setVisibility(View.GONE);

                                                        }
                                                    }
                                                });


                                            }else {
                                                verifyMobileOTPBtn.setVisibility(View.GONE);
                                            }

                                        }
                                    });



                                }

                                @Override
                                public void onFinish() {

                                    if(!(mobVerifiedIcon.getVisibility()==View.VISIBLE)){

                                        resendOtpMobile();



                                    }
                                }
                            }.start();






                        }
                    });

                }else {

                    sendOTPBtnMobile.setVisibility(View.GONE);

                }

            }
        });


        emailEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void afterTextChanged(Editable editable) {


                if(Patterns.EMAIL_ADDRESS.matcher(emailEdt.getText().toString()).matches()){

                    sendOTPBtnEmail.setVisibility(View.VISIBLE);

                    sendOTPBtnEmail.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            otpEmailRelative.setVisibility(View.VISIBLE);
                            sendOTPBtnEmail.setText("OTP sent");
                            //emailRelative.setVisibility(View.GONE);
                            emailEdt.setEnabled(false);

                            new CountDownTimer(120000,1000){

                                @Override
                                public void onTick(long l) {

                                    otpEmailEdt.addTextChangedListener(new TextWatcher() {
                                        @Override
                                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                        }

                                        @Override
                                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                        }

                                        @Override
                                        public void afterTextChanged(Editable editable) {

                                            if(otpEmailEdt.getText().toString().length()==6){
                                                verifyEmailOTPBtn.setVisibility(View.VISIBLE);

                                                verifyEmailOTPBtn.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        if(otpEmailEdt.getText().toString().trim().equals("123456")){
                                                            sendOTPBtnEmail.setVisibility(View.GONE);
                                                            emailVerifiedIcon.setVisibility(View.VISIBLE);
                                                            otpEmailRelative.setVisibility(View.GONE);
                                                            verifyEmailOTPBtn.setVisibility(View.GONE);
                                                            otpEmailEdt.setText("");

                                                        }
                                                    }
                                                });


                                            }else {
                                                verifyEmailOTPBtn.setVisibility(View.GONE);
                                            }

                                        }
                                    });

                                }

                                @Override
                                public void onFinish() {

                                    if(!(emailVerifiedIcon.getVisibility()==View.VISIBLE)){

                                        resendOtpEmail();

                                    }

                                }
                            }.start();



                        }
                    });

                }else {
                    sendOTPBtnEmail.setVisibility(View.GONE);
                }

            }
        });


        referralEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {



            }
        });

//        if(fName.length()<3 || lName.length()<3 || phone.length()<10 || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            signUpBtn.setEnabled(false);
//        }else {
//
//            signUpBtn.setEnabled(true);
//
//        }

//        if(termChech.isChecked()){
//
//            if(TextUtils.isEmpty(fName)){
//                fNameEdt.setError("First name is mandatory !!!");
//                fNameEdt.requestFocus();
//                return;
//            }else if(fName.length()>20 || fName.length()<3){
//                fNameEdt.setError("First name should be between 3 to 20 words !!!");
//                fNameEdt.requestFocus();
//                return;
//            } else if(TextUtils.isEmpty(lName)){
//                lNameEdt.setError("Last name is mandatory !!!");
//                lNameEdt.requestFocus();
//                return;
//            }else if(lName.length()>20 || lName.length()<3){
//                lNameEdt.setError("Last name should be between 3 to 20 words !!!");
//                lNameEdt.requestFocus();
//                return;
//            }else if(TextUtils.isEmpty(phone)){
//                phnEdt.setError("Phone is mandatory !!!");
//                phnEdt.requestFocus();
//                return;
//            }
//            else if(phone.length()<10){
//                phnEdt.setError("Phone number must be of 10 digits ");
//                phnEdt.requestFocus();
//                return;
//            }
//            else if(TextUtils.isEmpty(email)){
//                emailEdt.setError("Email is mandatory !!!");
//                emailEdt.requestFocus();
//                return;
//            }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//                emailEdt.setError("Enter a valid email !!!");
//                emailEdt.requestFocus();
//                return;
//            }else {
//                Toast.makeText(SignUpActivity.this, "Signed Up validate", Toast.LENGTH_SHORT).show();
//            }
//        }else {
//            Toast.makeText(SignUpActivity.this, "Chech Terms And Policies", Toast.LENGTH_SHORT).show();
//        }



    }

    private void resendOtpMobile() {
        verifyMobileOTPBtn.setVisibility(View.GONE);
        sendOTPBtnMobile.setText("Resend OTP");
        otpMobileEdt.setText("");
        otpMobileEdt.setEnabled(false);
        sendOTPBtnMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyMobileOTPBtn.setVisibility(View.GONE);
                sendOTPBtnMobile.setText("OTP sent");
                otpMobileEdt.setEnabled(true);

                new CountDownTimer(60000,1000){

                    @Override
                    public void onTick(long l) {

                        otpMobileEdt.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void afterTextChanged(Editable editable) {

                                if(otpMobileEdt.getText().toString().length()==6){
                                    verifyMobileOTPBtn.setVisibility(View.VISIBLE);

                                    verifyMobileOTPBtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(otpMobileEdt.getText().toString().trim().equals("123456")){
                                                sendOTPBtnMobile.setVisibility(View.GONE);
                                                mobVerifiedIcon.setVisibility(View.VISIBLE);
                                                otpMobileRelative.setVisibility(View.GONE);
                                                //emailRelative.setVisibility(View.VISIBLE);
                                                otpMobileEdt.setText("");
                                                verifyMobileOTPBtn.setVisibility(View.GONE);

                                            }
                                        }
                                    });


                                }else {
                                    verifyMobileOTPBtn.setVisibility(View.GONE);
                                }

                            }
                        });



                    }

                    @Override
                    public void onFinish() {

                        if(!(mobVerifiedIcon.getVisibility()==View.VISIBLE)){

                            resendOtpMobile();



                        }
                    }
                }.start();






            }
        });





    }


    private void resendOtpEmail() {
        verifyEmailOTPBtn.setVisibility(View.GONE);
        sendOTPBtnEmail.setText("Resend OTP");
        otpEmailEdt.setText("");
        otpEmailEdt.setEnabled(false);
        sendOTPBtnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyEmailOTPBtn.setVisibility(View.GONE);
                sendOTPBtnEmail.setText("OTP sent");
                otpEmailEdt.setEnabled(true);

                new CountDownTimer(120000,1000){

                    @Override
                    public void onTick(long l) {

                        otpEmailEdt.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void afterTextChanged(Editable editable) {

                                if(otpEmailEdt.getText().toString().length()==6){
                                    verifyEmailOTPBtn.setVisibility(View.VISIBLE);

                                    verifyEmailOTPBtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(otpEmailEdt.getText().toString().trim().equals("123456")){
                                                sendOTPBtnEmail.setVisibility(View.GONE);
                                                emailVerifiedIcon.setVisibility(View.VISIBLE);
                                                otpEmailRelative.setVisibility(View.GONE);
                                                //emailRelative.setVisibility(View.VISIBLE);
                                                otpEmailEdt.setText("");
                                                verifyEmailOTPBtn.setVisibility(View.GONE);

                                            }
                                        }
                                    });


                                }else {
                                    verifyEmailOTPBtn.setVisibility(View.GONE);
                                }

                            }
                        });



                    }

                    @Override
                    public void onFinish() {

                        if(!(emailVerifiedIcon.getVisibility()==View.VISIBLE)){

                            resendOtpEmail();



                        }
                    }
                }.start();






            }
        });





    }




    @Override
    public void onBackPressed() {
        warningAlert();
    }

    private void signUpProcess() {

        fieldsValidate();




    }

    private void warningAlert() {

        final Dialog dialog = new Dialog(SignUpActivity.this);
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
                Intent mainIntent = new Intent(SignUpActivity.this,MainActivity.class);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mainIntent);
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