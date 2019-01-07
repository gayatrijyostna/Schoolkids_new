package com.example.mvdprasad.schoolkids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Investigator_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_investigator_profile );
        Button backtomenu=findViewById(R.id.update);
        backtomenu.setOnClickListener(new View.OnClickListener()
        {  @Override
        public void onClick(View v) {
            Intent i=new Intent(Investigator_profile.this,Update_investigator_profile.class);
            startActivity(i);
        }
        });

    }
}
