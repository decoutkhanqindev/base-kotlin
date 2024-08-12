package delegation

interface Base {
    fun printVal()
}

class BaseImpl(private val x: Int) : Base {
    override fun printVal() {
        println("Value: $x")
    }
}

class OtherBaseImpl(private val x: Int) : Base {
    override fun printVal() {
        println("Other value: $x")
    }

}

class Derived(b: Base) : Base by b

fun main() {
    val b = BaseImpl(19)
    Derived(b).printVal()

    val b1 = OtherBaseImpl(100)
    Derived(b1).printVal()
}