package com.example.myfirst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



import com.example.myfirst.Models.SliderItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity  {


    private BottomNavigationView navigationView;
    private NavigationView drawerNavView;
    private Fragment fragment;
    private DrawerLayout drawer;
    private ImageView drawerBtn;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        drawerBtn = findViewById(R.id.drawer_btn);
        toolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        drawerNavView = findViewById(R.id.drawer_nav_view_id);
        drawerNavView.bringToFront();
        drawerNavView.setCheckedItem(R.id.drawer_nav_home);
        drawerNavView.setItemIconTintList(null);


        drawerNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.drawer_nav_home){

                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));

                }

                if(item.getItemId()==R.id.drawer_nav_loan){

                    startActivity(new Intent(getApplicationContext(),LoanActivity.class));

                }

                if(item.getItemId()==R.id.drawer_nav_savings_account){

                    startActivity(new Intent(getApplicationContext(),SavingsAccountActivity.class));

                }

                if(item.getItemId()==R.id.drawer_nav_insurance){

                    startActivity(new Intent(getApplicationContext(),InsuranceActivity.class));

                }

                if(item.getItemId()==R.id.drawer_nav_credit_card){

                    startActivity(new Intent(getApplicationContext(),CreditCardActivity.class));

                }

                if(item.getItemId()==R.id.drawer_nav_demat_account){

                    startActivity(new Intent(getApplicationContext(),DematActivity.class));

                }

                if(item.getItemId()==R.id.drawer_nav_credit_score){

                    startActivity(new Intent(getApplicationContext(),CreditScoreActivity.class));

                }

                if(item.getItemId()==R.id.drawer_nav_miscellaneous){

                    startActivity(new Intent(getApplicationContext(),MiscellaneousActivity.class));

                }

                if(item.getItemId()==R.id.drawer_nav_blog){

                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));

                }

                if(item.getItemId()==R.id.drawer_nav_contact_us){

                    startActivity(new Intent(getApplicationContext(),ContactUsActivity.class));

                }

                if(item.getItemId()==R.id.drawer_nav_about_us){

                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));

                }

                if(item.getItemId()==R.id.drawer_nav_our_policies){

                    startActivity(new Intent(getApplicationContext(),DisclaimTermsPoliciesActivities.class).putExtra("fromIntent","home"));

                }

                if(item.getItemId()==R.id.drawer_nav_our_logout){

                    final Dialog dialog = new Dialog(HomeActivity.this);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.dialog_layout);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

                    TextView message = (TextView) dialog.findViewById(R.id.alertDialogMessageId);
                    message.setText("Do you want to exit?");

                    TextView yesBtn = dialog.findViewById(R.id.alert_positive_btn_id);
                    TextView noBtn = dialog.findViewById(R.id.alert_negative_btn_id);
                    yesBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
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


                return true;
            }
        });


        drawerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer = findViewById(R.id.drawer_layout_id);
                if(!drawer.isDrawerOpen(Gravity.LEFT)) drawer.openDrawer(Gravity.LEFT);
                else drawer.closeDrawer(Gravity.RIGHT);
            }
        });






       navigationView = findViewById(R.id.navigationId);

        if(savedInstanceState == null){

            getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_id,new HomeFragment()).commit();

        }else {

            getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_id, fragment).commit();

        }


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                fragment = null;

                if(item.getItemId() == R.id.navigation_home){

                    fragment = new HomeFragment();
                    toolbar.setVisibility(View.VISIBLE);


                }
                if(item.getItemId() == R.id.navigation_emi_calculator){

                    fragment = new EMICalculatorFragment();
                    toolbar.setVisibility(View.GONE);

                }
                if(item.getItemId() == R.id.navigation_offers){

                    fragment = new OffersFragment();
                    toolbar.setVisibility(View.GONE);

                }
                if(item.getItemId() == R.id.navigation_refer_earn){

                    fragment = new ReferAndEarnFragment();
                    toolbar.setVisibility(View.GONE);

                }
                if(item.getItemId() == R.id.navigation_account){

                    fragment = new MyProfileFragment();
                    toolbar.setVisibility(View.GONE);

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_id,fragment).commit();

                return false;
            }
        });







    }

    @Override
    public void onBackPressed() {
       final Dialog dialog = new Dialog(HomeActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView message = (TextView) dialog.findViewById(R.id.alertDialogMessageId);
       message.setText("Do you want to exit ?");

        TextView yesBtn = dialog.findViewById(R.id.alert_positive_btn_id);
        TextView noBtn = dialog.findViewById(R.id.alert_negative_btn_id);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
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




}