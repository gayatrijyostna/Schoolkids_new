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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class Recycler_viewroute extends RecyclerView.Adapter<Recycler_viewroute.ViewHolderClass> {
    Context context;
 ArrayList<Map<String,String>> data;


    public Recycler_viewroute(Context Navigation_drawer, ArrayList<Map<String,String>> data) {
        context = Navigation_drawer;
        this.data=data;

    }

    @NonNull
    @Override
    public Recycler_viewroute.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_recycler_viewroute, viewGroup, false);
        ViewHolderClass viewHolderClass = new Recycler_viewroute.ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_viewroute.ViewHolderClass viewHolderClass,final int i) {
//        viewHolderClass.checkBox.isChecked();
        viewHolderClass.txtview.setText(data.get(i).get(Database_admin.BUSROUTENO));
        viewHolderClass.txtview1.setText(data.get(i).get(Database_admin.ROUTENAME));
        viewHolderClass.txtview2.setText(data.get(i).get(Database_admin.ROUTEFROM));
        viewHolderClass.txtview3.setText(data.get(i).get(Database_admin.ROUTETO));
        viewHolderClass.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Intent intent=new Intent(context,Edit.class);
                    intent.putExtra("BUSROUTENO",data.get(i).get(Database_admin.BUSROUTENO));
                    intent.putExtra("ROUTENAME",data.get(i).get(Database_admin.ROUTENAME));
                    intent.putExtra("ROUTEFROM",data.get(i).get(Database_admin.ROUTEFROM));
                    intent.putExtra("ROUTETO",data.get(i).get(Database_admin.ROUTETO));
                    context.startActivity(intent);
                }
            }
        });
       /*Boolean in= viewHolderClass.checkBox.isChecked();
        if(in)
        {

        }
*/

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolderClass extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView txtview;
        TextView txtview1;
        TextView txtview2;
        TextView txtview3;


        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.cb);
            txtview = itemView.findViewById(R.id.busno);
            txtview1 = itemView.findViewById(R.id.routenme);
            txtview2 = itemView.findViewById(R.id.routefrom);
            txtview3 = itemView.findViewById(R.id.routeto);
        }
    }
}
