package com.example.mvdprasad.schoolkids;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

public class Add_student_details  extends AppCompatActivity implements View.OnClickListener {
    EditText Rollno,Name,Cell_no,Adress,Section_of_class,Father_name,Mother_name,Passwrd;
    RadioGroup edit_gender;
    Spinner Bus_no;
    Button Add;
    Calendar myCalendar;
    private EditText Birthday;
    Database_admin db;
    DatePickerDialog.OnDateSetListener from_dateListener;
ArrayList<String> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.add_student_details );
        Rollno=findViewById( R.id.edit_roll );
        Birthday=findViewById( R.id.Birthday );
        Name=findViewById( R.id.edit_name );
        Cell_no=findViewById( R.id.edit_cellno );
        Bus_no=findViewById( R.id.edit_busno);
        Adress=findViewById( R.id.edit_adress );
        Section_of_class=findViewById( R.id.edit_soc );
        Father_name=findViewById( R.id.edit_fathername );
        Mother_name=findViewById( R.id.edit_mothernme );
        Passwrd=findViewById( R.id.edit_passwrd );
        edit_gender=findViewById( R.id.edit_gender );
        Add=findViewById( R.id.add );
        db=new Database_admin(this);
        data = db.getBusName();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        Bus_no.setAdapter(dataAdapter);
        myCalendar = Calendar.getInstance();
        Birthday.setOnClickListener(this);
        from_dateListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateFromDateDisplay();
            }

        };
        getSupportActionBar().setTitle( "ADD STUDENT DETAILS" );
        Add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
                if(Rollno.getText().toString().equals( "" ))
                {
                    Rollno.setError( "This field is required" );
                }
                String Rollno_str=Rollno.getText().toString();
                String Birthday_str=Birthday.getText().toString();
                String Name_str=Name.getText().toString();
                String Cell_no_str=Cell_no.getText().toString();
                String Bus_no_str= Bus_no.getSelectedItem().toString();
                String Adress_str=Adress.getText().toString();
                String Section_of_class_str=Section_of_class.getText().toString();
                String Father_name_str=Father_name.getText().toString();
                String Mother_name_str=Mother_name.getText().toString();
                String Passwrd_str=Passwrd.getText().toString();


                if(!Rollno_str.equals( "" ) &&
                        !Birthday.getText().toString().equals( "" ) &&
                        !Name.getText().toString().equals( "" ) &&
                        !Cell_no.getText().toString().equals( "" ) &&
                        !Bus_no.getSelectedItem().toString().equals( "" ) &&
                        !Adress.getText().toString().equals( "" ) &&
                        !Section_of_class.getText().toString().equals( "" ) &&
                        !Father_name.getText().toString().equals( "" ) &&
                        !Mother_name.getText().toString().equals( "" ) &&
                        !Passwrd.getText().toString().equals( "" ) &&
                          !edit_gender.isClickable() )
                {
                    int selectedId = edit_gender.getCheckedRadioButtonId();
                    RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
                    String radioButtonText = selectedRadioButton.getText().toString();
                    db.insert_studentdetails(Rollno_str, Birthday_str, Name_str, Cell_no_str, Bus_no_str, Adress_str,Section_of_class_str,Father_name_str,Mother_name_str,Passwrd_str,radioButtonText);
                    Intent i = new Intent(Add_student_details.this, Navigation_drawer.class);
                    i.setAction("Student details");
                    startActivity(i);
                    startActivity(i);
                    Toast.makeText(Add_student_details.this, "successfully saved", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Add_student_details.this,"not saved plz check",Toast.LENGTH_LONG).show();
                }
            }
        } );
    }

    boolean isEmpty(Spinner text){
        CharSequence str=text.getSelectedView().toString();
        return TextUtils.isEmpty( str );
    }
    boolean isEmpty(TextView text){
        CharSequence str=text.getText().toString();
        return TextUtils.isEmpty( str );
    }
    private void checkDataEntered() {
        if (isEmpty(Bus_no)){
            Toast t=Toast.makeText( this,"This field is required!",Toast.LENGTH_SHORT );
            t.show();
        }
        if (isEmpty( Name)){
            Name.setError( "This field is required!" );
        }
        if (isEmpty( Rollno)){
            Rollno.setError( "This field is required!" );
        }

        if (isEmpty( Passwrd)){
            Passwrd.setError( "This field is required!" );
        }
        if (isEmpty( Adress)){
            Adress.setError( "This field is required!" );
        }
        if (isEmpty( Section_of_class)){
            Section_of_class.setError( "This field is required!" );
        }

        if (isEmpty( Father_name)){
            Father_name.setError( "This field is required!" );
        }
        if (isEmpty( Mother_name)){
            Mother_name.setError( "This field is required!" );
        }
        if (isEmpty( Cell_no )){
            Cell_no.setError("enter valid mobile number!");
        }

        Birthday = (EditText) findViewById( R.id.Birthday);
        // TODO Auto-generated method stub

    }

    private void updateFromDateDisplay() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        Birthday.setText(sdf.format(myCalendar.getTime()));

        /*from_date.setText(new StringBuilder()
                .append(from_day).append("-").append(from_month + 1).append("-").append(from_year));*/
    }


    @Override
    public void onClick(View v) {
        DatePickerDialog dpDialog =  new DatePickerDialog(this, from_dateListener, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));
        DatePicker datePicker = dpDialog.getDatePicker();

        Calendar calendar = Calendar.getInstance();
        datePicker.setMaxDate(calendar.getTimeInMillis());
        dpDialog.show();

    }
}
