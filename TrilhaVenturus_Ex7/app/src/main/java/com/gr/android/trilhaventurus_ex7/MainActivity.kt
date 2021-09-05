package com.gr.android.trilhaventurus_ex7

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = "MY_CHANNEL"
            val channelDesc = "Here is why I do have this notification: I WANT IT"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(5533.toString(), channelName, importance).apply {
                description = channelDesc
            }

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }

        val builder = NotificationCompat.Builder(this, "5533")
            .setSmallIcon(R.drawable.ic_baseline_anchor_24)
            .setContentTitle("Hi, you've got a notification!")
            .setContentText("Here is your AWESOME notification")
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        val btn = findViewById<Button>(R.id.btn_mine)
        btn.setOnClickListener {
            NotificationManagerCompat.from(this).notify(123, builder.build())
        }
    }
}
