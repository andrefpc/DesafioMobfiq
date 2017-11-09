package com.andrefpc.desafiomobfiq.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FavoriteDAO {
    private SQLiteDatabase db;
    private CreateDB createDB;
    private Context context;

    public FavoriteDAO(Context context){
        createDB = new CreateDB(context);
        this.context = context;
    }

    public boolean exists(String id){
        Cursor cursor;
        String[] campos =  {createDB.ID_PRODUCT};
        String where = CreateDB.ID_PRODUCT + "= '" + id + "'";
        db = createDB.getReadableDatabase();
        cursor = db.query(CreateDB.TABLE_FAVORITE,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }

        db.close();

        boolean result = false;

        if (cursor.getCount() > 0) {
            result = true;
        }

        cursor.close();

        return result;
    }

    public boolean saveOrDelete(String id){
        if(exists(id)){
            db = createDB.getWritableDatabase();
            String where = CreateDB.ID_PRODUCT + "= '" + id + "'";

            db.delete(CreateDB.TABLE_FAVORITE, where, null);
            db.close();
        }else{
            ContentValues valores;
            valores = new ContentValues();
            db = createDB.getWritableDatabase();
            valores.put(CreateDB.ID_PRODUCT, id);

            db.insert(CreateDB.TABLE_FAVORITE, null, valores);
            db.close();
        }

        return true;
    }
}
