package com.example.applicationfortestbroadcast

import android.content.ComponentName
import android.content.Intent
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSendBroadcast = findViewById<Button>(R.id.buttonSendBroadcast)

        buttonSendBroadcast.setOnClickListener {
            val broadcastIntent = Intent()
            broadcastIntent.action = "com.example.applicationfortestbroadcast.BROADCAST"
            broadcastIntent.putExtra("CITY_NAME", "London")

            val packageManager = packageManager
            val infos: List<ResolveInfo> = packageManager.queryBroadcastReceivers(broadcastIntent, 0)

            for(info in infos) {
                val componentName = ComponentName(info.activityInfo.packageName, info.activityInfo.name)
                broadcastIntent.component = componentName
                sendBroadcast(broadcastIntent)
            }
        }
    }
}