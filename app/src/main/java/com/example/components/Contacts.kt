package com.example.components

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.core.app.ActivityCompat
import com.example.components.databinding.ActivityContactsBinding
import java.util.jar.Manifest

class Contacts : AppCompatActivity() {
    lateinit var binding3: ActivityContactsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding3 = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding3.root)
        val list = mutableListOf<String>()
        checkPermission(activity = this, this) {
            this.let { getContacts(this).let {
                list.addAll(it)
            } }
        }
        Log.d("ff", "Contact size = ${list.size}")
    }
    fun checkPermission(activity: Activity, context: Context, success: () -> Unit) {
        if(ActivityCompat.checkSelfPermission(context, android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            activity.let {
                ActivityCompat.requestPermissions(it, arrayOf(android.Manifest.permission.READ_CONTACTS), 1)
            }
        } else {
            success()
        }
    }

    fun getContacts(activity: Activity) : List<String> {
        val list: MutableList<String> = ArrayList()
        val projection = arrayOf(ContactsContract.Data.DISPLAY_NAME_PRIMARY)
        val cursor = activity.contentResolver.query(
            ContactsContract.Data.CONTENT_URI,
            projection,
            null,
            null,
            null,
        )
        if(cursor != null && cursor.moveToFirst()) {
            for(j in 0 until cursor.count) {
                for(i in 0 until cursor.columnCount) {
                    list.add(cursor.getString(i))
                    cursor.moveToNext()
                }
            }
            cursor.close()
        }
        return list.toList()
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
        Log.d("ff", "SecondActivity: onDestroy")
    }
}