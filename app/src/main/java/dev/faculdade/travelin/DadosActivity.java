package dev.faculdade.travelin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import dev.faculdade.travelin.DataBase.dao.OrcamentoDAO;
import dev.faculdade.travelin.DataBase.model.OrcamentoModel;

public class DadosActivity extends AppCompatActivity {



    private Button btSalvar,btCancelar;
    private EditText etTotalViajantes,etTDuracaoViagem;
    private TextView totalGasolina,totalAerea,totalRefeicoes,totalHospedagem,totalViagem;
    private Button btAdicionarGasolina,btAdicionarAerea,btAdicionarRefeicao,btAdicionarHospedagem;
    private EditText etTTotalDeKm,etTMediaKMPorLitro,etTCustoMedioLitro,etAereaCustoEstimadoPessoa,
            etAluguelVeiculo,etRefeicaoCustoEstimado,etRefeicoesPorDia,
            etHospedagemCustoMedio,etTotalNoites,etTotalQuartos, etTotalVeiculo;
    private OrcamentoDAO dao;

    private Button pegarButtonPorID(String buttonId){
        int resID = getResources().getIdentifier(buttonId, "id", getPackageName());
        return findViewById(resID);
    }

    private String CalculartotalGasolina(double totalkm,double mediakm,double custolitro,double totalveiculos){
        double total = ((totalkm/mediakm)*custolitro)/totalveiculos;
        return Double.toString(total);
    }

    private String CalcularTotalAerea(double custoPessoa,double totalViajantes, double aluguelVeiculo){
        double total = (custoPessoa*totalViajantes) * aluguelVeiculo;
        return Double.toString(total);
    }

    private String CalcularTotalRefeicao(double refeicoes,double totalViajantes,double custoEstimado,double duracaoViagem){
        double total = ((refeicoes * totalViajantes)*custoEstimado)*duracaoViagem;
        return Double.toString(total);
    }

    private String CalcularTotalHospedagem(double custoMedio,double totalNoites,double totalQuartos){
        double total = (custoMedio*totalNoites)*totalNoites;
        return Double.toString(total);
    }

    private String AlterarBotaoAdicionar(Button botaoAdicionar){
        return (botaoAdicionar.getText().toString().trim().equals("Sim")) ? "Não" : "Sim";
    }

