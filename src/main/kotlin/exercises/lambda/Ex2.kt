package exercises.lambda

// Write a Kotlin program that implements a lambda expression to find the square of a number and return the result.

fun main() {
    val squareOf: (Int) -> Int = {number -> number * number}
    println(squareOf(2))
}