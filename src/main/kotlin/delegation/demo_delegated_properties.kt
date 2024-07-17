package delegation

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private class Example {
    val getter get() = System.currentTimeMillis()
    val backingField = System.currentTimeMillis()

    val delegateReadOnlyProperty by DelegateReadOnlyProperty()
    var delegateReadWriteProperty by DelegateReadWriteProperty()
}

private class DelegateReadOnlyProperty: ReadOnlyProperty<Example, Any> {
    override fun getValue(thisRef: Example, property: KProperty<*>): Any {
        println("getValue() thisRef=$thisRef, property=${property.name}")
        return System.currentTimeMillis()
    }
}

private class DelegateReadWriteProperty: ReadWriteProperty<Example, Any> {
    var internalValue: Any = 10L
    override fun getValue(thisRef: Example, property: KProperty<*>): Any {
        println("getValue() thisRef=$thisRef, property=${property.name}")
        return internalValue
    }

    override fun setValue(thisRef: Example, property: KProperty<*>, value: Any) {
        println("setValue() thisRef=$thisRef, property=${property.name}")
        internalValue = value
    }

}

fun main() {
    val exp = Example()
    println(exp.delegateReadOnlyProperty)
    println(exp.delegateReadWriteProperty)
    exp.delegateReadWriteProperty = 109
    println(exp.delegateReadWriteProperty)
}