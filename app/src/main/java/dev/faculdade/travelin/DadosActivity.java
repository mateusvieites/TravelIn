package dev.faculdade.travelin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dev.faculdade.travelin.DataBase.dao.OrcamentoDAO;
import dev.faculdade.travelin.DataBase.model.OrcamentoModel;

public class DadosActivity extends AppCompatActivity {



    private Button btSalvar,btCancelar;
    private EditText etTotalViajantes,etTDuracaoViagem;
    private TextView totalGasolina,totalAerea,totalRefeicoes,totalHospedagem;
    private Button btAdicionarGasolina,btAdicionarAerea,btAdicionarRefeicao,btAdicionarHospedagem;
    private EditText etTTotalDeKm,etTMediaKMPorLitro,etTCustoMedioLitro,etAereaCustoEstimadoPessoa,
            etAluguelVeiculo,etRefeicaoCustoEstimado,etRefeicoesPorDia,
            etHospedagemCustoMedio,etTotalNoites,etTotalQuartos, etTotalVeiculo;
    private OrcamentoDAO dao;

    private Button pegarButtonPorID(String buttonId){
        int resID = getResources().getIdentifier(buttonId, "id", getPackageName());
        return findViewById(resID);
    }

    private String CalculartotalGasolina(float totalkm,float mediakm,float custolitro,float totalveiculos){
        float total = ((totalkm/mediakm)*custolitro)/totalveiculos;
        return Float.toString(total);
    }

    private String CalcularTotalAerea(float custoPessoa,float totalViajantes, float aluguelVeiculo){
        float total = (custoPessoa*totalViajantes) * aluguelVeiculo;
        return Float.toString(total);
    }
    private String CalcularTotalRefeicao(float refeicoes,float totalViajantes,float custoEstimado,float duracaoViagem){
        float total = ((refeicoes * totalViajantes)*custoEstimado)*duracaoViagem;
        return Float.toString(total);
    }
    private String CalcularTotalHospedagem(float custoMedio,float totalNoites,float totalQuartos){
        float total = (custoMedio*totalNoites)*totalNoites;
        return Float.toString(total);
    }

    private String AlterarBotaoAdicionar(Button botaoAdicionar){
        return (botaoAdicionar.getText().toString().trim() == "Sim") ? "Não":"Sim";
    }

