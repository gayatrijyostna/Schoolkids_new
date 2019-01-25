package com.example.mvdprasad.schoolkids;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangePassword extends Fragment {
    public static final String MyPREFERENCES = "MyPrefs" ;
   TextView textView;
   Button change_pwd;
  private static Database_admin db;
   EditText password,conformpassword;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(R.layout.changepassword, container, false);
        SharedPreferences pref = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    final String username = pref.getString("Username", "as");
        textView=view.findViewById(R.id.edit_userName);
        textView.setText(username);
        password=view.findViewById(R.id.edit_newpwd);
        conformpassword=view.findViewById(R.id.edit_confrmpwd);
        change_pwd=view.findViewById(R.id.change_pwd);
        db=new Database_admin(getActivity());
        change_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().equals(conformpassword.getText().toString()))
                {
                    db.insertPassword(username,password.getText().toString());
                    Toast.makeText(getActivity(), "successfully changed the password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getActivity(),"new password confrim password must be same ",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}