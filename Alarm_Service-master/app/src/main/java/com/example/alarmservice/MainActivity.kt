package com.example.alarmservice

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.core.util.rangeTo
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var now = Calendar.getInstance()
        time_picker.setOnTimeChangedListener { timePicker, hourOfDay, minute ->
           now.set(Calendar.HOUR_OF_DAY,hourOfDay)
           now.set(Calendar.MINUTE,minute)
        }
        btn_timer.setOnClickListener {
            setAlarm(5,now)
        }
    }

    private fun setAlarm(number: Int, now: Calendar) {
        val date = SimpleDateFormat("HH:mm:ss")
        val text_timer = StringBuilder()
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(this,MyAlarmReciever::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
        alarmManager.set(AlarmManager.RTC_WAKEUP,now.timeInMillis,pendingIntent)
            text_timer.append(date.format(now.timeInMillis)).append("\n")
        txt_timer.text = text_timer
        Toast.makeText(this, "Будильник включен", Toast.LENGTH_LONG).show()

    }
}

class MyAlarmReciever : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText(p0!!, "Будильник сработал", Toast.LENGTH_LONG).show()
    }
}
