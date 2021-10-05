package dev.faculdade.travelin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarActivity extends AppCompatActivity {
    private Button cadastrar,cancelar;
    private EditText login,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        cadastrar = findViewById(R.id.btCadLogin);
        cancelar = findViewById(R.id.btCadCancelar);

        login = findViewById(R.id.ETCadLogin);
        password = findViewById(R.id.ETCadSenha);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getText().toString().trim() == "" || password.getText().toString().trim() == ""){
                    Funcoes.msgErro(getApplicationContext(),getString(R.string.ErroCadLoginVazio).toString());
                }
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}