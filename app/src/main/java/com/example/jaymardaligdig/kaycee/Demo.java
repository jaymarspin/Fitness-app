package com.example.jaymardaligdig.kaycee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Demo extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String fruitName[] = {"ABS","BUTT","CHEST","LEG"};
    Integer img_id[] = {R.drawable.abs,R.drawable.butt,R.drawable.chest,R.drawable.leg};
    public static String demo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ListView listView = findViewById(R.id.listView);
        CustomListView customListView = new CustomListView(this,fruitName,img_id);
        listView.setAdapter(customListView);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                demo = "abs";
                break;
            case 1:
                demo = "butt";
                break;
            case 2:
                demo = "chest";
                break;
            case 3:
                demo = "leg";
        }
        startActivity(new Intent(this,demo_start.class));

    }
}
