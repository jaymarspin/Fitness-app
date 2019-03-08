package com.example.jaymardaligdig.kaycee;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bmi extends AppCompatActivity implements View.OnClickListener{
    TextView y_bmi,remarks;
    Button calculate;
    EditText height,weight;
    mDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(this);
        y_bmi = findViewById(R.id.your_bmi);
        remarks = findViewById(R.id.remarks);
        database = new mDatabase(this);


    }

    @Override
    public void onClick(View v) {
        double result;
        try {
            int h = Integer.parseInt(height.getText().toString());
            int w = Integer.parseInt(weight.getText().toString());
            double tmp = (double)h / 1000;
            tmp = tmp * tmp;
            result = (double)w - tmp;
            Toast.makeText(this,"Body Mass Index Calculated!",Toast.LENGTH_SHORT).show();
            Cursor data = database.data("select * from monitor");
            int hh = 0;
            int ww = 0;
            double s = 0;
            while (data.moveToNext()){
                try{
                    hh = Integer.parseInt(data.getString(5));
                    ww = Integer.parseInt(data.getString(4));
                    double res = (double)hh / 1000;
                    res = res * res;
                    s = (double)ww - res;
                }catch (NumberFormatException e){
                    Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }

            y_bmi.setText("Body Mass Index: "+result);
            String mark = "";
            if(result > s){
                mark = "your BMI has increased according to the data of your last monitoring which you have from "+s+" to "+result;
            }else if(result < s){
                mark = "your BMI has decreased according to the data of your last monitoring which you have from "+s+" to "+result;
            }else{
                mark = "your BMI has not changed yet from last monitoring";
            }
            remarks.setText(mark);
        }catch (NumberFormatException e){
            Toast.makeText(this,"Please input only numbers",Toast.LENGTH_SHORT).show();
        }
    }
}
