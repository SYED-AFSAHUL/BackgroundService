package com.example.dionysus.background;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dionysus on 25/2/18.
 */

public class Myservice extends Service{
    private static Timer timer = new Timer();
    private Context ctx;
    String TAG = "sMess";

    public IBinder onBind(Intent arg0)
    {
        Log.d(TAG,"onBind");
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        ctx = this;
        Log.d(TAG,"onCreate()");
        startService();
    }

    private void startService()
    {
        Log.d(TAG,"startService()");
        timer.scheduleAtFixedRate(new mainTask(), 0, 1000);
    }

    private class mainTask extends TimerTask
    {
        public void run()
        {
//            Toast.makeText(ctx, "test", Toast.LENGTH_SHORT).show();
            Log.d(TAG,"this is a log from thread");
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this, "Service Stopped ...", Toast.LENGTH_SHORT).show();
    }
}