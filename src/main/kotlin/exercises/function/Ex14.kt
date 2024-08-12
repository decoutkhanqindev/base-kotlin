package exercises.function

// Viết một hàm biểu thức đơn Kotlin lấy một số làm đối số và trả về true nếu nó là âm, sai nếu không.

fun main() {
    val num1 = -14
    val num2 = 20

    println("$num1 is positive: ${isPositive(num1)}")
    println("$num2 is positive: ${isPositive(num2)}")
}

fun isPositive(number: Int): Boolean {
    return number > 0
}