package com.example.mvdprasad.schoolkids;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class Recycler_landmark extends RecyclerView.Adapter<Recycler_landmark.ViewHolderClass> {
    Context context;

    ArrayList<Map<String,String>> data3;
    public Recycler_landmark(Context Navigation_drawer, ArrayList<Map<String,String>> data3) {
        context = Navigation_drawer;
        this.data3=data3;

    }


    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( context ).inflate( R.layout.activity_recycler_landmark, viewGroup, false );
        Recycler_landmark.ViewHolderClass viewHolderClass = new Recycler_landmark.ViewHolderClass( view );
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass viewHolderClass,final int i) {
        viewHolderClass.txtview.setText( data3.get( i).get( Database_admin.BUSROUTENO ));
        viewHolderClass.txtview1.setText( data3.get( i ).get( Database_admin.ROUTENAME ));
        viewHolderClass.txtview2.setText(  data3.get( i ).get( Database_admin.ROUTEFROM ));
        viewHolderClass.txtview3.setText(  data3.get( i ).get( Database_admin.ROUTETO ));
        viewHolderClass.Addlandmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Add_landmark.class);
                intent.putExtra("BUSNO",data3.get(i).get(Database_admin.BUSROUTENO));
                context.startActivity(intent);
            }
        });
        viewHolderClass.viewlandmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,viewlandmark.class);
                intent.putExtra("BUSNO",data3.get(i).get(Database_admin.BUSROUTENO));
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return data3.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView txtview;
        TextView txtview1;
        TextView txtview2;
        TextView txtview3;
        Button viewlandmark,Addlandmark;

        public ViewHolderClass(@NonNull View itemView) {
            super( itemView );
            txtview=itemView.findViewById(R.id.busno);
            txtview1=itemView.findViewById( R.id.routenme );
            txtview2=itemView.findViewById( R.id.routefrom );
            txtview3=itemView.findViewById( R.id.routeto );
            viewlandmark=itemView.findViewById(R.id.viewlandmark);
            Addlandmark=itemView.findViewById(R.id.addlandmark);
        }
    }
}

