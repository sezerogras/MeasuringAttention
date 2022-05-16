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

public class MainActivity extends AppCompatActivity {
    TextView timeText;
    TextView scoreText;
    int score;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imagearray;
    Handler handler ;
    Runnable runnable;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9=findViewById(R.id.imageView9);

        imagearray= new ImageView[] {imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};
        hideImage();  // gÃ¶rÃ¼nmezlik metodunu oncreate altÄ±nda aÃ§Ä±lÄ±r aÃ§Ä±lmaz Ã§alÄ±ÅŸtÄ±rdÄ±m ...

        timeText = findViewById(R.id.timeText);    // burada ise ekranda gÃ¶sterdim bir nevi
        scoreText = findViewById(R.id.scoreText);
        score = 0;
        new CountDownTimer(10000,1000) {  //  bu metodla ise sÃ¼reyi azaltÄ±yoruz ama milimetre cinsinden onun iÃ§in bin e bÃ¶ldÃ¼m
            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Time: " + millisUntilFinished /1000);


            }

            @Override
            public void onFinish() {
                timeText.setText("Finished...");
                scoreText.getText();
                handler.removeCallbacks(runnable);
                for(ImageView image : imagearray) {      // burada ise bÃ¼tÃ¼n imageviewlerimi  for loopa attÄ±m
                    image.setVisibility(View.INVISIBLE); // BU KODU KULLANARAK HEPSÄ°NÄ° GÃ–RÃœNMEZ YAPTIK ...

                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Restart?");
                alert.setMessage("you did a good job!" +
                        "Are you sure to restart game?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // burada yes e tÄ±klarsa restart edilecek altta aynÄ± ÅŸekilde negativ buton oluÅŸturdum
                        Intent intent = getIntent();
                        finish();       // burada restrat iÃ§in intent sÄ±nÄ±fÄ± kullanarak aktiviteyi bitirdim ve aktivitemi yeniden baÅŸlattÄ±m
                        // kullanmamÄ±n amacÄ± aynÄ± altiviteye restart atmak Ã§ok fazla karÅŸÄ±ma Ã§Ä±kmaz .....
                        startActivity(intent);

                    }
                });
                alert.setNegativeButton("No!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // burada ise butona tÄ±klarsa oyun bitecek...
                        Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Game Over!", Toast.LENGTH_SHORT).show(); // altta tost oluÅŸturdum bana bilgi vermesi iÃ§in

                    }
                });
                alert.show();
            }
        }.start();

    }

    public void increaseScore (View view) {
        score++;                         // burada skoru arttÄ±rma metodunu kullanarak skoru arttÄ±rdÄ±k
        scoreText.setText("Score :" + score);


    }
    public void hideImage() {           // burada gÃ¶rÃ¼nmezlik metodunu aÃ§tÄ±m

        handler= new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image : imagearray) {      // burada ise bÃ¼tÃ¼n imageviewlerimi  for loopa attÄ±m
                    image.setVisibility(View.INVISIBLE); // BU KODU KULLANARAK HEPSÄ°NÄ° GÃ–RÃœNMEZ YAPTIK ...

                }
                Random random = new Random();
                int i = random.nextInt(9);
                imagearray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);

    }
}