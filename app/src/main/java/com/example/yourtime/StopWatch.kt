package com.example.yourtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import kotlinx.android.synthetic.main.activity_stop_watch.*

class StopWatch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop_watch)
        var stoptime:Long=0
        btnStart.setOnClickListener {
            time.base= SystemClock.elapsedRealtime()+stoptime
            time.start()
            btnStart.visibility= View.GONE
            btnPause.visibility= View.VISIBLE
        }
        btnPause.setOnClickListener {
            stoptime=time.base- SystemClock.elapsedRealtime()
            time.stop()
            btnPause.visibility= View.GONE
            btnStart.visibility= View.VISIBLE
        }
        btnReset.setOnClickListener {
            time.base= SystemClock.elapsedRealtime()
            stoptime=0
            time.stop()
            btnPause.visibility= View.GONE
            btnStart.visibility= View.VISIBLE
        }
        btnBack.setOnClickListener {
            finish()
        }
    }
}