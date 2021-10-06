package dev.faculdade.travelin.DataBase.model;

public class LoginModel {
    public static final String
    TABELA_NOME = "ti_login";

    public static final String
    COLUNA_ID = "_id",
    COLUNA_USUARIO = "usuario",
    COLUNA_SENHA = "SENHA";

    public static final String
    CREATE_TABLE = "CREATE TABLE " + LoginModel.TABELA_NOME +
            "("+
            COLUNA_ID + " integer primary key autoincrement, "+
            COLUNA_USUARIO + " text not null, " +
            COLUNA_SENHA + " text not null "+
            ")";
    public static final String
    DROP_TABLE = "drop table if exits " + TABELA_NOME;

    //Atributos de usuario
    private long id;
    private String usuario;
    private String Senha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
