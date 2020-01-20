package com.adteccorp.adtechdrawerfragmentmanager;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceConfing {
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPreferenceConfing(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences( context.getResources().getString( R.string.login_sharedpreference ),Context.MODE_PRIVATE );

    }
    public void login_status(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean( context.getResources().getString( R.string.login_staussharepreference ),status );
        editor.commit();
    }
    public boolean read_login_status(boolean b){
        boolean status =true;
        status = sharedPreferences.getBoolean( context.getResources().getString( R.string.login_staussharepreference ),false );
        return status;
    }
}
