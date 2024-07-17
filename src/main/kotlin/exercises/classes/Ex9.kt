package exercises.classes

// Write a Kotlin program that creates a class 'Triangle' with side length properties. Include a function to calculate the triangle perimeter.
class Triangle(val side1: Double, val side2: Double, val side3: Double) {
    fun perimeter() =  side1 + side2 + side3
}

fun main() {
    val triangle = Triangle(5.0, 6.0, 7.0)
    println(triangle.perimeter())
}