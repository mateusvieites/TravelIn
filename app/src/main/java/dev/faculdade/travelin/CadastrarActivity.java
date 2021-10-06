package dev.faculdade.travelin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dev.faculdade.travelin.DataBase.dao.LoginDAO;
import dev.faculdade.travelin.DataBase.model.LoginModel;

public class CadastrarActivity extends AppCompatActivity {
    private Button cadastrar,cancelar;
    private EditText login,password;
    private LoginDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        dao = new LoginDAO(CadastrarActivity.this);

        cadastrar = findViewById(R.id.btCadLogin);
        cancelar = findViewById(R.id.btCadCancelar);

        login = findViewById(R.id.ETCadLogin);
        password = findViewById(R.id.ETCadSenha);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getText().toString().trim() == "" || password.getText().toString().trim() == ""){
                    Funcoes.msgErro(getApplicationContext(),getString(R.string.ErroCadLoginVazio).toString());
                    return;
                }

                LoginModel model = new LoginModel();
                model.setUsuario(login.getText().toString());
                model.setSenha(password.getText().toString());

                if (dao.Insert(model) != -1) {
                    Toast.makeText(CadastrarActivity.this, "Usuário cadastrado!", Toast.LENGTH_LONG).show();
                    finish();
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