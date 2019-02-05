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

import java.util.ArrayList;

public class Signup extends AppCompatActivity {
    private Database_admin dataBaseClass;

    public static final String MOBILE_PATTERN = "^[6789]\\d{9}$";
    public static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public static final String NAME_PATTERN = "[a-zA-Z., ]+([ '-][a-zA-Z., ]+)*";
    String name, username, email, password, address, phonenumber;
ArrayList<String> data1=new ArrayList <>(  );
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
                    boolean value = true;
                if (!email_str.equals("") && !password_str.equals("")&& !name_str.equals("")&& !username_str.equals("") && !address_str.equals("") && !phone_str.equals("")  && !radioGroup.isClickable())
                {
                    if (!(name_str.matches(NAME_PATTERN )) || (name_str.length()<3) || (name_str.length()>30) ) {
                        value = false;
                        name.setError("username invalid");
                    }
                 if(!username_str.matches(NAME_PATTERN ) || (username_str.length()<3) || (username_str.length()>30) ) {
                        value = false;
                        username.setError("username invalid");
                    }
                if (!email_str.matches(EMAIL_PATTERN) ) {
                        value = false;
                        email.setError("Email invalid");
                    }
                 if (!password_str.matches(NAME_PATTERN) || (password_str.length()<3) || (password_str.length()>8) ) {
                        value = false;
                        password.setError("password invalid");
                    }
                    if (!address_str.matches(NAME_PATTERN ) || (address_str.length()<3) ) {
                        value = false;
                        address.setError("address invalid");
                    }
                if (!phone_str.matches(MOBILE_PATTERN) || !(phone_str.length()==10) ) {
                        value = false;
                        phonenumber.setError("phone number invalid");
                    }
                   if( value == true) {
                       int selectedId = radioGroup.getCheckedRadioButtonId();
                       RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
                       String radioButtonText = selectedRadioButton.getText().toString();
                       data1=dataBaseClass.getEmail(email_str);
   if(data1.isEmpty()) {
    dataBaseClass.insertValues( name_str, username_str, email_str, password_str, address_str, phone_str, radioButtonText );
    Intent i = new Intent( Signup.this, Admin_page.class );
    startActivity( i );
    Toast.makeText( Signup.this, "successfully saved", Toast.LENGTH_SHORT ).show();

}
                    else {
    Toast.makeText( Signup.this, "email id already exists", Toast.LENGTH_SHORT ).show();

}
                   }
                } else {
                    Toast.makeText(Signup.this, "Plz fill the details", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
