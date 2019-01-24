package com.example.mvdprasad.schoolkids;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Map;


public class Update_investigator_profile extends Fragment {
    RadioGroup radioGroup;
    EditText username, name, email, password,phone,Address;
    Button updateprofile;
    RadioButton male,female;
    public static final String MyPREFERENCES = "MyPrefs" ;
    Database_admin db;
    ArrayList<Map<String, String>> data;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_update_investigator_profile, container, false);
        name=view.findViewById(R.id.edit_name);
        username=view.findViewById(R.id.edit_username);
        email=view.findViewById(R.id.email);
        password=view.findViewById(R.id.edit_password1);
        radioGroup=view.findViewById(R.id.radioGroup);
        phone=view.findViewById(R.id.phone);
        Address=view.findViewById(R.id.Address);
        updateprofile = view.findViewById(R.id.updateprofile);

        SharedPreferences pref = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String Username = pref.getString("Username", "as");
        data = new ArrayList<Map<String, String>>();
        db = new Database_admin(getActivity());
        data = db.getRetriveAll(Username);

        name.setText(data.get(0).get(Database_admin.NAME));
        username.setText(data.get(0).get(Database_admin.USERNAME));
        email.setText(data.get(0).get(Database_admin.EMAIL));
        password.setText(data.get(0).get(Database_admin.PASSWORD));
       String gender_str= data.get(0).get(Database_admin.GENDER);
      if(gender_str.equals("male"))
      {
          male=view.findViewById(R.id.male);
          male.setChecked(true);
      }
      else
      {
          female=view.findViewById(R.id.female);
          female.setChecked(true);
      }
//        gender.setText(data.get(0).get(Database_admin.ADDRESS));
        phone.setText(data.get(0).get(Database_admin.PHONE));
        Address.setText(data.get(0).get(Database_admin.ADDRESS));
        updateprofile.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String name_str = name.getText().toString().trim();
        String username_str = username.getText().toString().trim();
        String email_str = email.getText().toString().trim();
        String password_str = password.getText().toString().trim();

        int selectedId =radioGroup.getCheckedRadioButtonId();
       RadioButton selectedRadioButton = (RadioButton)view.findViewById(selectedId);
        String radioButtonText = selectedRadioButton.getText().toString();

        String phone_str = phone.getText().toString().trim();
        String Address_str = Address.getText().toString().trim();

        boolean isUpdate = db.updateData(name_str,username_str,email_str,password_str,radioButtonText,phone_str,Address_str);
        if(isUpdate == true)
        {
            Toast.makeText(getActivity(), "profile Updated Succesfully", Toast.LENGTH_LONG ).show();
            View_routedetails f3 = new View_routedetails();
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, f3);
            ft.commit();
        }
     else {
            Toast.makeText(getActivity(), "Profile Not Updated", Toast.LENGTH_LONG ).show();

        }
    }
});

        return  view;
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_update_investigator_profile);
//
//        username = findViewById(R.id.edit_username1);
//        name = findViewById(R.id.edit_name1);
//        email = findViewById(R.id.edit_email1);
//        mobile = findViewById(R.id.edit_mobile1);
//        updateprofile = findViewById(R.id.updateprofile);
//
//        updateprofile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                checkDataEntered();
//                if (username.getText().toString().equals("")) {
//                    username.setError("enter username");
//                }
//            }
//        });
//    }
//
//
//    boolean isEmail(TextView text) {
//        CharSequence email = text.getText().toString();
//        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
//    }
//
//    boolean isEmpty(TextView text) {
//        CharSequence str = text.getText().toString();
//        return TextUtils.isEmpty(str);
//    }
//
//    private void checkDataEntered() {
//        if (isEmpty(username)) {
//            Toast t = Toast.makeText(this, "you must enter username to register!", Toast.LENGTH_SHORT);
//            t.show();
//        }
//        if (isEmpty(name)) {
//            name.setError("name is required!");
//        }
//        if (isEmail(email)) {
//            email.setError("enter valid email!");
//        }
//        if (isEmpty(mobile)) {
//            mobile.setError("enter valid mobile number!");
//        }
//    }
}
