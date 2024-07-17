package exercises.classes

// Write a Kotlin program that creates an object declaration 'MathConstants' that provides constants for mathematical calculations such as PI and E.
object MathConstants {
    const val PI = 3.14159
    const val E = 2.71828
}

fun main() {
    println("Value of PI: ${MathConstants.PI}")
    println("Value of E: ${MathConstants.E}")
}