package com.raunak.bloodbank;

/**
 * Created by JASPREET SINGH on 18-10-2017.
 */

public class Donorss {

        //private variables
        int _id;
        String name;
        String city;
        String grp;
        String mob;

        // Empty constructor
  public Donorss()
  {

  }
        // constructor
        public Donorss(int id, String name,String city,String grp,String mob){
            this._id = id;

            this.name = name;
            this.city = city;
            this.grp = grp;
            this.mob = mob;
        }

        // constructor
        public Donorss( String name,String city,String grp,String mob){


            this.name = name;
            this.city = city;
            this.grp = grp;
            this.mob = mob;
        }

        // getting ID
        public int getID(){
            return this._id;
        }

        // setting id
        public void setID(int id){
            this._id = id;
        }



        // getting name
        public String getCity(){
            return this.city;
        }

        // setting name
        public void setCity(String city){
            this.city = city;
        }

    public String getGrp(){
        return this.grp;
    }

    // setting name
    public void setGrp(String grp){
        this.grp = grp;
    }

    public String getMob(){
        return this.mob;
    }

    // setting name
    public void setMob(String mob){
        this.mob = mob;
    }


    public String getName(){
        return this.name;
    }

    // setting name
    public void setName(String name){
        this.name = name;
    }



}












