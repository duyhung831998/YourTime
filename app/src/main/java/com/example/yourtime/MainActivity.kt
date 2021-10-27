package com.example.yourtime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent1 = Intent(this, CountDown::class.java)
        val intent2 = Intent(this, StopWatch::class.java)
        btnCountDown.setOnClickListener {
            startActivity(intent1)
        }
        btnStopWatch.setOnClickListener {
            startActivity(intent2)
        }
    }
}