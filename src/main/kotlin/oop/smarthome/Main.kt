package oop.smarthome

fun main() {
    val smartTvDevice = SmartTvDevice("Android TV", "Entertainment")
    val smartLightDevice = SmartLightDevice("Google Light", "Utility")
    val smartHome = SmartHome(smartTvDevice, smartLightDevice)

    smartHome.turnOnLight()
    smartHome.printSmartLightInfo()
    smartHome.increaseLightBrightness()
    smartHome.decreaseLightBrightness()

    smartHome.turnOnTv()
    smartHome.printSmartTvInfo()
    smartHome.increaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToPrevious()

    smartHome.turnOffTv()
    smartHome.turnOffLight()
}