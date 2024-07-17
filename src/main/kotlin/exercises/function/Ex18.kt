package exercises.function

import java.lang.Double.sum

//  Viết một hàm Kotlin lấy một số đối số thay đổi (varargs) và tính trung bình của các số đó.

fun main() {
    val average1 = calculateAvg(1.0, 2.0, 6.0)
    println("Average 1: $average1")

    val average2 = calculateAvg(-10.0, -20.0, 30.0, 40.0, 50.0)
    println("Average 2: $average2")
}

fun calculateAvg(vararg numbers: Double) : Double {
    return numbers.sum() / numbers.size
}