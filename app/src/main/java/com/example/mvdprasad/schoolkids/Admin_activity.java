package com.example.mvdprasad.schoolkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_activity extends AppCompatActivity {
    private Database_admin dataBaseClass;
    boolean value=false;
    String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.admin_login );
        dataBaseClass = new Database_admin(Admin_activity.this);
        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.pwd);

        Button login = findViewById( R.id.login );
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email_str = email.getText().toString().trim();
                String password_str = password.getText().toString().trim();

                if (!email_str.equals( "" ) && !password_str.equals( "" )) {

                    value = true;

                    dataBaseClass.insertValues( email_str, password_str );
                    Intent i = new Intent( Admin_activity.this, TabMainActivity.class );
                    startActivity( i );
                    Toast.makeText( Admin_activity.this, "successfully saved", Toast.LENGTH_SHORT ).show();
                } else {
                    Toast.makeText( Admin_activity.this, "Plz fill the details", Toast.LENGTH_SHORT ).show();

                }
            }
        });

    }}
