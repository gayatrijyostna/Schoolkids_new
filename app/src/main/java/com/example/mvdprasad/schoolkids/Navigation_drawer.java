package com.example.mvdprasad.schoolkids;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Navigation_drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        String action  = getIntent().getAction();
        if ("OPEN_LANDMARKS".equals( action ))
        {
            Route_landmarks f4 = new Route_landmarks();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, f4);
            ft.commit();
        }
        else if ("Route details".equals( action ))
        {
            View_routedetails f3 = new View_routedetails();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, f3);
            ft.commit();
        }
else if("Student details".equals( action ))
        {
            Student_details sd = new Student_details();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, sd);
            ft.commit();

        }
        else{


        View_routedetails f3 = new View_routedetails();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, f3);
        ft.commit();
    }}

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
  if (id == R.id.nav_Profile) {
            TextView textView1=findViewById( R.id.tv );
            textView1.setText( "INVESTIGATOR PROFILE" );
            Investigator_profile ip= new Investigator_profile();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, ip);
            ft.commit();

//            startActivity(new Intent(Navigation_drawer.this, Investigator_profile.class));

        } else if (id == R.id.Student_list) {
            TextView textView=findViewById( R.id.tv );
            textView.setText( "VIEW STUDENT DETAILS" );
            Student_details sd = new Student_details();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, sd);
            ft.commit();

        } else if (id == R.id.Route_details) {
            TextView textView=findViewById( R.id.tv );
            textView.setText( "VIEW ROUTE DETAILS" );
            View_routedetails f3 = new View_routedetails();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, f3);
            ft.commit();


        } else if (id == R.id.Route_landmarks) {
            TextView textView=findViewById( R.id.tv );
            textView.setText( "VIEW LANDMARKS DETAILS" );
            Route_landmarks f4 = new Route_landmarks();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, f4);
            ft.commit();

        } else if (id == R.id.bus_position) {

            startActivity(new Intent(Navigation_drawer.this, Busposition_activity.class));

        } else if (id == R.id.change_password) {
            TextView textView=findViewById( R.id.tv );
            textView.setText( "CHANGE PASSWORD" );
           ChangePassword cp= new ChangePassword();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, cp);
            ft.commit();
        } else if (id == R.id.signout) {
            SharedPreferences preferences=getSharedPreferences( "MyPrefs", Context.MODE_PRIVATE );
            SharedPreferences.Editor editor=preferences.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(Navigation_drawer.this,Admin_page.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
