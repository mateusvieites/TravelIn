package dev.faculdade.travelin.DataBase.dao;

import android.content.Context;

import java.util.List;

import dev.faculdade.travelin.DataBase.DBOpenHelper;
import dev.faculdade.travelin.DataBase.model.LoginModel;

public class LoginDAO extends AbstrataDAO{
    public LoginDAO(final Context contexto){
        helper = new DBOpenHelper(contexto);
    }

    public int Insert(){
        return 0;
    }

    public int Delete(){
        return 0;
    }

    public int Update(){
        return 0;
    }

    public List<LoginModel> Select(){
        return null;
    }

}
