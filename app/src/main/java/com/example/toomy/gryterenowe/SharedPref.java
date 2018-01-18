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

    public void setErrorSeconds(Integer seconds){
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putInt("ErrorSeconds", seconds);
        editor.commit();
    }
    public void addErrorSeconds(Integer seconds){
        Integer default_value = 1;
        Integer state = mySharedPref.getInt("ErrorSeconds", default_value);
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putInt("ErrorSeconds", state+seconds);
        editor.commit();
    }

    public String loadHighScore()
    {
        String state = mySharedPref.getString("HighScore","-----");
        return state;
    }
    public Integer loadSeconds()
    {
        Integer default_value = 1;
        Integer state = mySharedPref.getInt("ErrorSeconds",default_value);
        return state;
    }

}
