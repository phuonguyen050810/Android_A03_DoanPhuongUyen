package com.example.phoneapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    lateinit var call: Button
    lateinit var send: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        call = findViewById(R.id.call)
        send = findViewById(R.id.sendSMS)

        call.setOnClickListener {
            startActivity(Intent(this, CallActivity:: class.java))
        }

        send.setOnClickListener {
            startActivity(Intent(this, SendActivity:: class.java))
        }

    }

}