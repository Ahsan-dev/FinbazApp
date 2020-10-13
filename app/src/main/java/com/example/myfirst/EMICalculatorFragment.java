package com.example.myfirst;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.opengl.ETC1;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xw.repo.BubbleSeekBar;

import java.text.NumberFormat;
import java.util.Locale;

public class EMICalculatorFragment extends Fragment implements View.OnClickListener {

    private LinearLayout personalLoanBtn, businessLoanBtn, homeLoanBtn, goldLoanBtn, eduLoanBtn, carLoanBtn, twoWheelerLoanBtn, usedCarLoanBtn;
    private View view;
    private TextView loanTitle, calculateBtn;
    private EditText loanAmountEdt, irEdt, tenureEdt;
    private BubbleSeekBar loanAmountSeek, irSeek, tenureSeek;
    private String loanAmount, ir, tenure;
    private double emi, totalIrPayable, totalAmountPayable;
    private String loanTypeTitle="";
    private Toolbar toolbar;
    private ImageView backBtn;
    private TextView tollbarTitle;
    private boolean changeProgrammatically;

    public EMICalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_e_m_i_calculator, container, false);

        toolbar = view.findViewById(R.id.savings_toolbar_id);
        tollbarTitle = view.findViewById(R.id.savings_toolbar_title_id);
        backBtn = view.findViewById(R.id.savings_account_back_button);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        tollbarTitle.setText("EMI Calculator");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),HomeActivity.class));
            }
        });

        personalLoanBtn = view.findViewById(R.id.emi_calculator_personal_loan_linear);
        businessLoanBtn = view.findViewById(R.id.emi_calculator_business_loan_linear);
        homeLoanBtn = view.findViewById(R.id.emi_calculator_home_loan_linear);
        goldLoanBtn = view.findViewById(R.id.emi_calculator_gold_loan_linear);
        eduLoanBtn = view.findViewById(R.id.emi_calculator_education_loan_linear);
        carLoanBtn = view.findViewById(R.id.emi_calculator_car_loan_linear);
        twoWheelerLoanBtn = view.findViewById(R.id.emi_calculator_2_wheeler_loan_linear);
        usedCarLoanBtn = view.findViewById(R.id.emi_calculator_used_car_loan_linear);
        loanTitle = view.findViewById(R.id.emi_calculator_loan_title);
        loanAmountEdt = view.findViewById(R.id.emi_calculator_loan_amount_edt);
        irEdt = view.findViewById(R.id.emi_calculator_ir_edt);
        tenureEdt = view.findViewById(R.id.emi_calculator_tenure_edt);
        loanAmountSeek = view.findViewById(R.id.emi_calculator_loan_amount_seekbar);
        irSeek = view.findViewById(R.id.emi_calculator_ir_seek);
        tenureSeek = view.findViewById(R.id.emi_calculator_tenure_seek);
        calculateBtn = view.findViewById(R.id.emi_calculator_calculate_btn);


        personalLoanBtn.setOnClickListener(this);
        businessLoanBtn.setOnClickListener(this);
        homeLoanBtn.setOnClickListener(this);
        goldLoanBtn.setOnClickListener(this);
        eduLoanBtn.setOnClickListener(this);
        carLoanBtn.setOnClickListener(this);
        twoWheelerLoanBtn.setOnClickListener(this);
        usedCarLoanBtn.setOnClickListener(this);



        personalLoanBtn.setBackgroundResource(R.drawable.emi_selector_back);
        businessLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
        homeLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
        goldLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
        eduLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
        carLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
        twoWheelerLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
        usedCarLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
        loanTypeTitle = "Personal Loan";
        loanTitle.setText(loanTypeTitle);




        loanAmountSeek.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                if(fromUser) loanAmountEdt.setText(String.valueOf(progress));
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }
        });

        irSeek.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
