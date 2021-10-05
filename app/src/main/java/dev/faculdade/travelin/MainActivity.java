package dev.faculdade.travelin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btLogin,btCadastrar;
    private EditText Login,Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login = findViewById(R.id.ETLogin);
        Password = findViewById(R.id.ETPassword);
        btLogin = findViewById(R.id.btLogin);
        btCadastrar = findViewById(R.id.btCadastrarLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* if ( Logins.containsKey( Login.getText().toString() ) ) {
                    if(Logins.get(Login.getText().toString()).equals(Password.getText().toString())){
                        //abre uma tela nova
                        //startActivity(new Intent( MainActivity.this, MenuActivity.class));
                    }else{
                        Funcoes.msgErro(getApplicationContext(),getString(R.string.ErroLogin).toString());
                    }
                }
                else{
                    Funcoes.msgErro(getApplicationContext(),getString(R.string.ErroLogin).toString());
                }*/
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