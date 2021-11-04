package dev.faculdade.travelin.DataBase.model;

public class OrcamentoModel {
    public static final String
    TABELA_NOME = "ti_orcamento";

    public static final String
    COLUNA_ID = "_id",
    COLUNA_DESCRICAO = "descricao",
    COLUNA_TOTAL_VIAJANTES = "total_viajantes",
    COLUNA_DURACAO_VIAGEM = "duracao_viagem",
    COLUNA_TOTAL_VIAGEM = "total_viagem",
    COLUNA_GASOLINA_TOTAL_KM = "gasolina_total_km",
    COLUNA_GASOLINA_MEDIA_POR_LITRO = "gasolina_media_litro",
    COLUNA_GASOLINA_CUSTO_MEDIO = "gasolina_custo_medio",
    COLUNA_GASOLINA_TOTAL_VEICULOS = "gasolina_total_veiculos",
    COLUNA_GASOLINA_ADICIONAR = "gasolina_adicionar",
    COLUNA_TARIFA_CUSTO_POR_PESSOA = "tarifa_custo_pessoa",
    COLUNA_TARIFA_ALUGUEL_VEICULO = "tarifa_aluguel_veiculo",
    COLUNA_TARIFA_ADICIONAR = "tarifa_adicionar",
    COLUNA_REFEICAO_CUSTO = "refeicao_custo",
    COLUNA_REFEICAO_POR_DIA = "refeicao_dia",
    COLUNA_REFEICAO_ADICIONAR = "refeicao_adicionar",
    COLUNA_HOSPEDAGEM_CUSTO_MEDIO = "hospedagem_custo_medio",
    COLUNA_HOSPEDAGEM_NOITES = "hospedagem_noites",
    COLUNA_HOSPEDAGEM_QUARTOS = "hospedagem_quartos",
    COLUNA_HOSPEDAGEM_ADICIONAR = "hospedagem_adicionar";

    public static final String
    CREATE_TABLE = "CREATE TABLE " + OrcamentoModel.TABELA_NOME +
            "(" +
            COLUNA_ID + " integer primary key autoincrement, " +
            COLUNA_DESCRICAO + " varchar not null, " +
            COLUNA_TOTAL_VIAJANTES + " int not null," +
            COLUNA_DURACAO_VIAGEM + " int not null," +
            COLUNA_TOTAL_VIAGEM + " double not null," +
            COLUNA_GASOLINA_TOTAL_KM + " double not null," +
            COLUNA_GASOLINA_MEDIA_POR_LITRO + " double not null," +
            COLUNA_GASOLINA_CUSTO_MEDIO + " double not null," +
            COLUNA_GASOLINA_TOTAL_VEICULOS + " int not null," +
            COLUNA_GASOLINA_ADICIONAR + " boolean not null," +
            COLUNA_TARIFA_CUSTO_POR_PESSOA + " double not null," +
            COLUNA_TARIFA_ALUGUEL_VEICULO + " double not null," +
            COLUNA_TARIFA_ADICIONAR + " boolean not null," +
            COLUNA_REFEICAO_CUSTO + " double not null," +
            COLUNA_REFEICAO_POR_DIA + " int not null," +
            COLUNA_REFEICAO_ADICIONAR + " double not null," +
            COLUNA_HOSPEDAGEM_CUSTO_MEDIO + " double not null," +
            COLUNA_HOSPEDAGEM_NOITES + " int not null," +
            COLUNA_HOSPEDAGEM_QUARTOS + " int not null," +
            COLUNA_HOSPEDAGEM_ADICIONAR + " boolean not null" +
            ")";

    public static final String
    DROP_TABLE = "drop table if exists " + TABELA_NOME;

    private long id;
    private String descricao;
    private int totalViajantes, duracaoViagem, gasolinaTotalVeiculos, refeicaoPDia, hospedagemNoites, hospedagemQuartos;
    private double totalViagem, gasolinaTotalKM, gasolinaMediaPLitro, gasolinaCustoMedio, tarifaCustoPPessoa, tarifaAluguelVeiculo, refeicaoCusto, hospedagemCustoMedio;
    private boolean gasolinaAdicionar, tarifaAdicionar, refeicaoAdicionar, hospedagemAdicionar;

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

