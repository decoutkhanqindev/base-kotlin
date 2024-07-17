package exercises.lambda

// Write a Kotlin program that implements a lambda expression to sort a list of integers in descending order.

fun main() {
    val numbers = listOf(10, 2, 7, 4, 1, 5, 8, 9, 3, 6)
    val sortedList: (List<Int>) -> List<Int> = {numbers.sortedByDescending { it }}
    println(sortedList(numbers))
}