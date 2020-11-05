package ru.profi.kmm.remoteconfig.shared

expect fun initConfig(
    platformSpec: PlatformSpec,
    minimumFetchIntervalInSeconds: Long
)

expect fun fetchAndActivate(callback: FetchCallback)