//                changeProgrammatically = true;
                if(fromUser) irEdt.setText(String.valueOf(progressFloat));
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }
        });

        tenureSeek.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                if(fromUser) tenureEdt.setText(String.valueOf(progress));
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }
        });


        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });



        validateTextWatcher();



        return view;

    }




    @Override
    public void onClick(final View view) {

        if(view.getId()==R.id.emi_calculator_personal_loan_linear){
            loanTypeTitle = "Personal Loan";

            loanAmountEdt.setText("");
            irEdt.setText("");
            tenureEdt.setText("");
            loanAmountSeek.setProgress(1000);
            irSeek.setProgress(0);
            tenureSeek.setProgress(3);
            personalLoanBtn.setBackgroundResource(R.drawable.emi_selector_back);
            businessLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            homeLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            goldLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            eduLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            carLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            twoWheelerLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            usedCarLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
        }
        if(view.getId()==R.id.emi_calculator_business_loan_linear){
            loanTypeTitle="Business Loan";
            loanTitle.setText(loanTypeTitle);
            loanAmountEdt.setText("");
            irEdt.setText("");
            tenureEdt.setText("");
            loanAmountSeek.setProgress(1000);
            irSeek.setProgress(0);
            tenureSeek.setProgress(3);
            personalLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            businessLoanBtn.setBackgroundResource(R.drawable.emi_selector_back);
            homeLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            goldLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            eduLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            carLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            twoWheelerLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            usedCarLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);

        }
        if(view.getId()==R.id.emi_calculator_home_loan_linear){
            loanTypeTitle = "Home Loan";
            loanTitle.setText(loanTypeTitle);
            loanAmountEdt.setText("");
            irEdt.setText("");
            tenureEdt.setText("");
            loanAmountSeek.setProgress(1000);
            irSeek.setProgress(0);
            tenureSeek.setProgress(3);
            personalLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            businessLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            homeLoanBtn.setBackgroundResource(R.drawable.emi_selector_back);
            goldLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            eduLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            carLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            twoWheelerLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            usedCarLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);

        }
        if(view.getId()==R.id.emi_calculator_gold_loan_linear){
            loanTypeTitle = "Gold Loan";
            loanTitle.setText(loanTypeTitle);
            loanAmountEdt.setText("");
            irEdt.setText("");
            tenureEdt.setText("");
            loanAmountSeek.setProgress(1000);
            irSeek.setProgress(0);
            tenureSeek.setProgress(3);
            personalLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            businessLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            homeLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            goldLoanBtn.setBackgroundResource(R.drawable.emi_selector_back);
            eduLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            carLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            twoWheelerLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            usedCarLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);

        }
        if(view.getId()==R.id.emi_calculator_education_loan_linear){
            loanTypeTitle = "Education Loan";
            loanTitle.setText(loanTypeTitle);
            loanAmountEdt.setText("");
            irEdt.setText("");
            tenureEdt.setText("");
            loanAmountSeek.setProgress(1000);
            irSeek.setProgress(0);
            tenureSeek.setProgress(3);

            personalLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            businessLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            homeLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            goldLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            eduLoanBtn.setBackgroundResource(R.drawable.emi_selector_back);
            carLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            twoWheelerLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            usedCarLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);

        }
        if(view.getId()==R.id.emi_calculator_car_loan_linear){
            loanTypeTitle = "Car Loan";
            loanTitle.setText(loanTypeTitle);
            loanAmountEdt.setText("");
            irEdt.setText("");
            tenureEdt.setText("");
            loanAmountSeek.setProgress(1000);
            irSeek.setProgress(0);
            tenureSeek.setProgress(3);
            personalLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            businessLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            homeLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            goldLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            eduLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            carLoanBtn.setBackgroundResource(R.drawable.emi_selector_back);
            twoWheelerLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            usedCarLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);

        }
        if(view.getId()==R.id.emi_calculator_2_wheeler_loan_linear){
            loanTypeTitle = "Two-Wheeler Loan";
            loanTitle.setText(loanTypeTitle);
            loanAmountEdt.setText("");
            irEdt.setText("");
            tenureEdt.setText("");
            loanAmountSeek.setProgress(1000);
            irSeek.setProgress(0);
            tenureSeek.setProgress(3);
            personalLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            businessLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            homeLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            goldLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            eduLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            carLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            twoWheelerLoanBtn.setBackgroundResource(R.drawable.emi_selector_back);
            usedCarLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);

        }
        if(view.getId()==R.id.emi_calculator_used_car_loan_linear){
            loanTypeTitle = "Used Car Loan";
            loanTitle.setText(loanTypeTitle);
            loanAmountEdt.setText("");
            irEdt.setText("");
            tenureEdt.setText("");
            loanAmountSeek.setProgress(1000);
            irSeek.setProgress(0);
            tenureSeek.setProgress(3);
            personalLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            businessLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            homeLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            goldLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            eduLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            carLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            twoWheelerLoanBtn.setBackgroundResource(R.drawable.emi_selector_back_black);
            usedCarLoanBtn.setBackgroundResource(R.drawable.emi_selector_back);

        }




    }


    private void validate() {

        loanAmount = loanAmountEdt.getText().toString();
        ir = irEdt.getText().toString();
        tenure = tenureEdt.getText().toString();




        if(loanAmount.equals("") || Integer.parseInt(loanAmount)<1000 || Integer.parseInt(loanAmount)>50000000){
            loanAmountEdt.setError("Loan amount is mandatory and must be InR 1000 - 50000000");
            loanAmountEdt.requestFocus();
            return;
        }else if(ir.equals("") || Float.parseFloat(ir)>50.0){
            irEdt.setError("Interest rate is mandatory and must be 0% - 50%");
            irEdt.requestFocus();
            return;
        }else if(tenure.equals("") || Integer.parseInt(tenure)<3 || Integer.parseInt(tenure)>240) {
            tenureEdt.setError("Tenure is mandatory and must be 3 - 240 months");
            tenureEdt.requestFocus();
            return;
        }else{

            int loan = Integer.parseInt(loanAmount);
            float irVal = Float.parseFloat(ir);
            int tenures = Integer.parseInt(tenure);
            calculateEMI(loan, irVal, tenures);
            showInAlertDialog();

            loanAmountEdt.setText("");
            irEdt.setText("");
            tenureEdt.setText("");
            loanAmountSeek.setProgress(1000);
            irSeek.setProgress(0);
            tenureSeek.setProgress(3);

        }


    }



    private void calculateEMI(int loan, float irVal, int tenures) {

        double p = (double)loan;
        double r = ((double) irVal)/(12*100);
        double t = (double) tenures;
        if(r==0) emi = p/t;
        else emi = p*r*(((Math.pow((1+r),t))/((Math.pow((1+r),t))-1)));
         totalIrPayable = (emi*t)-p;
         totalAmountPayable = p+totalIrPayable;
    }


    private void validateTextWatcher() {

//        loanAmount = loanAmountEdt.getText().toString();
//        ir = irEdt.getText().toString();
//        tenure = tenureEdt.getText().toString();

        loanAmountEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {




            }

            @Override
            public void afterTextChanged(Editable editable) {

                try {
                    int progress = Math.round(Float.parseFloat(editable.toString()));

                        loanAmountSeek.setProgress(progress);



                } catch (Exception e) {}



            }
        });

         irEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {




            }

            @Override
            public void afterTextChanged(Editable editable) {

                try {
                    float progress = Float.parseFloat(editable.toString());

                    irSeek.setProgress(progress);



                } catch (Exception e) {}



            }
        });


          tenureEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {




            }

            @Override
            public void afterTextChanged(Editable editable) {

                try {
                    int progress = Math.round(Float.parseFloat(editable.toString()));

                    tenureSeek.setProgress(progress);



                } catch (Exception e) {}



            }
        });

    }







    private void showInAlertDialog() {

        final Dialog dialog = new Dialog(view.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setCancelable(false);
        dialog.setContentView(R.layout.emi_display_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView DialogloanTitle = dialog.findViewById(R.id.emi_dialog_loan_title);
        TextView DialogloanAmountTxt = dialog.findViewById(R.id.emi_dialog_loan_amount_text);
        TextView DialogIrText =  dialog.findViewById(R.id.emi_dialog_interest_rate_text);
        TextView DialogTenureText =  dialog.findViewById(R.id.emi_dialog_tenure_text);
        TextView DialogEMIText =  dialog.findViewById(R.id.emi_dialog_emi_text);
        TextView DialogTotalIrText = dialog.findViewById(R.id.emi_dialog_total_ir_text);
        TextView DialogTotalAmountText =  dialog.findViewById(R.id.emi_dialog_total_amount_text);
        TextView okBtn = dialog.findViewById(R.id.emi_dialog_ok_btn);

        Locale locale = new Locale("en", "IN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);




        DialogloanTitle.setText(loanTypeTitle);
        DialogloanAmountTxt.setText("Total Loan Amount: "+ currencyFormatter.format(Integer.parseInt(loanAmount)));
        DialogIrText.setText("Interest Rate : "+ir+"%");
        DialogTenureText.setText("Total Tenure (Months) : "+tenure);
        DialogEMIText.setText("Monthly EMI : " +currencyFormatter.format((int)emi));
        DialogTotalIrText.setText("Total Interest Payable : "+currencyFormatter.format((int)totalIrPayable));
        DialogTotalAmountText.setText("Total Amount Payable : "+currencyFormatter.format((int)totalAmountPayable));

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();



    }
}