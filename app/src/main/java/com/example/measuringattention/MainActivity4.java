package com.example.measuringattention;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity4 extends AppCompatActivity {
    TextView timeTextTwo;
    TextView scoreTextTwo;
    int score;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView imageView16;
    ImageView imageView17;
    ImageView imageView18;
    ImageView imageView19;
    ImageView imageView20;
    ImageView imageView21;
    ImageView[] imagearrayTwo;
    Handler handlerTwo;
    Runnable runnableTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView14 = findViewById(R.id.imageView14);
        imageView15 = findViewById(R.id.imageView15);
        imageView16 = findViewById(R.id.imageView16);
        imageView17 = findViewById(R.id.imageView17);
        imageView18 = findViewById(R.id.imageView18);
        imageView19 = findViewById(R.id.imageView19);
        imageView20 = findViewById(R.id.imageView20);
        imageView21 = findViewById(R.id.imageView21);

        imagearrayTwo = new ImageView[]{imageView10, imageView11, imageView12, imageView13, imageView14, imageView15, imageView16, imageView17, imageView18, imageView19, imageView20, imageView21};
        hideImage();  // g????r????nmezlik metodunu oncreate alt????nda a????????l????r a????????lmaz ????al????????t????rd????m ...

        timeTextTwo = findViewById(R.id.timeTextTwo);    // burada ise ekranda g????sterdim bir nevi
        scoreTextTwo = findViewById(R.id.scoreTextTwo);
        score = 0;
        new CountDownTimer(10000, 1000) {  //  bu metodla ise s????reyi azalt????yoruz ama milimetre cinsinden onun i????in bin e b????ld????m
            @Override
            public void onTick(long millisUntilFinished) {
                timeTextTwo.setText("Time: " + millisUntilFinished / 1000);


            }

            @Override
            public void onFinish() {
                timeTextTwo.setText("Finished...");
                scoreTextTwo.getText();
                handlerTwo.removeCallbacks(runnableTwo);
                for (ImageView image : imagearrayTwo) {      // burada ise b????t????n imageviewlerimi  for loopa att????m
                    image.setVisibility(View.INVISIBLE); // BU KODU KULLANARAK HEPS????N???? G?????R????NMEZ YAPTIK ...

                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity4.this);
                alert.setTitle("Restart?");
                alert.setMessage("you did a good job!" +
                        "Are you sure to restart game?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // burada yes e t????klarsa restart edilecek altta ayn???? ????ekilde negativ buton olu????turdum
                        Intent intent = getIntent();
                        finish();       // burada restrat i????in intent s????n????f???? kullanarak aktiviteyi bitirdim ve aktivitemi yeniden ba????latt????m
                        // kullanmam????n amac???? ayn???? altiviteye restart atmak ????ok fazla kar????????ma ????????kmaz .....
                        startActivity(intent);

                    }
                });
                alert.setNegativeButton("No!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // burada ise butona t????klarsa oyun bitecek...
                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity4.this, "Game Over!", Toast.LENGTH_SHORT).show(); // altta tost olu????turdum bana bilgi vermesi i????in

                    }
                });
                alert.show();
            }
        }.start();

    }

    public void increascoretwo(View view) {
        score++;                         // burada skoru artt????rma metodunu kullanarak skoru artt????rd????k
        scoreTextTwo.setText("Score :" + score);


    }

    public void hideImage() {           // burada g????r????nmezlik metodunu a????t????m

        handlerTwo = new Handler();
        runnableTwo = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imagearrayTwo) {      // burada ise b????t????n imageviewlerimi  for loopa att????m
                    image.setVisibility(View.INVISIBLE); // BU KODU KULLANARAK HEPS????N???? G?????R????NMEZ YAPTIK ...

                }
                Random random = new Random();
                int i = random.nextInt(9);
                imagearrayTwo[i].setVisibility(View.VISIBLE);
                handlerTwo.postDelayed(this, 500);
            }
        };
        handlerTwo.post(runnableTwo);

    }
}
