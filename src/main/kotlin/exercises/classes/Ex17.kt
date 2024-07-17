package exercises.classes

//  Write a Kotlin program that creates a data class 'Point' with properties for x and y coordinates. Use a destructuring declaration to extract the coordinates.
data class Point (val x: Double, val y: Double)

fun main() {
    val point = Point(12.0, 20.0)
    val (x, y) = point
    println("Coordinates: x = $x, y = $y")
}