package com.example.jaymardaligdig.kaycee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class demo_start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_start);
        switch (Demo.demo){
            case "abs":
                break;
            case "butt":
                setContentView(R.layout.butt);
                break;
            case "chest":
                setContentView(R.layout.chest);
                break;
            case "leg":
                setContentView(R.layout.leg);
                break;
        }

    }
}
