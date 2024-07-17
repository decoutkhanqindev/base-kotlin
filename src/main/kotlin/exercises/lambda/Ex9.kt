package exercises.lambda

//  Write an anonymous Kotlin function to calculate the factorial of a number.

fun main() {
    val number = 5

    fun factorial(n: Int): Int {
        return if (n <= 1) {
            1
        } else {
            n * factorial(n - 1)
        }
    }

    val result = factorial(number)
    println("Factorial of $number is $result")
}