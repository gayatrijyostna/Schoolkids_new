package com.example.mvdprasad.schoolkids;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class Update_investigator_profile extends AppCompatActivity {
    EditText username, name, email, mobile;
    Button updateprofile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_investigator_profile);

        username = findViewById(R.id.edit_username1);
        name = findViewById(R.id.edit_name1);
        email = findViewById(R.id.edit_email1);
        mobile = findViewById(R.id.edit_mobile1);
        updateprofile = findViewById(R.id.updateprofile);

        updateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
                if (username.getText().toString().equals("")) {
                    username.setError("enter username");
                }
            }
        });
    }


    boolean isEmail(TextView text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(TextView text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    private void checkDataEntered() {
        if (isEmpty(username)) {
            Toast t = Toast.makeText(this, "you must enter username to register!", Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmpty(name)) {
            name.setError("name is required!");
        }
        if (isEmail(email)) {
            email.setError("enter valid email!");
        }
        if (isEmpty(mobile)) {
            mobile.setError("enter valid mobile number!");
        }
    }
}
