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

class SendActivity : AppCompatActivity() {

    private lateinit var phoneNumber: EditText
    private lateinit var send: Button
    private lateinit var back: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)

        phoneNumber = findViewById(R.id.phoneNumber)
        send = findViewById(R.id.sendSMS)
        back = findViewById(R.id.back)

        checkPermission()

        send.setOnClickListener {
            val phoneNumber = phoneNumber.text.toString()
            if(phoneNumber.isNotEmpty()){
                val smsIntent = Intent(Intent.ACTION_VIEW)
                smsIntent.data = Uri.parse("sms:$phoneNumber")
                startActivity(smsIntent)
            }
        }

        back.setOnClickListener {
            startActivity(Intent(this, MainActivity:: class.java))
        }
    }
    private fun checkPermission(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), 101)
        }
    }
}