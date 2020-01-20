package com.adteccorp.adtechdrawerfragmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mtoggle;
    private NavigationView navigationView;
    private SharedPreferenceConfing sharedPreferenceConfing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        initview();
        sharedprefmethod();


    }

    private void sharedprefmethod() {
        sharedPreferenceConfing = new SharedPreferenceConfing( getApplicationContext() );
    }

    public void initview() {

        drawerLayout = findViewById( R.id.drawerlayout );
        navigationView = findViewById( R.id.navigationview );
        navigationView.setNavigationItemSelectedListener( this );
        mtoggle = new ActionBarDrawerToggle( this, drawerLayout, R.string.open, R.string.close );
        drawerLayout.addDrawerListener( mtoggle );
        mtoggle.syncState();


        getSupportFragmentManager().beginTransaction().replace( R.id.mainfragmentid, new WelcomeFragment() ).commit();
        navigationView.setCheckedItem( R.id.welcome );

    }

    /*  @Override
      public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
          if (mtoggle.onOptionsItemSelected( menuItem )) {
              return true;
          }
          return super.onOptionsItemSelected( menuItem );
      }
  */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dashboard:
                getSupportFragmentManager().beginTransaction().replace( R.id.mainfragmentid, new MohanFragment() ).commit();
                break;
            case R.id.events:
                getSupportFragmentManager().beginTransaction().replace( R.id.mainfragmentid, new KishoreFragment() ).commit();
                break;
            case R.id.search:
                getSupportFragmentManager().beginTransaction().replace( R.id.mainfragmentid, new MuraliFragment() ).commit();
                break;
            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace( R.id.mainfragmentid, new RathnakarFragment() ).commit();
                break;
            case R.id.activities:
                getSupportFragmentManager().beginTransaction().replace( R.id.mainfragmentid, new RohitFragment() ).commit();
                break;
            case R.id.logout:
                getSupportFragmentManager().beginTransaction().replace( R.id.mainfragmentid, new SaiFragment() ).commit();
                break;
        }
        drawerLayout.closeDrawer( GravityCompat.START );
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.settingsmenu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile:
                startActivity( new Intent( this, ProfileAct.class ) );
                return true;
            case R.id.changelang:
                // do your code
                return true;
            case R.id.logout:

                sharedPreferenceConfing.read_login_status( false );
                startActivity( new Intent( this, LoginActivity.class ) );
                finish();
                return true;

            default:
                if (mtoggle.onOptionsItemSelected( item )) {
                    return true;
                }
                return super.onOptionsItemSelected( item );
        }
    }

}

