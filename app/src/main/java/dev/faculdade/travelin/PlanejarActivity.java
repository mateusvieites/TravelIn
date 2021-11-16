package dev.faculdade.travelin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import dev.faculdade.travelin.DataBase.dao.OrcamentoDAO;
import dev.faculdade.travelin.DataBase.model.OrcamentoModel;

public class PlanejarActivity extends AppCompatActivity {
    private Button btSalvar;
    private EditText descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejar);

        btSalvar = findViewById(R.id.btSalvarDesc);
        descricao = findViewById(R.id.ETDescricao);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanejarActivity.this, DadosActivity.class);
                intent.putExtra("Funcao","Adicao");
                intent.putExtra("Descricao",descricao.getText().toString());
                startActivity(intent);
                finish();

//                List<OrcamentoModel> teste = dao.Select();
//
//                for (OrcamentoModel x : teste) {
//                    Toast.makeText(PlanejarActivity.this, x.getDescricao(), Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}