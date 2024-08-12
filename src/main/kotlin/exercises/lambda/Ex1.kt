package exercises.lambda

//Write a Kotlin program that implements a lambda expression to multiply two numbers and return the result.
fun main() {
    val multiply: (Int, Int) -> Int = { x, y -> x * y }
    println(multiply(10, 10))
}