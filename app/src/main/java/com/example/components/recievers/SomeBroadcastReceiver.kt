package com.example.components.recievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SomeBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val isAirplaneMode = p1?.getBooleanExtra("state", false) ?: false
        if(isAirplaneMode) {
            Log.d("ff", "Airplane mode enabled")
        } else {
            Log.d("ff", "Airplane mode dissabled")
        }
    }
}