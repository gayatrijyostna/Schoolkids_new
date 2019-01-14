package com.example.mvdprasad.schoolkids;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class View_routedetails extends Fragment {

    RecyclerView recyclerView;
    String[] arr1 = {"100", "80", "45", "$50"};
    String[] arr2 = {"jayanagar 9th block to majestic", "majestic to jayanagr", "jayanagar to majestic", "kormangala to jayanagr"};
    String[] arr3 = {"jayanagar", "majestic", "jayanagar", "kormangala"};
    String[] arr4 = {"$100", "$80", "$45", "$50", "$80"};
    String[] arr5 = {"kormangala", "jayanagar", "majestic", "jayanagar"};
    ArrayAdapter<String> adapter;
    Recycler_viewroute recycler;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_view_routedetails, container, false);
        RecyclerView recyclerView1 = view.findViewById(R.id.recycler3);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        Recycler_viewroute recyclerAdapter = new Recycler_viewroute(getActivity(), arr1, arr2, arr3, arr4, arr5);
        recyclerView1.setAdapter(recyclerAdapter);
        TextView addroute = view.findViewById(R.id.addroute);
        addroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Addroute.class);
                startActivity(i);
            }
        });
        return view;

    }

}