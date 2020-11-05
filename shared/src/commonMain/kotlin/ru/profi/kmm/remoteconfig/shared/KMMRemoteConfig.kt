package ru.profi.kmm.remoteconfig.shared

class KMMRemoteConfig(builder: Builder.() -> Unit) {
    init {
        with(Builder().apply(builder)) {
            initConfig(
                platformSpec,
                minimumFetchIntervalInSeconds
            )
        }
    }

    fun fetch(callback: FetchCallback) {
        fetchAndActivate(callback)
    }

    class Builder {

        lateinit var platformSpec: PlatformSpec
        var minimumFetchIntervalInSeconds: Long = 3600
    }
}