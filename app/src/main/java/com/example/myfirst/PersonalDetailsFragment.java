package com.example.myfirst;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class PersonalDetailsFragment extends Fragment {

    private TextView genderTxt, dobTxt, stateTxt, cityTxt, areaCodeTxt, edtReqTxtBtn;
    private Spinner genderSpinner, stateSpinner, citySpinner ;
    private Button submitBtn;
    private ImageView dobBtn;
    private EditText areaCodeEdt;
    private DatePickerDialog dobPicker;
    private String[] gender;
    private View view;
    private String selectedGender, personalEdtApproval="approved";
    private int bDay, bMonth, bYear;
    private StringBuilder dobString;
    private ArrayAdapter<String> genderAdapter;






    public PersonalDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_personal_details, container, false);

        gender = view.getResources().getStringArray(R.array.gender_array);


        genderSpinner = view.findViewById(R.id.personal_detail_gender_spinner_id);
        genderTxt = view.findViewById(R.id.personal_detail_gender_txt_id);
        dobBtn = view.findViewById(R.id.personal_detail_dob_btn_id);
        dobTxt = view.findViewById(R.id.personal_detail_dob_txt_id);
        stateTxt = view.findViewById(R.id.personal_detail_state_txt_id);
        stateSpinner = view.findViewById(R.id.personal_detail_state_spinner_id);
        cityTxt = view.findViewById(R.id.personal_detail_city_txt_id);
        citySpinner = view.findViewById(R.id.personal_detail_city_spinner_id);
        areaCodeTxt = view.findViewById(R.id.personal_detail_area_code_txt_id);
        areaCodeEdt = view.findViewById(R.id.personal_detail_area_code_edt_id);
        submitBtn = view.findViewById(R.id.personal_detail_submit_btn_id);
        edtReqTxtBtn = view.findViewById(R.id.personal_detail_edt_request_txt_id);


        genderSelection();


        dobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dobMaker();

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if(personalEdtApproval == "approved"){

            edtReqTxtBtn.setVisibility(View.GONE);
            genderSpinner.setVisibility(View.VISIBLE);
            dobBtn.setVisibility(View.VISIBLE);
            citySpinner.setVisibility(View.VISIBLE);
            stateSpinner.setVisibility(View.VISIBLE);
            areaCodeEdt.setVisibility(View.VISIBLE);
            submitBtn.setVisibility(View.VISIBLE);

        }else {

            edtReqTxtBtn.setVisibility(View.VISIBLE);
            genderSpinner.setVisibility(View.GONE);
            dobBtn.setVisibility(View.GONE);
            stateSpinner.setVisibility(View.GONE);
            citySpinner.setVisibility(View.GONE);
            areaCodeEdt.setVisibility(View.GONE);
            submitBtn.setVisibility(View.GONE);

        }

    }


    private void dobMaker() {

        DatePicker datePicker = new DatePicker(view.getContext());
        int bdyear = datePicker.getYear();
        final int bdMonth = (datePicker.getMonth())+1;
        final int bdDay = datePicker.getDayOfMonth();

        dobPicker = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

                bYear = year;
                bMonth = month;
                bDay = dayOfMonth;

                dobString = new StringBuilder();
                dobString.append(dayOfMonth+"/");
                dobString.append((month+1)+"/");
                dobString.append(year);


            }
        },bdyear,bdMonth,bdDay);
        dobPicker.show();

    }


    private void genderSelection() {
        genderAdapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,gender);
        genderSpinner.setAdapter(genderAdapter);
        selectedGender =  genderSpinner.getSelectedItem().toString();

    }
}