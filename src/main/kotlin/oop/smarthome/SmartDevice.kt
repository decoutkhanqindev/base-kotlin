package oop.smarthome

open class SmartDevice(val name: String, val category: String) {

//    var deviceStatus = "online"
//        protected set(value) {
//            field = value
//        }

    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "On"
    }

    open fun turnOff() {
        deviceStatus = "Off"
    }

    open fun printDeviceIn4() {
        println("Device name: $name, Category: $category, Type: $deviceType.")
    }
}