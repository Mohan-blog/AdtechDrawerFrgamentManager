package com.adteccorp.adtechdrawerfragmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferenceConfing sharedPreferenceConfing;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        Login( );
        username = findViewById( R.id.etuser );
        password = findViewById( R.id.etpassword );
        sharedPreferenceConfing = new SharedPreferenceConfing( getApplicationContext() );


        if (sharedPreferenceConfing.read_login_status( false )) {
            startActivity( new Intent( this, MainActivity.class ) );
            finish();
        }
    }

    public void Login() {
        String uname = username.getText().toString();
        String pass = password.getText().toString();
        if (uname.equals( getResources().getString( R.string.username ) ) && (pass.equals( getResources().getString( R.string.password ) ))) {
            startActivity( new Intent( this, MainActivity.class ) );
            sharedPreferenceConfing.login_status( true );
            finish();
        } else {
            Toast.makeText( this, "not valid", Toast.LENGTH_LONG ).show();
            username.setText( " " );
            password.setText( " " );

        }
    }


}
