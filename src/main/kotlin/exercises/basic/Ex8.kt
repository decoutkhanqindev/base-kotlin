package exercises.basic

// Viết một chương trình Kotlin để tìm giai thừa của một số nhất định.

fun main(args: Array<String>) {
    val num = readLine()!!.toInt()
    val factorial = calculatorFactorial(num)
    println("Factorial of $num: $factorial")
}

fun calculatorFactorial(num: Int): Int {
    return if (num == 0 || num == 1) {
        1
    } else {
        var result = 1
        for (i in 2..num) result *= i
        result
    }
}
