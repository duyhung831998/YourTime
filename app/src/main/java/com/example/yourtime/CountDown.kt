package com.example.yourtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import kotlinx.android.synthetic.main.activity_count_down.*

class CountDown : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)
        var stoptime : Long=0
        var st:String?=null
        var st1:String?=null
        var st2:String?=null
        var resettime :  Long =0
        choose.setOnClickListener {
            if(ct.text.toString().equals("") && ct1.text.toString().equals("") && ct2.text.toString().equals("")){
                stoptime=0
                resettime=stoptime
            }
            else if(ct.text.toString().equals("") && ct1.text.toString().equals("")){
                st2=ct2.text.toString()
                stoptime=st2!!.toLong()*1000
                resettime=stoptime
            }
            else if(ct1.text.toString().equals("") && ct2.text.toString().equals("")){
                st=ct.text.toString()
                stoptime=st!!.toLong()*3600*1000
                resettime=stoptime
            }
            else if(ct.text.toString().equals("") && ct2.text.toString().equals("")){
                st1=ct1.text.toString()
                stoptime=st1!!.toLong()*60*1000
                resettime=stoptime
            }
            else if(ct.text.toString().equals("")){
                st1=ct1.text.toString()
                st2=ct2.text.toString()
                stoptime=st1!!.toLong()*60*1000+st2!!.toLong()*1000
                resettime=stoptime
            }
            else if(ct1.text.toString().equals("")){
                st=ct.text.toString()
                st2=ct2.text.toString()
                stoptime=st!!.toLong()*3600*1000+st2!!.toLong()*1000
                resettime=stoptime
            }
            else if(ct2.text.toString().equals("")){
                st=ct.text.toString()
                st1=ct1.text.toString()
                stoptime=st!!.toLong()*3600*1000+st1!!.toLong()*60*1000
                resettime=stoptime
            }
            else {
                st=ct.text.toString()
                st1=ct1.text.toString()
                st2=ct2.text.toString()
                stoptime=st!!.toLong()*3600*1000+st1!!.toLong()*60*1000+st2!!.toLong()*1000
                resettime=stoptime
            }
            time1.base= SystemClock.elapsedRealtime() + stoptime
        }
        btStart.setOnClickListener {
            time1.base= SystemClock.elapsedRealtime() + stoptime
            time1.start()
            btStart.visibility= View.GONE
            btPause.visibility= View.VISIBLE
        }
        btPause.setOnClickListener {
            stoptime=time1.base- SystemClock.elapsedRealtime()
            time1.stop()
            btPause.visibility= View.GONE
            btStart.visibility= View.VISIBLE
        }
        btReset.setOnClickListener {
            stoptime=resettime
            time1.base= SystemClock.elapsedRealtime() + stoptime
            time1.stop()
            btPause.visibility= View.GONE
            btStart.visibility= View.VISIBLE
        }
        btBack.setOnClickListener {
            finish()
        }
    }
}