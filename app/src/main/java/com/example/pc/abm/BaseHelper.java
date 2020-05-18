package com.example.pc.abm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseHelper extends SQLiteOpenHelper {

    String tabla = "CREATE TABLE PERSONAS (ID INTEGER PRIMARY KEY, NOMBRE TEXT, APELLIDO TEXT)";

    public BaseHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    //CREO TABLA
        db.execSQL(tabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //BORRO Y CREO TABLA
        db.execSQL("DROP TABLE PERSONAS");
        db.execSQL(tabla);
    }
}
