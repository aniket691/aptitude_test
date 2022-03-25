package com.example.aptitudetestapp.datasaver;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private static SharedPref sharedPref;
    private SharedPreferences sharedPreferences;

    public static SharedPref getInstance(Context context) {
        if (sharedPref == null) {
            sharedPref = new SharedPref(context);
        }
        return sharedPref;
    }

    private SharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences("CustomNamedPreference", Context.MODE_PRIVATE);
    }

    public void saveData(String key, String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }

    public String getData(String key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getString(key, "");
        }
        return "";
    }
}