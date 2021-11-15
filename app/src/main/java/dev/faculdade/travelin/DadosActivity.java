package dev.faculdade.travelin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dev.faculdade.travelin.DataBase.model.OrcamentoModel;

public class DadosActivity extends AppCompatActivity {



    private Button btSalvar,btCancelar;
    private EditText etTotalViajantes,etTDuracaoViagem;
    private TextView totalGasolina,totalAerea,totalRefeicoes,totalHospedagem;
    private Button btAdicionarGasolina,btAdicionarAerea,btAdicionarRefeicao,btAdicionarHospedagem;
    private EditText etTTotalDeKm,etTMediaKMPorLitro,etTCustoMedioLitro,etAereaCustoEstimadoPessoa,
            etAluguelVeiculo,etRefeicaoCustoEstimado,etRefeicoesPorDia,
            etHospedagemCustoMedio,etTotalNoites,etTotalQuartos;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        totalGasolina   = findViewById(R.id.TETotalGasolina);
        totalAerea      = findViewById(R.id.TETotalAerea);
        totalRefeicoes  = findViewById(R.id.TETotalRefeicao);
        totalHospedagem = findViewById(R.id.TETotalHospedagem);

        btAdicionarGasolina     = findViewById(R.id.btAdicionarGasolina) ;
        btAdicionarAerea        = findViewById(R.id.btAdicionarAerea);
        btAdicionarRefeicao     = findViewById(R.id.btAdicionarRefeicao);
        btAdicionarHospedagem   = findViewById(R.id.BTAdicionarHospedagem);

        etTTotalDeKm                = findViewById(R.id.ETTTotalDeKm);
        etTMediaKMPorLitro          = findViewById(R.id.ETTMediaKMPorLitro);
        etTCustoMedioLitro          = findViewById(R.id.ETTCustoMedioLitro);
        etAereaCustoEstimadoPessoa  = findViewById(R.id.ETAereaCustoEstimadoPessoa);
        etAluguelVeiculo            = findViewById(R.id.ETAluguelVeiculo);
        etRefeicaoCustoEstimado     = findViewById(R.id.ETRefeicaoCustoEstimado);
        etRefeicoesPorDia           = findViewById(R.id.ETRefeicoesPorDia);
        etHospedagemCustoMedio      = findViewById(R.id.ETHospedagemCustoMedio);
        etTotalNoites               = findViewById(R.id.ETTotalNoites);
        etTotalQuartos              = findViewById(R.id.ETTotalQuartos);



        btSalvar = findViewById(R.id.BTSalvarOrca);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //adicionar aqui e fechar


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
