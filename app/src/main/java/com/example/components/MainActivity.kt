package com.example.components

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.components.databinding.ActivityMainBinding

lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ff", "MainActivity: onCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val intent1 = Intent(this, MainActivity2::class.java)
            this.startActivity(intent1)
        }
        binding.button2.setOnClickListener {
            val intent1 = Intent(this, Contacts::class.java)
            this.startActivity(intent1)
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d("ff", "MainActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ff", "MainActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ff", "MainActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ff", "MainActivity: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ff", "MainActivity: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ff", "MainActivity: onDestroy")
    }
}