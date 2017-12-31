package com.example.toomy.gryterenowe;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by toomy on 31.12.2017.
 */

public class SharedPref {
    SharedPreferences mySharedPref;
    public SharedPref(Context context)
    {
        mySharedPref = context.getSharedPreferences("filename",Context.MODE_PRIVATE);
    }



    public  void setHighScore(String czas){
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putString("HighScore",czas);
        editor.commit();
    }
    public String loadHighScore()
    {
        String state = mySharedPref.getString("HighScore","Brak czasu");
        return state;
    }
}
