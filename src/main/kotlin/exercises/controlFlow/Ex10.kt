package exercises.controlFlow

//  Viết một chương trình Kotlin để tìm GCD (Ước chung lớn nhất) của hai số.

fun main() {
    val number1 = 28
    val number2 = 16

    val gcd = findGCD(number1, number2)

    println("GCD of $number1 and $number2: $gcd")
}

fun findGCD(number1: Int, number2: Int): Int {
    var num1 = number1
    var num2 = number2
    while (num2 != 0) {
        val temp = num2
        num2 = num1 % num2
        num1 = temp
    }
    return num1
}
