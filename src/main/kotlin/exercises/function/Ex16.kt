package exercises.function

//Viết một hàm Kotlin lấy hai số làm đối số và trả về tổng của chúng. Chỉ định rõ ràng loại trả lại.

fun calculateSum(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun main() {
    val sum = calculateSum(7, 9)
    println("Sum: $sum")
}