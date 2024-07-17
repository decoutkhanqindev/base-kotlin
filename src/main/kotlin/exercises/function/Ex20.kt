package exercises.function

// Viết một hàm Kotlin bên trong một hàm khác để tính bình phương của một số.

fun calculatePower(number: Int): Int {
    return number * number
}

fun main() {
    val number = 7
    val square = calculatePower(number)
    println("Square of $number: $square")
}