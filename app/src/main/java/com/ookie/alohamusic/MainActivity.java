package com.ookie.alohamusic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    MediaPlayer mpUkelele, mpDrums;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btnUkulele);
        button2 = findViewById(R.id.btnDrums);
        button1.setOnClickListener(bUkulele);
        button2.setOnClickListener(bDrums);
        mpUkelele = new MediaPlayer();
        mpUkelele = MediaPlayer.create(this, R.raw.ukulele);
        mpDrums = new MediaPlayer();
        mpDrums = MediaPlayer.create(this, R.raw.drums);
        playing = 0;

    }

    Button.OnClickListener bUkulele = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpUkelele.start();
                    playing = 1;
                    button1.setText("Pause Ukulele Song");
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpUkelele.pause();
                    playing = 0;
                    button1.setText("Play Ukulele Song");
                    button2.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    Button.OnClickListener bDrums = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpDrums.start();
                    playing = 1;
                    button2.setText("Pause Drums Song");
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpDrums.pause();
                    playing = 0;
                    button2.setText("Play Drums Song");
                    button1.setVisibility(View.VISIBLE);
                    break;
            }
        }

    };
}
