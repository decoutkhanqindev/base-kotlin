package exercises.lambda

// Write an anonymous Kotlin function to find the average of the squares of a list of numbers.
fun main() {
    val sumOfSquares: (List<Int>) -> Double = {numbers -> ((numbers.sumOf { it * it }) / numbers.size).toDouble() }
    println(sumOfSquares(listOf(1, 2, 3, 4, 5, 6)))
}