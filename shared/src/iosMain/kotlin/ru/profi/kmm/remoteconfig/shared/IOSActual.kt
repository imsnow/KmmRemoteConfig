package ru.profi.kmm.remoteconfig.shared

actual fun initConfig(platformSpec: PlatformSpec, minimumFetchIntervalInSeconds: Long) {

    if (platformSpec !is IOSSpec) return


}

actual fun fetchAndActivate(callback: FetchCallback) {

}