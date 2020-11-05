package ru.profi.kmm.remoteconfig.shared

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

actual fun initConfig(platformSpec: PlatformSpec, minimumFetchIntervalInSeconds: Long) {

    if (platformSpec !is AndroidSpec) return

    FirebaseApp.initializeApp(platformSpec.context)

    val config = Firebase.remoteConfig
    val configSettings = remoteConfigSettings {
        this.minimumFetchIntervalInSeconds = minimumFetchIntervalInSeconds
    }
    config.setConfigSettingsAsync(configSettings)
}

actual fun fetchAndActivate(callback: FetchCallback) {
    println(">>> fetch")
    val config = Firebase.remoteConfig
    config.fetchAndActivate().addOnCompleteListener { task ->
        if (task.isSuccessful) {
            println(">>> fetch success")
            callback.onSuccess()
        } else {
            println(">>> fetch error")
            callback.onError()
        }
    }
}