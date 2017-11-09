package com.andrefpc.desafiomobfiq.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "desafio.db";

    public static final String TABLE_FAVORITE = "favorite";
    public static final String ID_PRODUCT = "id_product";

    private static final int VERSAO = 1;

    public CreateDB(Context context) {
        super(context, DATABASE_NAME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        //Funcionario
        String sqlAplicativos = "CREATE TABLE " + TABLE_FAVORITE + " ("
                + ID_PRODUCT + " text UNIQUE"
                +" ); ";
        db.execSQL(sqlAplicativos);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITE);
        onCreate(db);
    }
}
