@file:Suppress("UNUSED_CHANGED_VALUE")

fun main() {
    var x = 3
    var y = 10

    // + - *  / % ++ -- giong nhu java
    println("x + y = ${x + y}")
    println("x - y = ${x - y}")
    println("x * y = ${x * y}")
    println("x / y = ${x / y}")
    println("x % y = ${x % y}")
    println("++x = ${++x}")
    println("--y = ${--y}")
    println("x++ = ${x++}")
    println("y-- = ${y--}")

    //= += -= *= /=
    x += 1
    y *= 2
    println("$x $y")

    //> < >= <= == !=
    val m = "h"
    val n = "i"
    println("${m == n}")
    println("${m < n}")

    //as is !is
    var o: Any
    o = m
    o.uppercase()
    println("${m is String}")
    println("${m !is String}")

    // || && !
    println("${x > 5 && y < 10}")

    // toan tu bit
    //& ! ^ ~ << >> >>>
    // and or xor .inv() shl shr ushr
}