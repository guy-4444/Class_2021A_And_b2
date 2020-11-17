package com.classy.class_2021a_and_b2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    final int DELAY = 2000; // 2000ms = 2 second
    private TextView main_LBL_counter;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_LBL_counter = findViewById(R.id.main_LBL_counter);
        Log.d("ptttT", "A:" + Thread.currentThread().getName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        startCounting();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopCounting();
    }



    private void secondlyFunction() {
        Log.d("pttt", "counter=" + ++counter);
        main_LBL_counter.setText("" + counter);
        playSound(R.raw.snd_hey_boddy);
    }

    MediaPlayer mp;
    private void playSound(int rawId) {
        if (mp!=null  &&  mp.isPlaying()) {
            mp.reset();
            mp.release();
            mp = null;
        }

        mp = MediaPlayer.create(this, rawId);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.reset();
                mp.release();
                mp=null;
            }
        });
        mp.start();
    }


    private Timer carousalTimer;

    private void startCounting() {
        carousalTimer = new Timer();
        carousalTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        secondlyFunction();
                    }
                });
            }
        }, 0, DELAY);
    }

    private void stopCounting() {
        carousalTimer.cancel();
    }

}