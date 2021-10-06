package dev.faculdade.travelin.DataBase.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import dev.faculdade.travelin.DataBase.DBOpenHelper;
import dev.faculdade.travelin.DataBase.model.LoginModel;

public class LoginDAO extends AbstrataDAO {

    private final String[] colunas = {
            LoginModel.COLUNA_ID,
            LoginModel.COLUNA_USUARIO,
            LoginModel.COLUNA_SENHA
    };

    public LoginDAO(final Context contexto) {
        helper = new DBOpenHelper(contexto);
    }

    public long Insert(LoginModel model) {

        long linhasAfetadas;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(LoginModel.COLUNA_USUARIO, model.getUsuario());
            values.put(LoginModel.COLUNA_SENHA, model.getSenha());
            linhasAfetadas = db.insert(LoginModel.TABELA_NOME, null, values);
        } finally {
            Close();
        }

        return linhasAfetadas;
    }

    public int Delete() {
        return 0;
    }

    public int Update() {
        return 0;
    }

    public LoginModel Select(final String usuario, final String senha) {

        LoginModel model = null;

        try {
            Open();
            Cursor cursor = db.query(
                    LoginModel.TABELA_NOME,
                    colunas,
                    LoginModel.COLUNA_USUARIO + " = ? and " + LoginModel.COLUNA_SENHA + " = ?",
                    new String[]{usuario, senha},
                    null,
                    null,
                    null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                model = cursorToStructur(cursor);
                break;
            }
        } finally {
            Close();
        }

        return model;
    }

    public List<LoginModel> Select() {

        List<LoginModel> lista = new ArrayList<LoginModel>();

        try {
            Open();
            Cursor cursor = db.query(LoginModel.TABELA_NOME, colunas, null, null, null, null, null);
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                lista.add(cursorToStructur(cursor));
                cursor.moveToNext();
            }
        } finally {
            Close();
        }

        return lista;
    }

    public final LoginModel cursorToStructur(Cursor cursor) {
        LoginModel model = new LoginModel();
        model.setId(cursor.getLong(0));
        model.setUsuario(cursor.getString(1));
        model.setSenha(cursor.getString(2));
        return model;
    }
}
