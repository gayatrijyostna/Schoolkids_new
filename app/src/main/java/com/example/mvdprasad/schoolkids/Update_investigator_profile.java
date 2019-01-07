package com.example.mvdprasad.schoolkids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_investigator_profile extends AppCompatActivity {
    EditText username;
    EditText name;
    EditText email;
    EditText mobile;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_update_investigator_profile );
      username=findViewById( R.id.username );
        name=findViewById( R.id.name );
        email=findViewById( R.id.email );
        mobile=findViewById( R.id.mobile );
        update=findViewById( R.id.update );

        update.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              checkDataEntered();
            }
        } );
    }


    boolean isEmail(EditText text){
        CharSequence email=text.getText().toString();
        return(!TextUtils.isEmpty( email )&& Patterns.EMAIL_ADDRESS.matcher( email ).matches());
    }
    boolean isEmpty(EditText text){
        CharSequence str=text.getText().toString();
        return TextUtils.isEmpty( str );
    }
    private void checkDataEntered() {
   if (isEmpty( username )){
       Toast t=Toast.makeText( this,"you must enter username to register!",Toast.LENGTH_SHORT );
       t.show();
   }
   if (isEmpty( name )){
       name.setError( "name is required!" );
   }
   if (isEmail( email )){
       email.setError("enter valid email!");
   }
        if (isEmpty( mobile )){
            mobile.setError("enter valid mobile number!");
        }
    }
}
