package dev.faculdade.travelin.DataBase.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import dev.faculdade.travelin.DataBase.DBOpenHelper;
import dev.faculdade.travelin.DataBase.model.OrcamentoModel;

public class OrcamentoDAO extends AbstractDAO {

    private final String[] colunas = {
            OrcamentoModel.COLUNA_ID,
            OrcamentoModel.COLUNA_DESCRICAO,
            OrcamentoModel.COLUNA_TOTAL_VIAJANTES,
            OrcamentoModel.COLUNA_DURACAO_VIAGEM,
            OrcamentoModel.COLUNA_TOTAL_VIAGEM,
            OrcamentoModel.COLUNA_GASOLINA_TOTAL_KM,
            OrcamentoModel.COLUNA_GASOLINA_MEDIA_POR_LITRO,
            OrcamentoModel.COLUNA_GASOLINA_CUSTO_MEDIO,
            OrcamentoModel.COLUNA_GASOLINA_TOTAL_VEICULOS,
            OrcamentoModel.COLUNA_GASOLINA_ADICIONAR,
            OrcamentoModel.COLUNA_TARIFA_CUSTO_POR_PESSOA,
            OrcamentoModel.COLUNA_TARIFA_ALUGUEL_VEICULO,
            OrcamentoModel.COLUNA_TARIFA_ADICIONAR,
            OrcamentoModel.COLUNA_REFEICAO_CUSTO,
            OrcamentoModel.COLUNA_REFEICAO_POR_DIA,
            OrcamentoModel.COLUNA_REFEICAO_ADICIONAR,
            OrcamentoModel.COLUNA_HOSPEDAGEM_CUSTO_MEDIO,
            OrcamentoModel.COLUNA_HOSPEDAGEM_NOITES,
            OrcamentoModel.COLUNA_HOSPEDAGEM_QUARTOS,
            OrcamentoModel.COLUNA_HOSPEDAGEM_ADICIONAR
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
            values.put(OrcamentoModel.COLUNA_TOTAL_VIAJANTES, model.getTotalViajantes());
            values.put(OrcamentoModel.COLUNA_DURACAO_VIAGEM, model.getDuracaoViagem());
            values.put(OrcamentoModel.COLUNA_TOTAL_VIAGEM, model.getTotalViagem());
            values.put(OrcamentoModel.COLUNA_GASOLINA_TOTAL_KM, model.getGasolinaTotalKM());
            values.put(OrcamentoModel.COLUNA_GASOLINA_MEDIA_POR_LITRO, model.getGasolinaMediaPLitro());
            values.put(OrcamentoModel.COLUNA_GASOLINA_CUSTO_MEDIO, model.getGasolinaCustoMedio());
            values.put(OrcamentoModel.COLUNA_GASOLINA_TOTAL_VEICULOS, model.getGasolinaTotalVeiculos());
            values.put(OrcamentoModel.COLUNA_GASOLINA_ADICIONAR, model.isGasolinaAdicionar());
            values.put(OrcamentoModel.COLUNA_TARIFA_CUSTO_POR_PESSOA, model.getTarifaCustoPPessoa());
            values.put(OrcamentoModel.COLUNA_TARIFA_ALUGUEL_VEICULO, model.getTarifaAluguelVeiculo());
            values.put(OrcamentoModel.COLUNA_TARIFA_ADICIONAR, model.isTarifaAdicionar());
            values.put(OrcamentoModel.COLUNA_REFEICAO_CUSTO, model.getRefeicaoCusto());
            values.put(OrcamentoModel.COLUNA_REFEICAO_POR_DIA, model.getRefeicaoPDia());
            values.put(OrcamentoModel.COLUNA_REFEICAO_ADICIONAR, model.isRefeicaoAdicionar());
            values.put(OrcamentoModel.COLUNA_HOSPEDAGEM_CUSTO_MEDIO, model.getHospedagemCustoMedio());
            values.put(OrcamentoModel.COLUNA_HOSPEDAGEM_NOITES, model.getHospedagemNoites());
            values.put(OrcamentoModel.COLUNA_HOSPEDAGEM_QUARTOS, model.getHospedagemQuartos());
            values.put(OrcamentoModel.COLUNA_HOSPEDAGEM_ADICIONAR, model.isHospedagemAdicionar());
            linhasAfetadas = db.insert(OrcamentoModel.TABELA_NOME, null, values);
        } finally {
            Close();
        }