    private boolean VerificarBotaoAdicionar(Button adicionarBotao){
        return adicionarBotao.getText().toString().equals("Sim");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        dao = new OrcamentoDAO(DadosActivity.this);

        Intent recuperar = getIntent();
        //String id = recuperar.getStringExtra("Adicionar");
        //Toast.makeText(DadosActivity.this, id, Toast.LENGTH_SHORT).show();
        String funcao = recuperar.getStringExtra("Funcao");
        String descricaoOrcamento = recuperar.getStringExtra("Descricao");

        totalViagem     = findViewById(R.id.TETotalViagem);
        totalGasolina   = findViewById(R.id.TETotalGasolina);
        totalAerea      = findViewById(R.id.TETotalAerea);
        totalRefeicoes  = findViewById(R.id.TETotalRefeicao);
        totalHospedagem = findViewById(R.id.TETotalHospedagem);

        btAdicionarGasolina   = findViewById(R.id.btAdicionarGasolina) ;
        btAdicionarAerea      = findViewById(R.id.btAdicionarAerea);
        btAdicionarRefeicao   = findViewById(R.id.btAdicionarRefeicao);
        btAdicionarHospedagem = findViewById(R.id.BTAdicionarHospedagem);

        etTotalViajantes           = findViewById(R.id.ETTotalViajantes);
        etTDuracaoViagem           = findViewById(R.id.ETTDuracaoViagem);
        etTTotalDeKm               = findViewById(R.id.ETTTotalDeKm);
        etTMediaKMPorLitro         = findViewById(R.id.ETTMediaKMPorLitro);
        etTCustoMedioLitro         = findViewById(R.id.ETTCustoMedioLitro);
        etTotalVeiculo             = findViewById(R.id.ETTTotalDeVeiculos);
        etAereaCustoEstimadoPessoa = findViewById(R.id.ETAereaCustoEstimadoPessoa);
        etAluguelVeiculo           = findViewById(R.id.ETAluguelVeiculo);
        etRefeicaoCustoEstimado    = findViewById(R.id.ETRefeicaoCustoEstimado);
        etRefeicoesPorDia          = findViewById(R.id.ETRefeicoesPorDia);
        etHospedagemCustoMedio     = findViewById(R.id.ETHospedagemCustoMedio);
        etTotalNoites              = findViewById(R.id.ETTotalNoites);
        etTotalQuartos             = findViewById(R.id.ETTotalQuartos);

        if (funcao.equals("Edicao")) {
            OrcamentoModel model = dao.Select(descricaoOrcamento);

            etTotalViajantes.setText(String.valueOf(model.getTotalViajantes()));
            etTDuracaoViagem.setText(String.valueOf(model.getDuracaoViagem()));

            etTTotalDeKm.setText(String.valueOf(model.getGasolinaTotalKM()));
            etTMediaKMPorLitro.setText(String.valueOf(model.getGasolinaMediaPLitro()));
            etTCustoMedioLitro.setText(String.valueOf(model.getGasolinaCustoMedio()));
            etTotalVeiculo.setText(String.valueOf(model.getGasolinaTotalVeiculos()));
            btAdicionarGasolina.setText(model.isGasolinaAdicionar() ? "Sim" : "Não");

            etAereaCustoEstimadoPessoa.setText(String.valueOf(model.getTarifaCustoPPessoa()));
            etAluguelVeiculo.setText(String.valueOf(model.getTarifaAluguelVeiculo()));
            btAdicionarAerea.setText(model.isTarifaAdicionar() ? "Sim" : "Não");

            etRefeicaoCustoEstimado.setText(String.valueOf(model.getRefeicaoCusto()));
            etRefeicoesPorDia.setText(String.valueOf(model.getRefeicaoPDia()));
            btAdicionarRefeicao.setText(model.isRefeicaoAdicionar() ? "Sim" : "Não");

            etHospedagemCustoMedio.setText(String.valueOf(model.getHospedagemCustoMedio()));
            etTotalNoites.setText(String.valueOf(model.getHospedagemNoites()));
            etTotalQuartos.setText(String.valueOf(model.getHospedagemQuartos()));
            btAdicionarHospedagem.setText(model.isHospedagemAdicionar() ? "Sim" : "Não");

            totalAerea.setText(CalcularTotalAerea(Double.parseDouble(etAereaCustoEstimadoPessoa.getText().toString()),
                    Double.parseDouble(etTotalViajantes.getText().toString()),
                    Double.parseDouble(etAluguelVeiculo.getText().toString())

            ));
            totalGasolina.setText(CalculartotalGasolina(Double.parseDouble(etTTotalDeKm.getText().toString()),
                    Double.parseDouble(etTMediaKMPorLitro.getText().toString()),
                    Double.parseDouble(etTCustoMedioLitro.getText().toString()),
                    Double.parseDouble(etTCustoMedioLitro.getText().toString())));

            totalHospedagem.setText(CalcularTotalHospedagem(
                    Double.parseDouble(etHospedagemCustoMedio.getText().toString()),
                    Double.parseDouble(etTotalNoites.getText().toString()),
                    Double.parseDouble(etTotalQuartos.getText().toString())


            ));
            totalRefeicoes.setText(CalcularTotalRefeicao(
                    Double.parseDouble(etRefeicoesPorDia.getText().toString()),
                    Double.parseDouble(etTotalViajantes.getText().toString()),
                    Double.parseDouble(etRefeicaoCustoEstimado.getText().toString()),
                    Double.parseDouble(etTDuracaoViagem.getText().toString())

            ));
            double calculoTotal = 0;

            if (VerificarBotaoAdicionar(btAdicionarGasolina)) {
                calculoTotal += Double.parseDouble(totalGasolina.getText().toString());
            }

            if (VerificarBotaoAdicionar(btAdicionarAerea)) {
                calculoTotal += Double.parseDouble(totalAerea.getText().toString());
            }

            if (VerificarBotaoAdicionar(btAdicionarHospedagem)) {
                calculoTotal += Double.parseDouble(totalHospedagem.getText().toString());
            }

            if (VerificarBotaoAdicionar(btAdicionarRefeicao)) {
                calculoTotal += Double.parseDouble(totalRefeicoes.getText().toString());
            }

            totalViagem.setText(String.valueOf(calculoTotal));

        }

        btSalvar = findViewById(R.id.BTSalvarOrca);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cria um novo objeto do tipo OrcamentoModel
                OrcamentoModel model;
                double totalViagem;
                totalViagem = Double.parseDouble(CalcularTotalAerea(Double.parseDouble(etAereaCustoEstimadoPessoa.getText().toString()),
                        Double.parseDouble(etTotalViajantes.getText().toString()),
                        Double.parseDouble(etAluguelVeiculo.getText().toString())

                ));
                totalViagem += Double.parseDouble(CalculartotalGasolina(Double.parseDouble(etTTotalDeKm.getText().toString()),
                        Double.parseDouble(etTMediaKMPorLitro.getText().toString()),
                        Double.parseDouble(etTCustoMedioLitro.getText().toString()),
                        Double.parseDouble(etTCustoMedioLitro.getText().toString())));
                totalViagem += Double.parseDouble(CalcularTotalHospedagem(
                        Double.parseDouble(etHospedagemCustoMedio.getText().toString()),
                        Double.parseDouble(etTotalNoites.getText().toString()),
                        Double.parseDouble(etTotalQuartos.getText().toString())
                ));
                totalViagem += Double.parseDouble(CalcularTotalRefeicao(
                        Double.parseDouble(etRefeicoesPorDia.getText().toString()),
                        Double.parseDouble(etTotalViajantes.getText().toString()),
                        Double.parseDouble(etRefeicaoCustoEstimado.getText().toString()),
                        Double.parseDouble(etTDuracaoViagem.getText().toString())
                ));

                // verifica se é uma inserção ou edição
                if (funcao.equals("Adicao")){
                    // inserção cria um novo orçamento
                    model = new OrcamentoModel();

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

                    dao.Insert(model);
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

                    dao.Update(
                            model.getId(),
                            descricaoOrcamento,
                            Integer.parseInt(etTotalViajantes.getText().toString()),
                            Integer.parseInt(etTDuracaoViagem.getText().toString()),
                            totalViagem,
                            Double.parseDouble(etTTotalDeKm.getText().toString()),
                            Double.parseDouble(etTMediaKMPorLitro.getText().toString()),
                            Double.parseDouble(etTCustoMedioLitro.getText().toString()),
                            Integer.parseInt(etTotalVeiculo.getText().toString()),
                            VerificarBotaoAdicionar(btAdicionarGasolina),
                            Double.parseDouble(etAereaCustoEstimadoPessoa.getText().toString()),
                            Double.parseDouble(etAluguelVeiculo.getText().toString()),
                            VerificarBotaoAdicionar(btAdicionarAerea),
                            Double.parseDouble(etRefeicaoCustoEstimado.getText().toString()),
                            Integer.parseInt(etRefeicoesPorDia.getText().toString()),
                            VerificarBotaoAdicionar(btAdicionarRefeicao),
                            Double.parseDouble(etHospedagemCustoMedio.getText().toString()),
                            Integer.parseInt(etTotalNoites.getText().toString()),
                            Integer.parseInt(etTotalQuartos.getText().toString()),
                            VerificarBotaoAdicionar(btAdicionarHospedagem)
                    );
                }

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
                btAdicionarGasolina.setText(AlterarBotaoAdicionar(btAdicionarGasolina));
            }
        });

        btAdicionarAerea.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btAdicionarAerea.setText(AlterarBotaoAdicionar(btAdicionarAerea));
            }
        });
        btAdicionarRefeicao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btAdicionarRefeicao.setText(AlterarBotaoAdicionar(btAdicionarRefeicao));
            }
        });
        btAdicionarHospedagem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btAdicionarHospedagem.setText(AlterarBotaoAdicionar(btAdicionarHospedagem));
            }
        });


    }
}
