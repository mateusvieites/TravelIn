package dev.faculdade.travelin.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.appcompat.widget.TintContextWrapper;

import dev.faculdade.travelin.DataBase.model.LoginModel;

public class DBOpenHelper extends SQLiteOpenHelper {
    public static final String
    DATABASE_NOME = "TravelIn.db";

    public static final int
    DATABASE_VERSAO = 1;

    public DBOpenHelper(final Context contexto){
        super(contexto,DATABASE_NOME,null,DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LoginModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(LoginModel.DROP_TABLE);
        db.execSQL(LoginModel.CREATE_TABLE);
    }
}
