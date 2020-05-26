package com.example.musicplayer1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button play, stop, pause;
    MediaPlayer mediaPlayer;
    int currentposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play= findViewById(R.id.btnplay);
        pause= findViewById(R.id.btnpause);
        stop= findViewById(R.id.btnstop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btnplay:
                if(mediaPlayer==null)
                {
                mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.dance);
                mediaPlayer.start();}
                else if(!mediaPlayer.isPlaying())
                {
                    mediaPlayer.seekTo(currentposition);
                    mediaPlayer.start();
                }
                break;
            case R.id.btnpause:
                if(mediaPlayer!=null)
                { mediaPlayer.pause();
                 currentposition= mediaPlayer.getCurrentPosition();}
                break;
            case R.id.btnstop:
                if(mediaPlayer!=null){
                mediaPlayer.stop();
                mediaPlayer=null;}
                break;



        }

    }
}
