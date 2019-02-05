package com.example.mvdprasad.schoolkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Busposition_activity extends AppCompatActivity {
Database_admin db;
    ArrayList<String> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.bus_position );
       Spinner  Bus_no=findViewById( R.id.bus );

        db=new Database_admin(this);
        data = db.getBusName();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        Bus_no.setAdapter(dataAdapter);
        TextView viewposition=findViewById(R.id.view_position);
        viewposition.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Busposition_activity.this,Viewlandmark.class);
                i.putExtra("BUSNO",data.get(0));
                startActivity(i);
            }
        });
        getSupportActionBar().setTitle( "BUS POSITION" );

    }
}