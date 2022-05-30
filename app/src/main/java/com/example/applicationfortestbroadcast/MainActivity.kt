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
            val intent = Intent()
            intent.action = "com.example.applicationfortestbroadcast.BROADCAST"

            val packageManager = packageManager
            val infos: List<ResolveInfo> = packageManager.queryBroadcastReceivers(intent, 0)

            for(info in infos) {
                val componentName = ComponentName(info.activityInfo.packageName, info.activityInfo.name)
                intent.component = componentName
                sendBroadcast(intent)
            }
        }
    }
}