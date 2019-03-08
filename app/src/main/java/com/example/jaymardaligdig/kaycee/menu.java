package com.example.jaymardaligdig.kaycee;

import android.content.Intent;
import android.database.Cursor;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class menu extends AppCompatActivity implements View.OnClickListener {
    Button next;
    ConstraintLayout constraintLayout;
    EditText namer;
    mDatabase database;
    public static String player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        next = findViewById(R.id.next);
        next.setOnClickListener(this);
        constraintLayout = findViewById(R.id.holder);
        namer = findViewById(R.id.namer);
        database = new mDatabase(this);
        int count = 0;
        Cursor cursor = database.data("select * from player order by id ASC");
        while (cursor.moveToNext()){
            count += 1;
            player = cursor.getString(1);
        }
        if(count > 0){
            startActivity(new Intent(this,menu_holder.class));
        }

    }

    @Override
    public void onClick(View v) {
        String name = namer.getText().toString().trim();
        boolean stash = database.addName(name);
        if(stash == true){
        startActivity(new Intent(menu.this,menu_holder.class));
        }



    }
}
