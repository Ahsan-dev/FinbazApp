package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.poovam.pinedittextfield.PinField;
import com.poovam.pinedittextfield.SquarePinField;

import org.jetbrains.annotations.NotNull;

public class OTPActivity extends AppCompatActivity {

    private SquarePinField otpPinField;
    private String otpReceived = "123456";
    private TextView resendOtp;
    private Button otpSubmitBtn;
    private Toolbar otpToolbar;
    private TextView otpTitle;
    private ImageView otpBackIcon;
    private String toogleText;
    private int finalTime, interval;
    private boolean otpSucceed = false;
    private TextView otpVerifyTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);

        toogleText = getIntent().getStringExtra("otpKey");

        otpPinField = findViewById(R.id.otp_field_pin_edt);
        resendOtp = findViewById(R.id.otp_field_resend_txt);
        otpSubmitBtn = findViewById(R.id.otp_submit_btn);
        otpToolbar = findViewById(R.id.otp_toolbar_id);
        otpTitle = findViewById(R.id.savings_toolbar_title_id);
        otpBackIcon = findViewById(R.id.savings_account_back_button);
        otpVerifyTitle = findViewById(R.id.otp_vify_title);


        resendOtp.setVisibility(View.GONE);
        otpSubmitBtn.setVisibility(View.VISIBLE);

        setSupportActionBar(otpToolbar);

        otpTitle.setText("OTP Verification");
        otpBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otpBackIntent = new Intent(OTPActivity.this, MainActivity.class);
                otpBackIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(otpBackIntent);
            }
        });


        if(toogleText.equals("mobile")){

            otpVerifyTitle.setText("Please enter 6 digits OTP sent to your mobile number.");

            finalTime = 60000;
            interval = 1000;


        }else {
            otpVerifyTitle.setText("Please enter 6 digits OTP sent to your email address.");

            finalTime = 120000;
            interval = 1000;

        }



        new CountDownTimer(finalTime,interval){

            @Override
            public void onTick(long l) {

                otpSubmitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String otp = otpPinField.getText().toString();
                        if(otp.length()==0){
                            otpPinField.setError("Enter your 6 digit pin");
                            otpPinField.requestFocus();
                            return;
                        }
                        else if(otp.length()<6){
                            otpPinField.setError("Enter your 6 digit pin");
                            otpPinField.requestFocus();
                            return;
                        }else {

                            if(otpReceived.equals(otp)) {
                                Intent intent = new Intent(OTPActivity.this, HomeActivity.class);
                                otpSucceed = true;
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }

                        }
                    }
                });


            }

            @Override
            public void onFinish() {

                if(otpSucceed==false){

                    resendOtp.setVisibility(View.VISIBLE);
                    otpSubmitBtn.setVisibility(View.GONE);
                    resendOtp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            otpSubmitBtn.setVisibility(View.VISIBLE);
                            resendOtp.setVisibility(View.GONE);
                        }
                    });

                }

            }
        }.start();
















    }
}