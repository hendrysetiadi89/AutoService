package com.example.featureb.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class CustomService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //doWork
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        stopSelf()
        return START_NOT_STICKY
    }
    override fun onBind(p0: Intent?): IBinder? = null
}