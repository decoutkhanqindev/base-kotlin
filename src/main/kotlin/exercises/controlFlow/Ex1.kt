package exercises.controlFlow

// Viết một chương trình Kotlin để kiểm tra xem một số nhất định là dương, âm hay không.

fun main() {
    val num = 10
    if (num > 0) {
        println("Positive")
    } else if (num == 0) {
        println("zero")
    } else {
        println("Negative")
    }
}