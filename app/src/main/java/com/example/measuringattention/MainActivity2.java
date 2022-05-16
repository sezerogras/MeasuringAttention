package com.example.measuringattention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    MediaPlayer ply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }


    public void gonder(View view) {

            ply = new MediaPlayer().create(MainActivity2.this,R.raw.song);


       /*  if(ply.isPlaying()){
             ply.pause();
             ply.seekTo(0);
             ply.start();
         }
         else
        {
            ply.start();
        } */

         if(ply.isLooping()){

             ply.pause();
             ply.seekTo(0);
             ply.setLooping(false);

         }
         else {
             ply.start();
             ply.setLooping(true);
         }



     Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);



    }

    public void gonderTwo(View view) {

            ply = new MediaPlayer().create(MainActivity2.this,R.raw.song);


    /*    if(ply.isPlaying()){
            ply.pause();
            ply.seekTo(0);
            ply.start();
        }
        else
        {
            ply.start();
        }
*/
        if(ply.isLooping()){

            ply.pause();
            ply.seekTo(0);
            ply.setLooping(false);

        }
        else {
            ply.start();
            ply.setLooping(true);
        }



       Intent intentone = new Intent(getApplicationContext(),MainActivity4.class);
       startActivity(intentone);



    }


    public void kal (View view) {

        finish();
          ply.stop();
    }
}