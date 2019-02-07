package com.raunak.bloodbank;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

public class NeedBlood extends AppCompatActivity {
    Spinner groupChoice;
    Spinner cityChoice;
    Button need;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_blood);

        cityChoice = (Spinner) findViewById(R.id.needCity);
        groupChoice = (Spinner) findViewById(R.id.needBlood);
        need = (Button) findViewById(R.id.startSearch);

        String[] citis = new String[]{"Delhi","Lucknow", "Bareilly", "Noida","Gurgaon", "Shahdara", "Nainital", "Kochin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, citis);
        cityChoice.setAdapter(adapter);


        String[] group = new String[]{"O+","O-", "A+", "B+","A-", "B-", "AB+", "AB-"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, group);
        groupChoice.setAdapter(adapter1);


        need.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String group = groupChoice.getSelectedItem().toString();
                String city = cityChoice.getSelectedItem().toString();

                Intent intent = new Intent(NeedBlood.this, DonorList.class);

                startActivity(intent);


                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                List<Donorss> contacts = db.getAllContacts();
                for (Donorss cn : contacts) {

                    if ((cn.getCity().equals(city))&&(cn.getGrp().equals(group)))
                    {



                        addNotification(city,group);

                    }
                    else
                        addNotificationnot(city,group);




                }




            }
        });

    }








    private void addNotification(String city,String bgrp) {
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Required Blood Group available")
                        .setContentText("Blood group "+bgrp+" is available in "+city);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    private void addNotificationnot(String city,String bgrp) {
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Required Blood Group is not available")
                        .setContentText("Blood group "+bgrp+" is not available in "+city);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }





}