    public int getTotalViajantes() {
        return totalViajantes;
    }

    public void setTotalViajantes(int totalViajantes) {
        this.totalViajantes = totalViajantes;
    }

    public int getDuracaoViagem() {
        return duracaoViagem;
    }

    public void setDuracaoViagem(int duracaoViagem) {
        this.duracaoViagem = duracaoViagem;
    }

    public int getGasolinaTotalVeiculos() {
        return gasolinaTotalVeiculos;
    }

    public void setGasolinaTotalVeiculos(int gasolinaTotalVeiculos) {
        this.gasolinaTotalVeiculos = gasolinaTotalVeiculos;
    }

    public int getRefeicaoPDia() {
        return refeicaoPDia;
    }

    public void setRefeicaoPDia(int refeicaoPDia) {
        this.refeicaoPDia = refeicaoPDia;
    }

    public int getHospedagemNoites() {
        return hospedagemNoites;
    }

    public void setHospedagemNoites(int hospedagemNoites) {
        this.hospedagemNoites = hospedagemNoites;
    }

    public int getHospedagemQuartos() {
        return hospedagemQuartos;
    }

    public void setHospedagemQuartos(int hospedagemQuartos) {
        this.hospedagemQuartos = hospedagemQuartos;
    }

    public double getTotalViagem() {
        return totalViagem;
    }

    public void setTotalViagem(double totalViagem) {
        this.totalViagem = totalViagem;
    }

    public double getGasolinaTotalKM() {
        return gasolinaTotalKM;
    }

    public void setGasolinaTotalKM(double gasolinaTotalKM) {
        this.gasolinaTotalKM = gasolinaTotalKM;
    }

    public double getGasolinaMediaPLitro() {
        return gasolinaMediaPLitro;
    }

    public void setGasolinaMediaPLitro(double gasolinaMediaPLitro) {
        this.gasolinaMediaPLitro = gasolinaMediaPLitro;
    }

    public double getGasolinaCustoMedio() {
        return gasolinaCustoMedio;
    }

    public void setGasolinaCustoMedio(double gasolinaCustoMedio) {
        this.gasolinaCustoMedio = gasolinaCustoMedio;
    }

    public double getTarifaCustoPPessoa() {
        return tarifaCustoPPessoa;
    }

    public void setTarifaCustoPPessoa(double tarifaCustoPPessoa) {
        this.tarifaCustoPPessoa = tarifaCustoPPessoa;
    }

    public double getTarifaAluguelVeiculo() {
        return tarifaAluguelVeiculo;
    }

    public void setTarifaAluguelVeiculo(double tarifaAlugueiVeiculo) {
        this.tarifaAluguelVeiculo = tarifaAlugueiVeiculo;
    }

    public double getRefeicaoCusto() {
        return refeicaoCusto;
    }

    public void setRefeicaoCusto(double refeicaoCusto) {
        this.refeicaoCusto = refeicaoCusto;
    }

    public double getHospedagemCustoMedio() {
        return hospedagemCustoMedio;
    }

    public void setHospedagemCustoMedio(double hospedagemCustoMedio) {
        this.hospedagemCustoMedio = hospedagemCustoMedio;
    }

    public boolean isGasolinaAdicionar() {
        return gasolinaAdicionar;
    }

    public void setGasolinaAdicionar(boolean gasolinaAdicionar) {
        this.gasolinaAdicionar = gasolinaAdicionar;
    }

    public boolean isTarifaAdicionar() {
        return tarifaAdicionar;
    }

    public void setTarifaAdicionar(boolean tarifaAdicionar) {
        this.tarifaAdicionar = tarifaAdicionar;
    }

    public boolean isRefeicaoAdicionar() {
        return refeicaoAdicionar;
    }

    public void setRefeicaoAdicionar(boolean refeicaoAdicionar) {
        this.refeicaoAdicionar = refeicaoAdicionar;
    }

    public boolean isHospedagemAdicionar() {
        return hospedagemAdicionar;
    }

    public void setHospedagemAdicionar(boolean hospedagemAdicionar) {
        this.hospedagemAdicionar = hospedagemAdicionar;
    }
}
