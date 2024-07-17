package exercises.lambda

//  Write a Kotlin program that implements a lambda expression to calculate the average of a list of numbers.

fun main() {
    val avgOf: (List<Int>) -> Int = {numbers -> numbers.sum() / numbers.size}
    println(avgOf(listOf(1, 2, 3, 4, 10)))
}