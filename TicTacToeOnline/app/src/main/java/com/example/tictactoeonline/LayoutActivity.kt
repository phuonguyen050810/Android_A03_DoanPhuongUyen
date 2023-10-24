package com.example.tictactoeonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LayoutActivity : AppCompatActivity() {

    private lateinit var btnSize3: Button
    private lateinit var btnSize5: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        btnSize3 = findViewById(R.id.size3x3)
        btnSize5 = findViewById(R.id.size5x5)

        btnSize3.setOnClickListener {
            startActivity(Intent(this, GameActivity:: class.java))
        }
        btnSize5.setOnClickListener {
            startActivity(Intent(this, GameActivity2:: class.java))
        }
    }


}