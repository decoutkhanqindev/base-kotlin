package exercises.classes

// Write a Kotlin program that creates a class 'Rectangle' with properties for width and height. Include a function to calculate the rectangle area.

class Rectangle(private val height: Double, private val width: Double) {
    fun area() = height * width
}

fun main() {
    val rectangle = Rectangle(7.0, 3.0)
    println(rectangle.area())
}