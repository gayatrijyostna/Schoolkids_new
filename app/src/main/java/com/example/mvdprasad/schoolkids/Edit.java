package com.example.mvdprasad.schoolkids;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit extends AppCompatActivity {
EditText Route_NO,Route_NAME,Route_From,Route_To;
Button back,Update,delete;
Database_admin db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_edit );
        Route_NO=findViewById(R.id.Bus_Route_No);
        Route_NAME=findViewById(R.id.Route_Name);
        Route_From=findViewById(R.id.Route_From);
        Route_To=findViewById(R.id.Route_To);
        Update=findViewById(R.id.Update);
        delete=findViewById(R.id.Delete);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(Edit.this,Navigation_drawer.class));
            }
        });
      Route_NO.setText(getIntent().getStringExtra("BUSROUTENO"));
        Route_NAME.setText(getIntent().getStringExtra("ROUTENAME"));
        Route_From.setText(getIntent().getStringExtra("ROUTEFROM"));
        Route_To.setText(getIntent().getStringExtra("ROUTETO"));
        db=new Database_admin(this);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Route_no_str=Route_NO.getText().toString().trim();
                String Route_NAME_str=Route_NAME.getText().toString().trim();
                String  Route_From_str=Route_From.getText().toString().trim();
                String Route_To_str=Route_To.getText().toString().trim();
                boolean isUpdate = db.updateRoute(Route_no_str,Route_NAME_str,Route_From_str,Route_To_str);
                if(isUpdate == true)
                {
                    Intent i = new Intent(Edit.this,Navigation_drawer.class);
                    i.setAction("Route details");
                    startActivity(i);

                   Toast.makeText(Edit.this,"updated",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Edit.this, "Profile Not Updated", Toast.LENGTH_LONG ).show();

                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = db.deleteData(Route_NO.getText().toString());
                if(deletedRows > 0) {
                    Intent i = new Intent(Edit.this, Navigation_drawer.class);
                    i.setAction("Route details");
                    startActivity(i);
                    Toast.makeText(Edit.this, "Data Deleted", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(Edit.this,"Data not Deleted",Toast.LENGTH_LONG).show();
            }
        });
    }
}
