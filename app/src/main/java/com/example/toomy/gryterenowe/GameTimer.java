package com.example.toomy.gryterenowe;

import android.os.Handler;
import android.os.SystemClock;
import android.widget.TextView;

/**
 * Created by noemi on 23.12.17.
 */

public class GameTimer {
    private static final GameTimer ourInstance = new GameTimer();
    private long startTime = 0L;

    private Handler customHandler = new Handler();
    private TextView timerValue;

    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    private static String timer = "0";

    public static GameTimer getInstance() {
        return ourInstance;
    }

    public String getTime(){
        return timer;
    }

    private GameTimer() {

    }
    public void setTimerToTextViewOnFirstRun(TextView input){
        timerValue = input;
        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(startTimerThread, 0);
    }

    public void setTimerToTextViewOnContinue(TextView input){
        timerValue = input;
        customHandler.postDelayed(continueTimerThread, 0);
    }

    private Runnable continueTimerThread = new Runnable() {
        public void run() {
            updatedTime = timeSwapBuff + timeInMilliseconds;
            updateTextWithTimeValue(timerValue, timeInMilliseconds);
            customHandler.postDelayed(this, 0);
        }
    };

    private void updateTextWithTimeValue(TextView view, long timeInMilliseconds){
        updatedTime = timeSwapBuff + timeInMilliseconds;
        int secs = (int) (updatedTime / 1000);
        int mins = secs / 60;
        secs = secs % 60;
        int milliseconds = (int) (updatedTime % 1000);
        timer = "" + mins + ":"
                + String.format("%02d", secs) + ":"
                + String.format("%03d", milliseconds);
        timerValue.setText(timer);
    }

    private Runnable startTimerThread = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updateTextWithTimeValue(timerValue, timeInMilliseconds);
            customHandler.postDelayed(this, 0);
        }
    };

}
