package com.example.mvdprasad.schoolkids;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class View_routedetails extends Fragment {
Database_admin db;
ArrayList<Map<String,String>> data;
//    RecyclerView recyclerView;
//    String[] arr1 = {"100", "80", "45", "$50"};
//    String[] arr2 = {"shantinagar 9th block to majestic", "majestic to jayanagr", "shantinagar to majestic", "udaypur to jayanagr"};
//    String[] arr3 = {"shantinagar", "majestic", "shantinagar", "udaypur"};
//    String[] arr4 = {"$100", "$80", "$45", "$50", "$80"};
//    String[] arr5 = {"udaypur", "shantinagar", "majestic", "shantinagar"};
//    ArrayAdapter<String> adapter;
//    Recycler_viewroute recycler;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_view_routedetails, container, false);
        RecyclerView recyclerView1 = view.findViewById(R.id.recycler3);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        data=new ArrayList<>();
        db=new Database_admin(getActivity());
        data = db.getRoute();
        Recycler_viewroute recyclerAdapter = new Recycler_viewroute(getActivity(), data);
        recyclerView1.setAdapter(recyclerAdapter);
      Button addroute = view.findViewById(R.id.addroute);
        addroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Addroute f3 = new Addroute();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame, f3);
                ft.commit();
            }
        });
        return view;

    }

}