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

class CallActivity : AppCompatActivity() {

    private lateinit var phoneNumber: EditText
    private lateinit var call: Button
    private lateinit var back: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)

        phoneNumber = findViewById(R.id.phoneNumber)
        call = findViewById(R.id.call)
        back = findViewById(R.id.back)

        checkPermissions()

        call.setOnClickListener {
            val phoneNumber = phoneNumber.text.toString()
            if(phoneNumber.isNotEmpty()){
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:$phoneNumber")
                startActivity(callIntent)
            }
        }
        back.setOnClickListener {
            startActivity(Intent(this, MainActivity:: class.java))
        }
    }

    private fun checkPermissions(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 101)
        }
    }
}