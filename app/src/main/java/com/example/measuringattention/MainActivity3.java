package com.example.measuringattention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {
    MediaPlayer ply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }


    public void gonder(View view) {

     //   Intent intent = new Intent(getApplicationContext(),MainActivity.class);
      //  startActivity(intent);



    }

    public void kal (View view) {

        finish();
        ply.stop();
    }
    public void gonderTwo(View view) {

       // Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
       // startActivity(intent);



    }
}