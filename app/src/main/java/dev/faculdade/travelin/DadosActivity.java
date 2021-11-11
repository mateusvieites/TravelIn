package dev.faculdade.travelin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dev.faculdade.travelin.DataBase.model.OrcamentoModel;

public class DadosActivity extends AppCompatActivity {

    private Button btSalvar;

    private Button pegarButtonPorID(String buttonId){
        int resID = getResources().getIdentifier(buttonId, "id", getPackageName());
        return findViewById(resID);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        /*
         String[] arrayNomesBotoes = {"Gasolina", "Aerea", "Refeicao","Hospedagem"};
                for(int i=0;i<arrayNomesBotoes.length -1;i++){
                    Button aux = pegarButtonPorID(arrayNomesBotoes[i]);
                    if (aux.getText().toString().trim() == "Sim"){

                    }

                }
        */
//        btSalvar = findViewById(R.id.btSalvarDados);
//        btSalvar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//            }
//
//
//        });
    }
}
