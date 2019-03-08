package com.example.jaymardaligdig.kaycee;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class monitor extends AppCompatActivity implements View.OnClickListener{
    Button button,jan,feb,march,april,may,june,july,aug,sep,oct,nov,dec,adder;
    Dialog dialog;
    Spinner sItems;
    EditText kg,cm,description;
    mDatabase database;
    public static long dater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        button = findViewById(R.id.monit);
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.monitordialog);
        button.setOnClickListener(this);
        jan = findViewById(R.id.jan);
        feb = findViewById(R.id.feb);
        march = findViewById(R.id.march);
        april = findViewById(R.id.april);
        may = findViewById(R.id.may);
        june = findViewById(R.id.june);
        july = findViewById(R.id.july);
        aug = findViewById(R.id.aug);
        sep = findViewById(R.id.sep);
        oct = findViewById(R.id.oct);
        nov = findViewById(R.id.nov);
        dec = findViewById(R.id.dec);
        database = new mDatabase(this);

        jan.setOnClickListener(this);
        feb.setOnClickListener(this);
        march.setOnClickListener(this);
        april.setOnClickListener(this);
        may.setOnClickListener(this);
        june.setOnClickListener(this);
        july.setOnClickListener(this);
        aug.setOnClickListener(this);
        sep.setOnClickListener(this);
        oct.setOnClickListener(this);
        nov.setOnClickListener(this);
        dec.setOnClickListener(this);

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("2019");
        spinnerArray.add("2020");


        kg = dialog.findViewById(R.id.kg);
        cm = dialog.findViewById(R.id.cm);
        description = dialog.findViewById(R.id.description);
        adder = dialog.findViewById(R.id.adder);
        adder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kgg = kg.getText().toString().trim();
                String cmm = cm.getText().toString().trim();
                String des = description.getText().toString().trim();
                String dater = new Date().getTime()+"";
               boolean stash =  database.addMonitor(dater,"nothing",des,kgg,cmm,menu.player,new Date().toString());
               if(stash == true){
                   dialog.dismiss();
                   Toast.makeText(monitor.this,"Successfully Recorded",Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(monitor.this,"Something Went wrong!",Toast.LENGTH_SHORT).show();
               }


            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = findViewById(R.id.sItems);
        sItems.setAdapter(adapter);


        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

    }
    public static String parser = "2019";
    public static String tmp = "";
    public static String tmp2 = "";

    public static String monther = "";
private int month = 0;
private boolean passer = true;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jan:
                passer = true;
                month = 1;
                monther = "January";
                break;
            case R.id.feb:
                passer = true;
                month = 2;
                monther = "February";
                break;
            case R.id.march:
                passer = true;
                month = 3;
                monther = "March";
                break;
            case R.id.april:
                passer = true;
                month = 4;
                monther = "April";
                break;
            case R.id.may:
                passer = true;
                month = 5;
                monther = "May";
                break;
            case R.id.june:
                passer = true;
                month = 6;
                monther = "June";
                break;
            case R.id.july:
                passer = true;
                month = 7;
                monther = "July";
                break;
            case R.id.aug:
                passer = true;
                month = 8;
                monther = "August";
                break;
            case R.id.sep:
                passer = true;
                month = 9;
                monther = "September";
                break;
            case R.id.oct:
                passer = true;
                month = 10;
                monther = "October";
                break;
            case R.id.nov:
                passer = true;
                month = 11;
                monther = "November";
                break;
            case R.id.dec:
                passer = true;
                month = 12;
                monther = "December";
                break;
            case R.id.monit:
                passer = false;
                dialog.show();

                break;
        }
         tmp = "1-"+month+"-"+parser;
        tmp2 = "1-"+(month + 1)+"-"+parser;
        if(month == 12){
            tmp2 = "1-1"+"-"+(parser + 1);
        }

        if(passer == true){
            startActivity(new Intent(monitor.this,com.example.jaymardaligdig.kaycee.month.class));
        }

    }
}
