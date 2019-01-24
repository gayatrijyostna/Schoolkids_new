package com.example.mvdprasad.schoolkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    private Database_admin dataBaseClass;
    boolean value = false;
    String name, username, email, password, address, phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        dataBaseClass = new Database_admin(Signup.this);
        final EditText name = findViewById(R.id.name);
        final EditText username = findViewById(R.id.username);
        final EditText email = findViewById(R.id.mail);
        final EditText password = findViewById(R.id.pwd);
        final EditText address = findViewById(R.id.address);
        final EditText phonenumber = findViewById(R.id.phn);
        final RadioGroup radioGroup=findViewById(R.id.radiogroup);
        Button login = findViewById(R.id.signup);
        login.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                String name_str = name.getText().toString().trim();
                String username_str = username.getText().toString().trim();
                String email_str = email.getText().toString().trim();
                String password_str = password.getText().toString().trim();
                String address_str = address.getText().toString().trim();
                String phone_str = phonenumber.getText().toString().trim();

                if (!email_str.equals("") && !password_str.equals("")&& !radioGroup.isClickable()) {

                    value = true;
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    RadioButton selectedRadioButton = (RadioButton)findViewById(selectedId);
                    String radioButtonText = selectedRadioButton.getText().toString();

                    dataBaseClass.insertValues(name_str, username_str, email_str, password_str, address_str, phone_str,radioButtonText);
                    Intent i = new Intent(Signup.this, Admin_page.class);
                    startActivity(i);
                    Toast.makeText(Signup.this, "successfully saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Signup.this, "Plz fill the details", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
