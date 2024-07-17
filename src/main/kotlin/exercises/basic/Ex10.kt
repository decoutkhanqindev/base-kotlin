package exercises.basic

import kotlin.math.PI

// Viết một chương trình Kotlin để tính diện tích và chu vi của một vòng tròn.

fun main() {
    val radius = readLine()!!.toDouble()
    println("Radius = $radius")
    val formattedArea = String.format("%.2f", calculatorArea(radius))
    val formattedPerimeter = String.format("%.2f", calculatePerimeter(radius))

    println("Area of radius = $formattedArea")
    println("Perimeter of radius = $formattedPerimeter")
}

fun calculatePerimeter(radius: Double): Double {
    return 2 * PI * radius
}

fun calculatorArea(radius: Double): Double {
    return PI * radius * radius
}
