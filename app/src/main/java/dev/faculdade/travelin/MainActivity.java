package dev.faculdade.travelin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dev.faculdade.travelin.DataBase.dao.LoginDAO;
import dev.faculdade.travelin.DataBase.model.LoginModel;

public class MainActivity extends AppCompatActivity {
    private Button btLogin,btCadastrar;
    private EditText Login,Password;
    private LoginDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao = new LoginDAO(MainActivity.this);

        Login = findViewById(R.id.ETLogin);
        Password = findViewById(R.id.ETPassword);
        btLogin = findViewById(R.id.btLogin);
        btCadastrar = findViewById(R.id.btCadastrarLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                List<LoginModel> model = dao.Select();
//                for (LoginModel login : model) {
//                    System.out.println("====================================================\n" + login.getUsuario());
//                }

                LoginModel model = dao.Select(Login.getText().toString(), Password.getText().toString());
                if (model != null) {
                    Toast.makeText(MainActivity.this,getString(R.string.MsgLoginSucesso), Toast.LENGTH_LONG).show();
                    //todo aqui vai a activity da tela principal
                    startActivity(new Intent( MainActivity.this, MenuActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.ErroUsuarioInvalido), Toast.LENGTH_LONG).show();
                }
            }
        });

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( MainActivity.this, CadastrarActivity.class));
            }
        });
    }
}