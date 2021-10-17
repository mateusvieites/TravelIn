package dev.faculdade.travelin.DataBase.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import dev.faculdade.travelin.DataBase.DBOpenHelper;
import dev.faculdade.travelin.DataBase.model.OrcamentoModel;

public class OrcamentoDAO extends AbstrataDAO {

    private final String[] colunas = {
            OrcamentoModel.COLUNA_ID,
            OrcamentoModel.COLUNA_DESCRICAO
    };

    public OrcamentoDAO(final Context contexto) {
        helper = new DBOpenHelper(contexto);
    }

    public long Insert(OrcamentoModel model) {

        long linhasAfetadas;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(OrcamentoModel.COLUNA_DESCRICAO, model.getDescricao());
            linhasAfetadas = db.insert(OrcamentoModel.TABELA_NOME, null, values);
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

    public OrcamentoModel Select(final String descricao) {

        OrcamentoModel model = null;

        try {
            Open();
            Cursor cursor = db.query(
                    OrcamentoModel.TABELA_NOME,
                    colunas,
                    OrcamentoModel.COLUNA_DESCRICAO + " = ?",
                    new String[]{descricao},
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

    public List<OrcamentoModel> Select() {

        List<OrcamentoModel> lista = new ArrayList<>();

        try {
            Open();
            Cursor cursor = db.query(OrcamentoModel.TABELA_NOME, colunas, null, null, null, null, null);
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

    public final OrcamentoModel cursorToStructur(Cursor cursor) {
        OrcamentoModel model = new OrcamentoModel();
        model.setId(cursor.getLong(0));
        model.setDescricao(cursor.getString(1));
        return model;
    }
}
