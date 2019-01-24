package com.example.mvdprasad.schoolkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class Student_details extends Fragment {
    RecyclerView recyclerView;
    ArrayAdapter<String> adapter;
    Student_details recycler;
    ArrayList<Map<String,String>> data2;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.student_details, container, false );
        RecyclerView recyclerView1 = view.findViewById( R.id.recycler5 );
        recyclerView1.setLayoutManager( new LinearLayoutManager( getActivity()));
        Database_admin DB1=new Database_admin( getActivity() );
        data2=DB1.getstudentdata(  );
        Recycler_studentdetails recyclerAdapter = new Recycler_studentdetails(getActivity(),data2);
        recyclerView1.setAdapter(recyclerAdapter);
        TextView addroute=view.findViewById(R.id.addroute1);
        addroute.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Add_student_details.class);
                startActivity(i);
            }
        });
        return view;


    }

}


