package exercises.lambda

// Write a Kotlin program that implements a lambda expression to check if a number is even.
fun main() {
    val isEvan: (Int) -> Boolean = {number -> number % 2 == 0}
    println(isEvan(90))
}