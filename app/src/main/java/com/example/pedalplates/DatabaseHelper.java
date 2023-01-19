package com.example.pedalplates;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class DatabaseHelper  extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PedalPlates.db";
    public static final String TABLE_NAME = "SignUp";

    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "USERNAME";
    public static final String COL4 = "PASSWORD";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,USERNAME TEXT,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public boolean insertData(String name, String username, String password) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, username);
        contentValues.put(COL4, password);


        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor alldata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from signup", null);
        return cursor;
    }















}
