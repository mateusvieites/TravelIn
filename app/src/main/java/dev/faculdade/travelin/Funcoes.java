package dev.faculdade.travelin;

import android.content.Context;
import android.widget.Toast;

public class Funcoes {
    private static Funcoes uniqueInstance;

    private Funcoes() {
    }

    public static Funcoes getInstance() {
        return uniqueInstance;
    }


    public static void msgErro(Context contexto, String msgErro){
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(contexto, msgErro, duration);
        toast.show();
    }
}
