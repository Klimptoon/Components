package com.example.components.sevices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CountService: Service() {
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Service has been started", Toast.LENGTH_LONG).show()
        startCount()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Service has been stopped", Toast.LENGTH_LONG).show()
    }

    private fun startCount() {
        GlobalScope.launch {
            for (i in 0 until 20) {
                Log.d("ff", "Service::: Count $i")
                delay(1000)
                if (i == 19) {
                    stopSelf()
                }
            }
        }
    }
}