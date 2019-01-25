package com.example.mvdprasad.schoolkids;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class Recycler_studentdetails extends RecyclerView.Adapter <Recycler_studentdetails.ViewHolderClass> {
    Context context;
    CheckBox[] cb;
    ArrayList<Map<String,String>> data;
//    String[] Rollno;
//    String[] Cellno;
//    String[] Busno;
//    String[] adress;
//    String[] Father_name;
//    String[] Mother_name;
//    String[] name;
//    String[] DOB;
//    String[] Gender;
//    String[] Class;
    public Recycler_studentdetails(Context Navigation_drawer,ArrayList<Map<String,String>> data ) {
        context = Navigation_drawer;
this.data=data;
    }
    @NonNull
    @Override
    public Recycler_studentdetails.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( context ).inflate( R.layout.recycler_student_details, viewGroup, false );
        Recycler_studentdetails.ViewHolderClass viewHolderClass = new Recycler_studentdetails.ViewHolderClass( view );
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_studentdetails.ViewHolderClass viewHolderClass, final int i) {
        viewHolderClass.rollno.setText( data.get(i).get(Database_admin.ROLL_NO) );
        viewHolderClass.adress.setText( data.get(i).get(Database_admin.ADDRESS1) );
        viewHolderClass.busno.setText( data.get(i).get(Database_admin.BUS_NO));
        viewHolderClass.gender.setText( data.get(i).get(Database_admin.GENDER1) );
        viewHolderClass.Class.setText( data.get(i).get(Database_admin.SECTION_OF_CLASS) );
        viewHolderClass.fathername.setText( data.get(i).get(Database_admin.FATHER_NAME) );
        viewHolderClass.mothername.setText( data.get(i).get(Database_admin.MOTHERNAME));
        viewHolderClass.cellno.setText( data.get(i).get(Database_admin.CELL_NO) );
        viewHolderClass.name.setText(data.get(i).get(Database_admin.NAME1) );
        viewHolderClass.dob.setText( data.get(i).get(Database_admin.DOB));
        viewHolderClass.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Intent intent=new Intent(context,Update_student_details.class);
                    intent.putExtra("ROLL_NO",data.get(i).get(Database_admin.ROLL_NO));
                    intent.putExtra("ADDRESS1",data.get(i).get(Database_admin.ADDRESS1));
                    intent.putExtra("BUS_NO",data.get(i).get(Database_admin.BUS_NO));
                    intent.putExtra("GENDER1",data.get(i).get(Database_admin.GENDER1));
                    intent.putExtra("SECTION_OF_CLASS",data.get(i).get(Database_admin.SECTION_OF_CLASS));
                    intent.putExtra("FATHER_NAME",data.get(i).get(Database_admin.FATHER_NAME));
                    intent.putExtra("MOTHERNAME",data.get(i).get(Database_admin.MOTHERNAME));
                    intent.putExtra("CELL_NO",data.get(i).get(Database_admin.CELL_NO));
                    intent.putExtra("NAME1",data.get(i).get(Database_admin.NAME1));
                    intent.putExtra("DOB",data.get(i).get(Database_admin.DOB));
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class ViewHolderClass extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView rollno;
        TextView adress;
        TextView busno;
        TextView gender;
        TextView Class;
        TextView fathername;
        TextView mothername;
        TextView cellno;
        TextView name;
        TextView dob;

        public ViewHolderClass(@NonNull View itemView) {
            super( itemView );

            checkBox = itemView.findViewById( R.id.cb );
            rollno=itemView.findViewById(R.id.rollno);
            adress=itemView.findViewById( R.id.adress );
            busno=itemView.findViewById( R.id.busno );
            gender=itemView.findViewById( R.id.gender );
            Class=itemView.findViewById( R.id.Class );
            fathername=itemView.findViewById( R.id.fathername );
            mothername=itemView.findViewById( R.id.mothername );
            cellno=itemView.findViewById( R.id.cell_no );
            name=itemView.findViewById( R.id.name );
            dob=itemView.findViewById( R.id.dob );
        }
    }
}
