package exercises.controlFlow

//  Viết một chương trình Kotlin để tính tổng của tất cả các số giữa hai số đã cho.

fun main() {
    val start = 15
    val end = 25

    val sum = calculateSum(start, end)
    println("Sum of numbers between $start and $end: $sum")
}

fun calculateSum(start: Int, end: Int): Int {
    var sum = 0
    for (i in start..end) {
        sum += i
    }
    return sum
}