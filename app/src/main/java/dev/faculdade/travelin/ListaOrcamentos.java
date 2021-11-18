package dev.faculdade.travelin;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.stream.Collectors;

import dev.faculdade.travelin.DataBase.dao.OrcamentoDAO;
import dev.faculdade.travelin.DataBase.model.OrcamentoModel;

public class ListaOrcamentos extends AppCompatActivity {

    private ListView lista;
    private OrcamentoDAO dao;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_orcamentos);
        lista = findViewById(R.id.LVListaOrcamento);

        dao = new OrcamentoDAO(ListaOrcamentos.this);

        List<OrcamentoModel> modelList = dao.Select();
        List<String> descricoes = modelList.stream().map(OrcamentoModel::getDescricao).collect(Collectors.toList());
//todo                                                                                      Se quiser alterar o layout da lista é só mudar o simple_list_item_1
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(ListaOrcamentos.this, android.R.layout.simple_list_item_1, descricoes);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaOrcamentos.this, DadosActivity.class);
                intent.putExtra("Funcao","Edicao");
                intent.putExtra("Descricao",descricoes.get(i).toString());
                startActivity(intent);
                finish();
            }
        });
    }
}