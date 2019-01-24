package com.example.mvdprasad.schoolkids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Add_landmark extends AppCompatActivity {
    EditText Landmark1,Latitude,Longitude,Message;
    Button add_lm;
    Boolean value=false;
    Database_admin db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_landmark);
        Landmark1 = findViewById( R.id.edit_landmark2 );
        Latitude = findViewById( R.id.edit_latitude );
        Longitude = findViewById( R.id.edit_longitude );
        Message=findViewById(R.id.add_Message);
        Button AddRoute=findViewById(R.id.AddRoute);
        db=new Database_admin(this);
        AddRoute.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
                if (Landmark1.getText().toString().equals( "" )) {
                    Landmark1.setError( "This field is required" );
                }

            }
        } );
    }

    boolean isEmpty(TextView text){
        CharSequence str=text.getText().toString();
        return TextUtils.isEmpty( str );
    }
    private void checkDataEntered() {
        if (isEmpty( Landmark1 )) {
            Toast t = Toast.makeText( this, "This field is required!", Toast.LENGTH_SHORT );
            t.show();
        }
        if (isEmpty( Latitude )) {
            Latitude.setError( "This field is required!" );
        }
        if (isEmpty( Longitude )) {
            Longitude.setError( "This field is required!" );
        }
        Button AddRoute=findViewById(R.id.AddRoute);
        AddRoute.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String Landmark1_str = Landmark1.getText().toString().trim();
                String Latitude_str = Latitude.getText().toString().trim();
                String Longitude_str = Longitude.getText().toString().trim();
                String  Message_str = Message.getText().toString().trim();
                if (!Landmark1_str.equals("") && !Latitude_str.equals("") && !Longitude_str.equals("") && !Message_str.equals("")) {
                String route_No= getIntent().getStringExtra("BUSNO");
                    value = true;
                    db.insertLandmark(Landmark1_str, Latitude_str, Longitude_str, Message_str,route_No);
                    Intent i = new Intent(Add_landmark.this,Navigation_drawer.class);
                    startActivity(i);
                    Toast.makeText(Add_landmark.this, "successfully saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Add_landmark.this, "Plz fill the details", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }}


