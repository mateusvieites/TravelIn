package dev.faculdade.travelin.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.appcompat.widget.TintContextWrapper;

import dev.faculdade.travelin.DataBase.model.ItemOrcamentoModel;
import dev.faculdade.travelin.DataBase.model.LoginModel;
import dev.faculdade.travelin.DataBase.model.OrcamentoModel;

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
        db.execSQL(OrcamentoModel.CREATE_TABLE);
        db.execSQL(ItemOrcamentoModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(LoginModel.DROP_TABLE);
        db.execSQL(LoginModel.CREATE_TABLE);
        db.execSQL(OrcamentoModel.DROP_TABLE);
        db.execSQL(OrcamentoModel.CREATE_TABLE);
        db.execSQL(ItemOrcamentoModel.DROP_TABLE);
        db.execSQL(ItemOrcamentoModel.CREATE_TABLE);
    }
}
