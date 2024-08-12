package exercises.classes

import kotlin.math.PI

//  Write a Kotlin program that creates a class 'Circle' with properties for radius and center coordinates. Include a function to calculate the circle circumference.
class Circle(
    val radius: Double,
    val centerX: Double,
    val centerY: Double,
) {
    fun calculateCircumference(): Double {
        return 2 * PI * radius
    }
}

fun main() {
    val circle = Circle(7.0, 0.0, 0.0)
    println("Circle Circumference: ${circle.calculateCircumference()}")
}