package com.example.mvdprasad.schoolkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class Admin_page  extends AppCompatActivity {
    ArrayList<Map<String, String>> data;
    Database_admin db;
    EditText email, password;
    String username, pswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.admin_login );

        email = findViewById( R.id.email );
        password = findViewById( R.id.pwd );

        Button login = findViewById( R.id.login );
        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = email.getText().toString().trim();
                pswd = password.getText().toString().trim();
                if (!username.equals( "" ) && !pswd.equals( "" )) {
                    data = new ArrayList <Map <String, String>>();
                    db = new Database_admin( getApplicationContext() );
                    data = db.getRetrive( username, pswd );
                    if (!data.isEmpty()) {
                        Intent i = new Intent( Admin_page.this, Admin_homepage.class );
                        startActivity( i );
                    } else {
                        Toast.makeText( Admin_page.this, "invalid username and password", Toast.LENGTH_SHORT ).show();
                    }
                } else {
                    Toast.makeText( Admin_page.this, "enter details", Toast.LENGTH_SHORT ).show();
                }

            }
        } );
        TextView signuphere=findViewById(R.id.signup_here);
        signuphere.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Admin_page.this,Signup.class);
                startActivity(i);
            }
        });

    }
    }