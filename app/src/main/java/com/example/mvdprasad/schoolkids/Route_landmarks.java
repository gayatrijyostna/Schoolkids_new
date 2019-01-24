package com.example.mvdprasad.schoolkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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

public class Route_landmarks extends Fragment {
    Database_admin db;
    ArrayList<Map<String,String>> data;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.route_landmarks, container, false );
        RecyclerView recyclerView1 = view.findViewById( R.id.recycler4 );
        recyclerView1.setLayoutManager( new LinearLayoutManager( getActivity()));
        data=new ArrayList<>();
        db=new Database_admin(getActivity());
        data = db.getRoute();
        Recycler_landmark recyclerAdapter = new Recycler_landmark( getActivity(), data );
        recyclerView1.setAdapter( recyclerAdapter );
        return view;


    }
}