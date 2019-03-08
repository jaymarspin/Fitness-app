package com.example.jaymardaligdig.kaycee;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class mDatabase extends SQLiteOpenHelper {

    private static String table_name = "player";
    private static String table_name2 = "stage";
    private static String table_name3 = "monitor";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + table_name +"(i" +
                "d INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
        db.execSQL(createTable);
        createTable = "CREATE TABLE " + table_name2 +"(id INTEGER PRIMARY KEY AUTOINCREMENT, remarks TEXT,name TEXT)";
        db.execSQL(createTable);
        createTable = "CREATE TABLE " + table_name3 +"(id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT,dater TEXT,description TEXT,weight TEXT, height TEXT, name TEXT,stamp TEXT)";
        db.execSQL(createTable);
    }
    public mDatabase(Context context){
        super(context,table_name,null,1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXIST "+ table_name);
        onCreate(db);
        db.execSQL("DROP IF TABLE EXIST "+ table_name2);
        onCreate(db);
        db.execSQL("DROP IF TABLE EXIST "+ table_name3);
        onCreate(db);
    }

    public boolean addName(String value){
        SQLiteDatabase db = this.getWritableDatabase();
        String q = "INSERT INTO "+table_name+"(name) VALUES('"+ value +"')";
        db.execSQL(q);
        return true;
    }

    public boolean addMonitor(String dater,String type, String description, String weight, String height, String name,String stamp){
        SQLiteDatabase db = this.getWritableDatabase();
        String q = "INSERT INTO "+table_name3+"(dater,type,description,weight,height,name,stamp) VALUES('"+ dater +"','"+ type +"','"+ description +"','"+ weight +"','"+ height +"','"+ name +"','"+ stamp +"')";
        db.execSQL(q);
        return true;
    }

    public boolean addScore(int value){
        SQLiteDatabase db = this.getWritableDatabase();
        String q = "";
        db.execSQL(q);
        return true;
    }

    public Cursor data(String q){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data = db.rawQuery(q,null);
        return data;
    }
}
