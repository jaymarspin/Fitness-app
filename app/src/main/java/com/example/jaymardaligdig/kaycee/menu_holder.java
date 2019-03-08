package com.example.jaymardaligdig.kaycee;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class menu_holder extends AppCompatActivity implements View.OnClickListener{
    TextView textView;
    Button demo,bmi,diet,quit,monit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_holder);
        textView = findViewById(R.id.nameHolder);
        textView.setText(menu.player);
        demo = findViewById(R.id.demo);
        demo.setOnClickListener(this);
        bmi = findViewById(R.id.bmi);
        bmi.setOnClickListener(this);
        diet = findViewById(R.id.diet);
        quit = findViewById(R.id.quit);
        quit.setOnClickListener(this);
        diet.setOnClickListener(this);
        monit = findViewById(R.id.monitor);
        monit.setOnClickListener(this);


    }

    private static final long delay = 2000L;
    private boolean mRecentlyBackPressed = false;
    private Handler mExitHandler = new Handler();
    private Runnable mExitRunnable = new Runnable() {

        @Override
        public void run() {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            moveTaskToBack(true);
            finish();
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.demo:
                startActivity(new Intent(this,Demo.class));
                break;
            case R.id.bmi:
                startActivity(new Intent(this,bmi.class));
                break;
            case R.id.diet:
                startActivity(new Intent(this,diet.class));
                break;
            case R.id.monitor:
                startActivity(new Intent(this,monitor.class));
                break;
            case R.id.quit:
                finish();
                moveTaskToBack(true);
                break;
        }
    }

    @Override
    public void onBackPressed() {

        if (mRecentlyBackPressed) {
            mExitHandler.removeCallbacks(mExitRunnable);
            mExitHandler = null;
            super.onBackPressed();
        }
        else
        {
            mRecentlyBackPressed = true;
            Toast.makeText(this, "press again to exit", Toast.LENGTH_SHORT).show();
            mExitHandler.postDelayed(mExitRunnable, delay);
        }
    }
}
