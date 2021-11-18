package dev.faculdade.travelin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dev.faculdade.travelin.DataBase.dao.LoginDAO;

public class MenuActivity extends AppCompatActivity {
    private Button btPlanejarViagem,btMinhasViagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        btPlanejarViagem = findViewById(R.id.btPlanejar);
        btMinhasViagens = findViewById(R.id.btMinhasViagens);

        btPlanejarViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrir menu para cadastrar nova pesquisa de viagem
                startActivity(new Intent( MenuActivity.this, PlanejarActivity.class));
            }
        });

        btMinhasViagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MenuActivity.this, ListaOrcamentos.class));
                //Abrir menu de pesquisa de viagens
                //startActivity(new Intent( MainActivity.this, MenuActivity.class));
            }
        });
    }
}