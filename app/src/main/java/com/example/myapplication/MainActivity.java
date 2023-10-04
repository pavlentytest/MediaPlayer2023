package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    MediaPlayer player; // null => NullPointerException

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doAction(View v) {
        if(v.getId() == R.id.start){
            if(player == null) {
                player  = MediaPlayer.create(this,R.raw.vivaldi);
                player.start(); // с 1го раза стартуем
            } else {
                if(player.isPlaying()) {
                    player.pause();
                } else {
                    player.start(); // если уже на паузе - то продолжаем
                }
            }
        } else {
            player.stop();
            player = null;
        }
    }

}