package exercises.function

// Viết một hàm infix Kotlin để kiểm tra xem một số có chia hết cho một số khác hay không.

fun main() {
    val number1 = 15
    val number2 = 3

    println("$number1 is divisible by $number2: ${number1.isDivisibleBy(number2)}")
    println("$number2 is divisible by $number1: ${number2.isDivisibleBy(number1)}")
}

infix fun Int.isDivisibleBy(divisor: Int): Boolean {
    return this % divisor == 0
}