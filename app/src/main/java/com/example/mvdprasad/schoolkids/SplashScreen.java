package com.example.mvdprasad.schoolkids;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashScreen extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    private static int splashtimeout = 4000;
    Animation uptodown,downtoup;
    LinearLayout bottom_layout;
    ImageView splash_image;
    @RequiresApi(api = 18)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           /* ActionBar actionBar = getSupportActionBar();
            actionBar.hide();*/
        setContentView(R.layout.activity_splash_screen);


        bottom_layout = findViewById(R.id.bottom_layout);
        splash_image = findViewById(R.id.emblem);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.anim_up_to_down);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.anim_down_to_up);
        bottom_layout.setAnimation(downtoup);
        splash_image.setAnimation(uptodown);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    Intent i = new Intent( SplashScreen.this, Admin_page.class );
                    startActivity(i);



                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);

            }
        }, splashtimeout);
    }


}

