package com.example.jaymardaligdig.kaycee;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class month extends AppCompatActivity {

    mDatabase database;
    ListView listView;
    TextView monthly;
    String now = "";
    TextView dater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);

        monthly = findViewById(R.id.monthly);
        database = new mDatabase(this);
        Cursor data = database.data("select * from monitor");
        now = monitor.monther+" of "+monitor.parser;
        dater = findViewById(R.id.dater);
        dater.setText(now);
        long tmp;
        SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
        Date dater = null;
        Date dater2 = null;
        try{
            dater = d.parse(monitor.tmp);
            dater2 = d.parse(monitor.tmp2);
        }catch (Exception e){

        }
        int count = 0;
        while (data.moveToNext()){
            try{
                tmp = Long.parseLong(data.getString(2));
                if(dater.getTime() <= tmp && tmp < dater2.getTime()){
                    count += 1;
                }
            }catch (NumberFormatException e){
                return;
            }

        }
        if(count > 0){
            String h[] = new String[count];
            String w[] = new String[count];
            String did[] = new String[count];
            String hh[] = new String[count];
            String ww[] = new String[count];
            String timer[] = new String[count];

            Cursor data2 = database.data("select * from monitor");
            count = 0;
            while (data2.moveToNext()){
                try{
                    tmp = Long.parseLong(data2.getString(2));
                    if(dater.getTime() <= tmp && tmp < dater2.getTime()){

                        w[count] = data2.getString(4);
                        h[count] = data2.getString(5);
                        did[count] = data2.getString(3);
                        ww[count] = data2.getString(4)+"kg";
                        hh[count] = data2.getString(5)+"cm";

                        String t[] = data2.getString(7).split(" ");
                        String real = t[0]+" "+t[1]+" "+t[2]+" "+t[3];
                        timer[count] = real;
                        count += 1;
                    }
                }catch (Exception e){
                    return;
                }

            }


            ListView listView = findViewById(R.id.dailydone);
            customListView2 customListView = new customListView2(this,did,ww,hh,timer);
            listView.setAdapter(customListView);
            int tmp1 = 0;
            int tmp2 = 0;
            int tmph1 = 0;
            int tmph2 = 0;
            try{
                tmp1 = Integer.parseInt(w[0]);
                tmp2 = Integer.parseInt(w[count - 1]);
                tmph1 = Integer.parseInt(h[0]);
                tmph2 = Integer.parseInt(h[count - 1]);
            }catch (NumberFormatException e){
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
            String mark  ="";
            String mark2  ="";
            if(tmp1 < tmp2){
                mark = "You gain weight from day 1 which you have "+tmp1+" kg to "+tmp2+" kg";
            }else if(tmp1 == tmp2){
                mark = "Nothing have changed in your weight";
            }

            else{
                mark = "You loose weight from day 1 which you have "+tmp1+" kg to "+tmp2+" kg";
            }
            if(tmph1 < tmph2){
                mark2 = "You gain height from day 1 which you have "+tmph1+" cm to "+tmph2+" cm";
            }else if(tmph1 == tmph2){
                mark2 = "Nothing have changed in your height";
            }

            else{
                mark2 = "You loose height from day 1 which you have "+tmph1+" cm to "+tmph2+" cm";
            }
            String all = mark+" and "+mark2;

            monthly.setText(all);
        }


    }
}
