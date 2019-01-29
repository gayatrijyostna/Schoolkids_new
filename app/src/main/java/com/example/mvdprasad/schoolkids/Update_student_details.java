package com.example.mvdprasad.schoolkids;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Update_student_details extends AppCompatActivity implements View.OnClickListener{
    EditText Rollno,Name,Cell_no,Adress,Section_of_class,Father_name,Mother_name,Passwrd;
    RadioGroup radioGroup;
    RadioButton Gender1,gender2;
    Spinner Bus_no;
    Button update,delete,back;
    Calendar myCalendar;
    private EditText Birthday;
    Database_admin db;
    DatePickerDialog.OnDateSetListener from_dateListener;
    ArrayList<String> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student_details);

        Rollno=findViewById( R.id.edit_roll1 );
        Birthday=findViewById( R.id.Birthday1 );
        Name=findViewById( R.id.edit_name1 );
        Cell_no=findViewById( R.id.edit_cellno1);
        Bus_no=findViewById( R.id.edit_busno1);
        Adress=findViewById( R.id.edit_adress1 );
        Section_of_class=findViewById( R.id.edit_soc1 );
        Father_name=findViewById( R.id.edit_fathername1 );
        Mother_name=findViewById( R.id.edit_mothernme1);
        Gender1=findViewById( R.id.edit_gender1 );
       gender2=findViewById( R.id.edit_gender2 );
        update=findViewById(R.id.update1);
        delete=findViewById(R.id.delete);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Update_student_details.this,Navigation_drawer.class));
            }
        });
        Rollno.setText(getIntent().getStringExtra("ROLL_NO"));
        Birthday.setText(getIntent().getStringExtra("DOB"));
        Name.setText(getIntent().getStringExtra("NAME1"));
        Cell_no.setText(getIntent().getStringExtra("CELL_NO"));
    //  Bus_no.setSelected(getIntent().getStringExtra("ROLL_NO"));

        db=new Database_admin(this);
        data = db.getBusName();
        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                data);
        Bus_no.setSelection(spinnerArrayAdapter.getPosition(getIntent().getStringExtra("BUS_NO")));
        Bus_no.setAdapter(spinnerArrayAdapter);
        Adress.setText(getIntent().getStringExtra("ADDRESS1"));
        Section_of_class.setText(getIntent().getStringExtra("SECTION_OF_CLASS"));
        Father_name.setText(getIntent().getStringExtra("FATHER_NAME"));
        Mother_name.setText(getIntent().getStringExtra("MOTHERNAME"));
        if(getIntent().getStringExtra("GENDER!")=="MALE")
        {
            Gender1.setChecked(true);
        }
        else
        {
            gender2.setChecked(true);
        }
        db=new Database_admin(this);
        myCalendar = Calendar.getInstance();
        Birthday.setOnClickListener(this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Rollno_str=Rollno.getText().toString().trim();
                String Birthday_str=Birthday.getText().toString().trim();
                String  Name_str=Name.getText().toString().trim();
                String Cell_no_str=Cell_no.getText().toString().trim();
                String Bus_no_str=Bus_no.getSelectedItem().toString().trim();
                String Adress_str=Adress.getText().toString().trim();
                String Section_of_class_str=Section_of_class.getText().toString().trim();
                String Father_name_str=Father_name.getText().toString().trim();
                String Mother_name_str=Mother_name.getText().toString().trim();
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
                String radioButtonText = selectedRadioButton.getText().toString();
                boolean isUpdate = db.updateStudent(Rollno_str,Name_str,Birthday_str,Father_name_str,Bus_no_str,Cell_no_str,Adress_str,Section_of_class_str,Mother_name_str,radioButtonText);
                if(isUpdate == true)
                {

                    Intent i = new Intent(Update_student_details.this,Navigation_drawer.class);
                    i.setAction("Student details");
                    startActivity(i);
                    Toast.makeText(Update_student_details.this,"updated",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Update_student_details.this, "Profile Not Updated", Toast.LENGTH_LONG ).show();

                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = db.deleteStudent(Rollno.getText().toString());
                if(deletedRows > 0) {
                    Intent i = new Intent(Update_student_details.this, Navigation_drawer.class);
                    i.setAction("Student details");
                    startActivity(i);
                    Toast.makeText(Update_student_details.this, "Data Deleted", Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(Update_student_details.this,"Data not Deleted",Toast.LENGTH_LONG).show();
            }
        });



        Birthday.setOnClickListener(this);
        db=new Database_admin(this);
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
