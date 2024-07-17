package exercises.controlFlow

// Viết một chương trình Kotlin để in chuỗi Fibonacci lên đến một số nhất định.

fun main() {
    val n = 30

    println("Fibonacci series up to $n:")
    printFibonacciSeries(n)
}

fun printFibonacciSeries(n: Int) {
    var num0 = 0
    var num1 = 1
    print("$num0, $num1")

    while (num1 <= n) {
        val nextNum = num0 + num1

        if (nextNum <= n) {
            print(", $nextNum")
        }

        num0 = num1
        num1 = nextNum
    }
}