        return linhasAfetadas;
    }

    public void Delete(final Integer id) {
        Open();
        db.delete(OrcamentoModel.TABELA_NOME, OrcamentoModel.COLUNA_ID + " = ?", new String[]{id.toString()});
        Close();
    }

    public int Update(
            final Integer id,
            final String descricao,
            final int totalViajantes,
            final int duracaoViagem,
            final double totalViagem,
            final double gasolinaTotalKM,
            final double gasolinaMediaPLitro,
            final double gasolinaCustoMedio,
            final int gasolinaTotalVeiculos,
            final boolean gasolinaAdicionar,
            final double tarifaCustoPPessoa,
            final double tarifaAluguelVeiculo,
            final boolean tarifaAdicionar,
            final double refeicaoCusto,
            final int refeicaoPDia,
            final boolean refeicaoAdicionar,
            final double hospedagemCustoMedio,
            final int hospedagemNoites,
            final int hospedagemQuartos,
            final boolean hospedagemAdicionar
    ) {

        int linhasAfetadas = 0;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(OrcamentoModel.COLUNA_DESCRICAO, descricao);
            values.put(OrcamentoModel.COLUNA_TOTAL_VIAJANTES, totalViajantes);
            values.put(OrcamentoModel.COLUNA_DURACAO_VIAGEM, duracaoViagem);
            values.put(OrcamentoModel.COLUNA_TOTAL_VIAGEM, totalViagem);
            values.put(OrcamentoModel.COLUNA_GASOLINA_TOTAL_KM, gasolinaTotalKM);
            values.put(OrcamentoModel.COLUNA_GASOLINA_MEDIA_POR_LITRO, gasolinaMediaPLitro);
            values.put(OrcamentoModel.COLUNA_GASOLINA_CUSTO_MEDIO, gasolinaCustoMedio);
            values.put(OrcamentoModel.COLUNA_GASOLINA_TOTAL_VEICULOS, gasolinaTotalVeiculos);
            values.put(OrcamentoModel.COLUNA_GASOLINA_ADICIONAR, gasolinaAdicionar);
            values.put(OrcamentoModel.COLUNA_TARIFA_CUSTO_POR_PESSOA, tarifaCustoPPessoa);
            values.put(OrcamentoModel.COLUNA_TARIFA_ALUGUEL_VEICULO, tarifaAluguelVeiculo);
            values.put(OrcamentoModel.COLUNA_TARIFA_ADICIONAR, tarifaAdicionar);
            values.put(OrcamentoModel.COLUNA_REFEICAO_CUSTO, refeicaoCusto);
            values.put(OrcamentoModel.COLUNA_REFEICAO_POR_DIA, refeicaoPDia);
            values.put(OrcamentoModel.COLUNA_REFEICAO_ADICIONAR, refeicaoAdicionar);
            values.put(OrcamentoModel.COLUNA_HOSPEDAGEM_CUSTO_MEDIO, hospedagemCustoMedio);
            values.put(OrcamentoModel.COLUNA_HOSPEDAGEM_NOITES, hospedagemNoites);
            values.put(OrcamentoModel.COLUNA_HOSPEDAGEM_QUARTOS, hospedagemQuartos);
            values.put(OrcamentoModel.COLUNA_HOSPEDAGEM_ADICIONAR, hospedagemAdicionar);
            linhasAfetadas = db.update(OrcamentoModel.TABELA_NOME, values, OrcamentoModel.COLUNA_ID + " = ?", new String[]{id.toString()});
        } finally {
            Close();
        }

        return linhasAfetadas;
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
        model.setTotalViajantes(cursor.getInt(2));
        model.setDuracaoViagem(cursor.getInt(3));
        model.setTotalViagem(cursor.getDouble(4));
        model.setGasolinaTotalKM(cursor.getDouble(5));
        model.setGasolinaMediaPLitro(cursor.getDouble(6));
        model.setGasolinaCustoMedio(cursor.getDouble(7));
        model.setGasolinaTotalVeiculos(cursor.getInt(8));
        model.setGasolinaAdicionar(cursor.getInt(9) != 0);
        model.setTarifaCustoPPessoa(cursor.getDouble(10));
        model.setTarifaAluguelVeiculo(cursor.getDouble(11));
        model.setTarifaAdicionar(cursor.getInt(12) != 0);
        model.setRefeicaoCusto(cursor.getDouble(13));
        model.setRefeicaoPDia(cursor.getInt(14));
        model.setRefeicaoAdicionar(cursor.getInt(15) != 0);
        model.setHospedagemCustoMedio(cursor.getDouble(16));
        model.setHospedagemNoites(cursor.getInt(17));
        model.setHospedagemQuartos(cursor.getInt(18));
        model.setHospedagemAdicionar(cursor.getInt(19) != 0);
        return model;
    }
}
