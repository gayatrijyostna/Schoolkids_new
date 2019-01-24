package com.example.mvdprasad.schoolkids;

import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addroute extends Fragment {
    EditText Bus_Route_No,Route_Name,Route_From,Route_To;
    Button AddRoute;
    Database_admin db;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_route, container, false);
        Bus_Route_No=view.findViewById(R.id.Bus_Route_No);
        Route_Name=view.findViewById(R.id.Route_Name);
        Route_From=view.findViewById(R.id.Route_From);
        Route_To=view.findViewById(R.id.Route_From);
        AddRoute=view.findViewById(R.id.AddRoute);
        AddRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Bus_Route_No_str = Bus_Route_No.getText().toString().trim();
                String Route_Name_str = Route_Name.getText().toString().trim();
                String Route_From_str = Route_From.getText().toString().trim();
                String Route_To_str = Route_To.getText().toString().trim();
               if (!Bus_Route_No_str.equals("") && !Route_Name_str.equals("")&& !Route_From_str.equals("")&& !Route_To_str.equals("")) {
                   db=new Database_admin(getActivity());
                   db.insertRoute(Bus_Route_No_str, Route_Name_str, Route_From_str, Route_To_str);
                   View_routedetails f3 = new View_routedetails();
                   FragmentManager fm = getActivity().getSupportFragmentManager();
                   FragmentTransaction ft = fm.beginTransaction();
                   ft.replace(R.id.frame, f3);
                   ft.commit();
               }
               else{
                   Toast.makeText(getActivity(), "Route Added Succefully", Toast.LENGTH_LONG );
               }
            }
        });
    return view;
    }
}
