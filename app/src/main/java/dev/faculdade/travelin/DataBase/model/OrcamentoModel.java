package dev.faculdade.travelin.DataBase.model;

public class OrcamentoModel {
    public static final String
    TABELA_NOME = "ti_orcamento";

    public static final String
    COLUNA_ID = "_id",
    COLUNA_DESCRICAO = "descricao";

    public static final String
    CREATE_TABLE = "CREATE TABLE " + OrcamentoModel.TABELA_NOME +
            "(" +
            COLUNA_ID + " integer primary key autoincrement, " +
            COLUNA_DESCRICAO + " text not null" +
            ")";

    public static final String
    DROP_TABLE = "drop table if exists " + TABELA_NOME;

    private long id;
    private String descricao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
