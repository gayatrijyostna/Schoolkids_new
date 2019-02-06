package com.example.mvdprasad.schoolkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Map;

public class Forgotpwd extends AppCompatActivity {
    EditText mailid;
    Button send,cancel;
    Database_admin db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.forgotpwd );
        mailid = findViewById(R.id.mailid);
        send = findViewById(R.id.send);
        cancel = findViewById(R.id.cancel);
        send.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=new Database_admin( Forgotpwd.this );
                ArrayList<Map<String,String>> data=new ArrayList <>(  );
                data=db.getPassword( mailid.getText().toString());

                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{mailid.getText().toString()});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "hi");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,data.get(0).get( Database_admin.PASSWORD ));
                Forgotpwd.this.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            }
        } );
        cancel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Forgotpwd.this, Admin_page.class);
                startActivity(i);
            }
        });



    }
}