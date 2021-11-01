package dev.faculdade.travelin.DataBase.model;

public class ItemOrcamentoModel {
    public static final String
    TABELA_NOME = "ti_orcamento_item";

    public static final String
    COLUNA_ID = "_id",
    COLUNA_ID_ORCAMENTO = "id_orcamento",
    COLUNA_VALOR = "valor",
    COLUNA_TIPO = "tipo";

    public static final String
            CREATE_TABLE = "CREATE TABLE " + ItemOrcamentoModel.TABELA_NOME +
            "(" +
            COLUNA_ID + " integer primary key autoincrement, " +
            COLUNA_ID_ORCAMENTO + " int foreign key references " + OrcamentoModel.TABELA_NOME + "(" + OrcamentoModel.COLUNA_ID + ")," +
            COLUNA_VALOR + " double not null," +
            COLUNA_TIPO + " varchar(100) not null" +
            ")";

    public static final String
            DROP_TABLE = "drop table if exists " + TABELA_NOME;

    private long id, idOrcamento;
    private double valor;
    private String tipo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(long idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
