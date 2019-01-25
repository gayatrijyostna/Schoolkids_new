package com.example.mvdprasad.schoolkids;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class Investigator_profile extends Fragment {
    public static final String MyPREFERENCES = "MyPrefs" ;
    Database_admin db;
    TextView edit_name,edit_username,email,address,phone,gender;
    ArrayList<Map<String, String>> data;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_investigator_profile, container, false);
        SharedPreferences pref = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String username = pref.getString("Username", "as");
        data = new ArrayList<Map<String, String>>();
        db = new Database_admin(getActivity());
        data = db.getRetriveAll(username);

        edit_name = view.findViewById(R.id.edit_name);
        edit_username = view.findViewById(R.id.edit_username);
        email = view.findViewById(R.id.email);
        gender = view.findViewById(R.id.edit_gender);
        phone = view.findViewById(R.id.phone);
        address = view.findViewById(R.id.Address);

        edit_name.setText(data.get(0).get(Database_admin.NAME));
        edit_username.setText(data.get(0).get(Database_admin.USERNAME));
        email.setText(data.get(0).get(Database_admin.EMAIL));
        gender.setText(data.get(0).get(Database_admin.GENDER));
        phone.setText(data.get(0).get(Database_admin.PHONE));
        address.setText(data.get(0).get(Database_admin.ADDRESS));


        Button update = view.findViewById(R.id.update);
update.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Update_investigator_profile Up= new Update_investigator_profile();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, Up);
        ft.commit();
    }
});
//        backtomenu.setOnClickListener(new View.OnClickListener()
//        {  @Override
//        public void onClick(View v) {
//            /*Intent i=new Intent(Investigator_profile.this,Update_investigator_profile.class);
//            startActivity(i);*/
//            Toast.makeText(Investigator_profile.this, "Details will be updated", Toast.LENGTH_SHORT).show();
//        }
//        });
        return view;

    }
}
