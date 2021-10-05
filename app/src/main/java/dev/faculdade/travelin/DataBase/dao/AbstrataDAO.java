package dev.faculdade.travelin.DataBase.dao;

import android.database.sqlite.SQLiteDatabase;

import dev.faculdade.travelin.DataBase.DBOpenHelper;

public class AbstrataDAO {
    protected SQLiteDatabase db;
    protected DBOpenHelper helper;

    protected final void Open(){
        db = helper.getWritableDatabase();
    }

    protected final void Close(){
        helper.close();
    }
}
