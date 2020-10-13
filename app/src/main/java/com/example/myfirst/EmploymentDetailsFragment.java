package com.example.myfirst;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class EmploymentDetailsFragment extends Fragment {

    private View view;
    private TextView employmentTypeTxt, companyNameTxt, workExperienceTxt, monthlyIncomeTxt;
    private Spinner employmentTypeSpinner,  workExperienceSpinner, monthlyIncomeSpinner;
    private EditText companyNameEdt;
    private Button submitBtn;
    private TextView employmentDetailsEdtReqBtn;
    private String[] employmentTypeArray, workExperienceArray, monthlyIncomeArray;
    private ArrayAdapter<String> employmentTypeAdapter, workExperienceAdapter, monthlyIncomeAdapter;
    private String employmentType, workExperience, monthlyIncome;
    private String employmentEdtApproval = "approved";





    public EmploymentDetailsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_employment_details, container, false);

        employmentTypeTxt = view.findViewById(R.id.employment_detail_employment_type_txt_id);
        employmentTypeSpinner = view.findViewById(R.id.employment_detail_employment_type_spinner_id);
        companyNameTxt = view.findViewById(R.id.employment_detail_company_name_txt_id);
        companyNameEdt = view.findViewById(R.id.employment_detail_company_name_edt_id);
        workExperienceTxt = view.findViewById(R.id.employment_detail_total_experience_txt_id);
        workExperienceSpinner = view.findViewById(R.id.employment_detail_total_experience_spinner_id);
        monthlyIncomeTxt = view.findViewById(R.id.employment_detail_monthly_income_txt_id);
        monthlyIncomeSpinner = view.findViewById(R.id.employment_detail_monthly_income_spinner_id);
        submitBtn = view.findViewById(R.id.employment_detail_submit_btn_id);
        employmentDetailsEdtReqBtn = view.findViewById(R.id.employment_detail_edt_request_txt_id);

        employmentTypeArray = view.getResources().getStringArray(R.array.employment_type_array);
        workExperienceArray = view.getResources().getStringArray(R.array.working_experience_array);
        monthlyIncomeArray = view.getResources().getStringArray(R.array.monthly_income_array);

        employmentTypeMaker();
        workingExperienceMaker();
        monthlyIncomeMaker();


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if(employmentEdtApproval == "approved"){

            employmentDetailsEdtReqBtn.setVisibility(View.GONE);
            employmentTypeSpinner.setVisibility(View.VISIBLE);
            companyNameEdt.setVisibility(View.VISIBLE);
            workExperienceSpinner.setVisibility(View.VISIBLE);
            monthlyIncomeSpinner.setVisibility(View.VISIBLE);
            submitBtn.setVisibility(View.VISIBLE);

        }else {

            employmentDetailsEdtReqBtn.setVisibility(View.VISIBLE);
            employmentTypeSpinner.setVisibility(View.GONE);
            companyNameEdt.setVisibility(View.GONE);
            workExperienceSpinner.setVisibility(View.GONE);
            monthlyIncomeSpinner.setVisibility(View.GONE);
            submitBtn.setVisibility(View.GONE);


        }

    }



    private void monthlyIncomeMaker() {

        monthlyIncomeAdapter = new ArrayAdapter<>(view.getContext(),R.layout.spinner_item_layout,R.id.spinner_item_txt,monthlyIncomeArray);
        monthlyIncomeSpinner.setAdapter(monthlyIncomeAdapter);
        monthlyIncome = monthlyIncomeSpinner.getSelectedItem().toString();
    }

    private void workingExperienceMaker() {

        workExperienceAdapter = new ArrayAdapter<>(view.getContext(),R.layout.spinner_item_layout,R.id.spinner_item_txt,workExperienceArray);
        workExperienceSpinner.setAdapter(workExperienceAdapter);
        workExperience = workExperienceSpinner.getSelectedItem().toString();



    }

    private void employmentTypeMaker() {

        employmentTypeAdapter = new ArrayAdapter<>(view.getContext(),R.layout.spinner_item_layout,R.id.spinner_item_txt,employmentTypeArray);
        employmentTypeSpinner.setAdapter(employmentTypeAdapter);
        employmentType = employmentTypeSpinner.getSelectedItem().toString();

    }
}