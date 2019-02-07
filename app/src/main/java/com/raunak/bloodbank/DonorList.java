package com.raunak.bloodbank;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DonorList extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_list);

        listView= (ListView) findViewById(R.id.list_donor);
        ArrayList<String> arrayList1=new ArrayList<>();
        ArrayList<String> arrayList2=new ArrayList<>();
        ArrayList<String> arrayList3=new ArrayList<>();
        ArrayList<String> arrayList4=new ArrayList<>();


        DatabaseHandler db = new DatabaseHandler(this);
        List<Donorss> contacts = db.getAllContacts();
        for (Donorss cn : contacts) {
            arrayList1.add(cn.getName());
            arrayList2.add(cn.getCity());
            arrayList3.add(cn.getGrp());
            arrayList4.add(cn.getMob());
        }





        ListViewAdapter adapter=new ListViewAdapter(this,arrayList1,arrayList2,arrayList3,arrayList4);
        listView.setAdapter(adapter);




    }
}
