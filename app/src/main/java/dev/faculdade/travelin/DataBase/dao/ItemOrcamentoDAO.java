package dev.faculdade.travelin.DataBase.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import dev.faculdade.travelin.DataBase.DBOpenHelper;
import dev.faculdade.travelin.DataBase.model.ItemOrcamentoModel;

public class ItemOrcamentoDAO extends AbstrataDAO {

    private final String[] colunas = {
            ItemOrcamentoModel.COLUNA_ID,
            ItemOrcamentoModel.COLUNA_ID_ORCAMENTO,
            ItemOrcamentoModel.COLUNA_VALOR,
            ItemOrcamentoModel.COLUNA_TIPO
    };

    public ItemOrcamentoDAO(final Context contexto) {
        helper = new DBOpenHelper(contexto);
    }

    public long Insert(ItemOrcamentoModel model) {

        long linhasAfetadas;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(ItemOrcamentoModel.COLUNA_ID_ORCAMENTO, model.getIdOrcamento());
            values.put(ItemOrcamentoModel.COLUNA_VALOR, model.getValor());
            values.put(ItemOrcamentoModel.COLUNA_TIPO, model.getTipo());
            linhasAfetadas = db.insert(ItemOrcamentoModel.TABELA_NOME, null, values);
        } finally {
            Close();
        }

        return linhasAfetadas;
    }

    public void Delete(final Integer id) {
        Open();
        db.delete(ItemOrcamentoModel.TABELA_NOME, ItemOrcamentoModel.COLUNA_ID + " = ?", new String[]{id.toString()});
        Close();
    }

    public int Update(final Integer id, Integer idOrcamento, Double valor, String tipo) {

        int linhasAfetadas = 0;

        try {
            Open();

            ContentValues values = new ContentValues();
            if (idOrcamento != null) {
                values.put(ItemOrcamentoModel.COLUNA_ID_ORCAMENTO, idOrcamento);
            }
            if (!valor.isNaN()) {
                values.put(ItemOrcamentoModel.COLUNA_VALOR, valor);
            }
            if (tipo != null) {
                values.put(ItemOrcamentoModel.COLUNA_TIPO, tipo);
            }
            linhasAfetadas = db.update(ItemOrcamentoModel.TABELA_NOME, values, ItemOrcamentoModel.COLUNA_ID + " = ?", new String[]{id.toString()});
        } finally {
            Close();
        }

        return linhasAfetadas;
    }

    public ItemOrcamentoModel Select(final Integer id) {

        ItemOrcamentoModel model = null;

        try {
            Open();
            Cursor cursor = db.query(
                    ItemOrcamentoModel.TABELA_NOME,
                    colunas,
                    ItemOrcamentoModel.COLUNA_ID + " = ?",
                    new String[]{id.toString()},
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

    public List<ItemOrcamentoModel> Select() {

        List<ItemOrcamentoModel> lista = new ArrayList<>();

        try {
            Open();
            Cursor cursor = db.query(ItemOrcamentoModel.TABELA_NOME, colunas, null, null, null, null, null);
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

    public final ItemOrcamentoModel cursorToStructur(Cursor cursor) {
        ItemOrcamentoModel model = new ItemOrcamentoModel();
        model.setId(cursor.getLong(0));
        model.setIdOrcamento(cursor.getLong(1));
        model.setValor(cursor.getDouble(2));
        model.setTipo(cursor.getString(3));
        return model;
    }
}
