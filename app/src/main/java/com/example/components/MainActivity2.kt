package com.example.components

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.components.databinding.ActivityMain2Binding
import com.example.components.databinding.ActivityMainBinding
import com.example.components.recievers.SomeBroadcastReceiver
import com.example.components.sevices.CountService

lateinit var binding2 : ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var receiver: SomeBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityMain2Binding.inflate(layoutInflater)
        Log.d("ff", "SecondActivity: onCreate")
        setContentView(binding2.root)
        receiver = SomeBroadcastReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }

        binding2.buttonStartService.setOnClickListener {
            this.startService(Intent(this, CountService::class.java))
        }

    }


    override fun onStart() {
        super.onStart()
        Log.d("ff", "SecondActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ff", "SecondActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ff", "SecondActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ff", "SecondActivity: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ff", "SecondActivity: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
        Log.d("ff", "SecondActivity: onDestroy")
    }
}