package com.raunak.bloodbank;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ListViewAdapter extends BaseAdapter {
    Activity context;
    ArrayList<String> name;
    ArrayList<String> city;
    ArrayList<String> blood;
    ArrayList<String> mob;
    public ListViewAdapter(DonorList context, ArrayList<String> name, ArrayList<String> city, ArrayList<String> blood, ArrayList<String> mob)
    {
        super();
        this.context=context;
        this.name=name;
        this.city=city;
        this.blood=blood;
        this.mob=mob;

    }


    @Override
    public int getCount() {

        return name.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView txtviewname;
        TextView txtviewcity;
        TextView txtblood;
        TextView txtmob;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;


        LayoutInflater inflater=context.getLayoutInflater();
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.donor,null);
            holder=new ViewHolder();
            holder.txtviewname=(TextView)convertView.findViewById(R.id.nam);


            holder.txtviewcity=(TextView)convertView.findViewById(R.id.city);
            holder.txtblood=(TextView)convertView.findViewById(R.id.blood);
            holder.txtmob=(TextView)convertView.findViewById(R.id.mob) ;



            holder.txtviewname.setText(name.get(position));
            holder.txtviewcity.setText(city.get(position));

            holder.txtblood.setText(blood.get(position)) ;
            holder.txtmob.setText(mob.get(position));

        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }


       // notifyDataSetChanged();
        return convertView;
    }


}
