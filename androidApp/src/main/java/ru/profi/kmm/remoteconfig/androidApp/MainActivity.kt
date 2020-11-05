package ru.profi.kmm.remoteconfig.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.profi.kmm.remoteconfig.shared.Greeting
import android.widget.TextView
import ru.profi.kmm.remoteconfig.shared.AndroidSpec
import ru.profi.kmm.remoteconfig.shared.FetchCallback
import ru.profi.kmm.remoteconfig.shared.KMMRemoteConfig

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kmmRemoteConfig = KMMRemoteConfig {
            platformSpec = AndroidSpec(this@MainActivity.applicationContext)
            minimumFetchIntervalInSeconds = 4000
        }

        kmmRemoteConfig.fetch(object : FetchCallback {
            override fun onSuccess() {
                TODO("Not yet implemented")
            }

            override fun onError() {
                TODO("Not yet implemented")
            }
        })

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
    }
}