    private boolean VerificarBotaoAdicionar(Button adicionarBotao){
        return adicionarBotao.getText().toString() == "Sim";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        dao = new OrcamentoDAO(DadosActivity.this);

        Intent recuperar = getIntent();
        //String id = recuperar.getStringExtra("Adicionar");
        //Toast.makeText(DadosActivity.this, id, Toast.LENGTH_SHORT).show();
        String funcao = recuperar.getStringExtra("funcao");
        String descricaoOrcamento = recuperar.getStringExtra("Descricao");

        totalGasolina   = findViewById(R.id.TETotalGasolina);
        totalAerea      = findViewById(R.id.TETotalAerea);
        totalRefeicoes  = findViewById(R.id.TETotalRefeicao);
        totalHospedagem = findViewById(R.id.TETotalHospedagem);

        btAdicionarGasolina   = findViewById(R.id.btAdicionarGasolina) ;
        btAdicionarAerea      = findViewById(R.id.btAdicionarAerea);
        btAdicionarRefeicao   = findViewById(R.id.btAdicionarRefeicao);
        btAdicionarHospedagem = findViewById(R.id.BTAdicionarHospedagem);

        etTTotalDeKm               = findViewById(R.id.ETTTotalDeKm);
        etTMediaKMPorLitro         = findViewById(R.id.ETTMediaKMPorLitro);
        etTCustoMedioLitro         = findViewById(R.id.ETTCustoMedioLitro);
        etAereaCustoEstimadoPessoa = findViewById(R.id.ETAereaCustoEstimadoPessoa);
        etAluguelVeiculo           = findViewById(R.id.ETAluguelVeiculo);
        etRefeicaoCustoEstimado    = findViewById(R.id.ETRefeicaoCustoEstimado);
        etRefeicoesPorDia          = findViewById(R.id.ETRefeicoesPorDia);
        etHospedagemCustoMedio     = findViewById(R.id.ETHospedagemCustoMedio);
        etTotalNoites              = findViewById(R.id.ETTotalNoites);
        etTotalQuartos             = findViewById(R.id.ETTotalQuartos);
        etTotalVeiculo             = findViewById(R.id.ETTTotalDeVeiculos);

        Double totalViagem =
                Double.parseDouble(totalGasolina.getText().toString()) +
                Double.parseDouble(totalAerea.getText().toString()) +
                Double.parseDouble(totalRefeicoes.getText().toString()) +
                Double.parseDouble(totalHospedagem.getText().toString());

        btSalvar = findViewById(R.id.BTSalvarOrca);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cria um novo objeto do tipo OrcamentoModel
                OrcamentoModel model;

                // verifica se é uma inserção ou edição
                if (funcao == "Adicao"){
                    // inserção cria um novo orçamento
                    model = new OrcamentoModel();
                }
                else{
                    // edição busca um orçamento com a descrição passada por parâmetro
                    model = dao.Select(descricaoOrcamento);
                    /*
                     * ToDo
                     *  Obs.: Seria legal se quando o usuário entrasse na activity para editar os dados,
                     *  todos os campos de model fossem jogados para activity, assim ele poderia ver o que já tem
                     *  e o que ele quer mudar.
                     *
                     *  O objeto model já é o objeto do banco, então só precisa usar model.getTotalViagem() pra pegar o valor
                     */
                }

                // pega todos os campos da activity e adiciona no model
                model.setDescricao(descricaoOrcamento);
                model.setTotalViajantes(Integer.parseInt(etTotalViajantes.getText().toString()));
                model.setDuracaoViagem(Integer.parseInt(etTDuracaoViagem.getText().toString()));
                model.setTotalViagem(totalViagem);
                model.setGasolinaTotalKM(Double.parseDouble(etTTotalDeKm.getText().toString()));
                model.setGasolinaMediaPLitro(Double.parseDouble(etTMediaKMPorLitro.getText().toString()));
                model.setGasolinaCustoMedio(Double.parseDouble(etTCustoMedioLitro.getText().toString()));
                model.setGasolinaTotalVeiculos(Integer.parseInt(etTotalVeiculo.getText().toString()));
                model.setGasolinaAdicionar(VerificarBotaoAdicionar(btAdicionarGasolina));
                model.setTarifaCustoPPessoa(Double.parseDouble(etAereaCustoEstimadoPessoa.getText().toString()));
                model.setTarifaAluguelVeiculo(Double.parseDouble(etAluguelVeiculo.getText().toString()));
                model.setTarifaAdicionar(VerificarBotaoAdicionar(btAdicionarAerea));
                model.setRefeicaoCusto(Double.parseDouble(etRefeicaoCustoEstimado.getText().toString()));
                model.setRefeicaoPDia(Integer.parseInt(etRefeicoesPorDia.getText().toString()));
                model.setRefeicaoAdicionar(VerificarBotaoAdicionar(btAdicionarRefeicao));
                model.setHospedagemCustoMedio(Double.parseDouble(etHospedagemCustoMedio.getText().toString()));
                model.setHospedagemNoites(Integer.parseInt(etTotalNoites.getText().toString()));
                model.setHospedagemQuartos(Integer.parseInt(etTotalQuartos.getText().toString()));
                model.setHospedagemAdicionar(VerificarBotaoAdicionar(btAdicionarHospedagem));

                finish();
            }
        });

        btCancelar = findViewById(R.id.BTCancelarOrca);
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        // Muda o status do botão para Sim / Não
        btAdicionarGasolina.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlterarBotaoAdicionar(btAdicionarGasolina);
            }
        });

        btAdicionarAerea.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlterarBotaoAdicionar(btAdicionarAerea);
            }
        });
        btAdicionarRefeicao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlterarBotaoAdicionar(btAdicionarRefeicao);
            }
        });
        btAdicionarHospedagem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlterarBotaoAdicionar(btAdicionarHospedagem);
            }
        });


    }
}
