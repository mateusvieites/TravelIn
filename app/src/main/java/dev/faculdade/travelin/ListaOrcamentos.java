package dev.faculdade.travelin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class ListaOrcamentos extends AppCompatActivity {

    private ListView Lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_orcamentos);
        Lista = findViewById(R.id.LVListaOrcamento);

        //SE PRECISAR DO ADAPTER TEM QUE COLOCAR ELE AQUI COMO LISTA.SETONCLICKLISTENER PEGUEI DO GOOGLE
        /* .setOnClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView , View view , int position ,long arg3)
            {
               // Log.i("Item clicked","tushar:itemclicked") ;
            }
        });*/
        /* Lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaOrcamentos.this, DadosActivity.class);
                intent.putExtra("Funcao","Edicao");
                //Tem que passar a descrição do status se ele puder modificar
                //intent.putExtra("Descricao",descricao.getText().toString());
                startActivity(intent);
                finish();

            }
        }); */
    }
}