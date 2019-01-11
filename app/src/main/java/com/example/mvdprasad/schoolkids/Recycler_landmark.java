package com.example.mvdprasad.schoolkids;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class Recycler_landmark extends RecyclerView.Adapter<Recycler_viewroute.ViewHolderClass> {
    Context context;
    CheckBox[] cb;
    String[] arr1;
    String[] arr2;
    String[] arr3;
    String[] arr4;
    String[] arr5;

    public Recycler_landmark(Context Navigation_drawer, String[] arr1, String[] arr2, String[] arr3, String[] arr4, String[] arr5) {
        context = Navigation_drawer;
        this.cb = cb;
        this.arr1=arr1;
        this.arr2=arr2;
        this.arr3=arr3;
        this.arr4=arr4;
        this.arr5=arr5;

    }

    @NonNull
    @Override
    public Recycler_viewroute.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( context ).inflate( R.layout.activity_recycler_viewroute, viewGroup, false );
        Recycler_viewroute.ViewHolderClass viewHolderClass = new Recycler_viewroute.ViewHolderClass( view );
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_viewroute.ViewHolderClass viewHolderClass, int i) {
//        viewHolderClass.checkBox.isChecked();
        viewHolderClass.txtview.setText( arr1[i]);
        viewHolderClass.txtview1.setText( arr2[i]);
        viewHolderClass.txtview2.setText( arr3[i]);
        viewHolderClass.txtview3.setText( arr4[i]);
        viewHolderClass.txtview4.setText( arr5[i]);



    }

    @Override
    public int getItemCount() {
        return arr1.length;
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView txtview;
        TextView txtview1;
        TextView txtview2;
        TextView txtview3;
        TextView txtview4;

        public ViewHolderClass(@NonNull View itemView) {
            super( itemView );
            checkBox = itemView.findViewById( R.id.cb );
            txtview=itemView.findViewById(R.id.busno);
            txtview1=itemView.findViewById( R.id.routenme );
            txtview2=itemView.findViewById( R.id.routefrom );
            txtview3=itemView.findViewById( R.id.routeto );
            txtview4=itemView.findViewById( R.id.buspwd );
        }
    }
}

