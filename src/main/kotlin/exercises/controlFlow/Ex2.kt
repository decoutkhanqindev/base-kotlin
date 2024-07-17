package exercises.controlFlow

// Viết một chương trình Kotlin để kiểm tra xem một số đã cho có chia hết cho 7 hay không.

fun main() {
    val num = 70
    if (num % 7 == 0) {
        println("The number is divisible by 7.")
    } else {
        println("The number is not divisible by 7.")
    }
}