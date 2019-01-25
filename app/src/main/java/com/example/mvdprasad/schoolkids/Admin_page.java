package com.example.mvdprasad.schoolkids;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class Admin_page extends AppCompatActivity {
    ArrayList<Map<String, String>> data;
    Database_admin db;
    EditText email;
   EditText password;
    String username, pswd;
boolean value=true;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Username="Username";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.pswd);

        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = email.getText().toString().trim();
                pswd = password.getText().toString().trim();
                if (!username.equals("") && !pswd.equals("")) {

                    if (!username.matches(Signup.EMAIL_PATTERN) ) {
                        value = false;
                        email.setError("username invalid");
                    }
                    if (!pswd.matches(Signup.NAME_PATTERN) || !(pswd.length()>3) || !(pswd.length()<8) ) {
                        value = false;
                        email.setError("password invalid");
                    }
                    if(value==true)
                    {
                    data = new ArrayList<Map<String, String>>();
                    db = new Database_admin(getApplicationContext());
                    data = db.getRetrive(username, pswd);
                    if (!data.isEmpty()) {
                        Intent i = new Intent(Admin_page.this, Navigation_drawer.class);
                        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(Username, username);
                        editor.commit();
                        startActivity(i);
                    } else {
                        Toast.makeText(Admin_page.this, "invalid username and password", Toast.LENGTH_SHORT).show();
                    } }
                } else {
                    Toast.makeText(Admin_page.this, "enter details", Toast.LENGTH_SHORT).show();
                }

            }
        });


        TextView signuphere = findViewById(R.id.signup_here);
        signuphere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Admin_page.this, Signup.class);
                startActivity(i);
            }
        });
//password.setOnTouchListener(new View.OnTouchListener() {
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        switch (v.getId())
//        {
//            case R.id.pwd:
//
//                switch ( event.getAction() ) {
//                    case MotionEvent.ACTION_DOWN:
//                        Toast.makeText(Admin_page.this,"show",Toast.LENGTH_SHORT).show();
//                        password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
//                        Toast.makeText(Admin_page.this,"hide",Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                break;
//        }
//        return true;
//    }
//});
    }


    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

}