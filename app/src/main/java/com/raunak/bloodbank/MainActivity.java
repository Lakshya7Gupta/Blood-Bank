package com.raunak.bloodbank;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity  {


    Button buttonDonor;
    Button buttonInfo;
    Button needBlood;

    public static String donorId="no";
    SharedPreferences sharedPreferences;

    LocationManager locationManager;
    LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Wiring up every thing
         */


        buttonInfo = (Button) findViewById(R.id.btn_info);
        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Information.class));
            }
        });

        needBlood = (Button) findViewById(R.id.btn_need_blood);
        needBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NeedBlood.class));
            }
        });


        buttonDonor = (Button) findViewById(R.id.btn_donor_profile);
        if(donorId.toString().equals("no")){
            buttonDonor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, DonorForm.class));
                }
            });
        } else {

        }

        /**
         * Initializing variable
         */
        try{
            donorId = sharedPreferences.getString("id","no");

        } catch (Exception e){
            e.printStackTrace();
        }





    }


}
