package oop.smarthome

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class RangeRegular(initialValue: Int, private val minValue: Int, private val maxValue: Int) :
    ReadWriteProperty<Any?, Int> {

    private var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue .. maxValue) {
            fieldData = value
        }
    }
}