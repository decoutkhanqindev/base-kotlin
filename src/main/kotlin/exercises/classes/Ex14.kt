package exercises.classes

//  Write a Kotlin program that creates a class 'MathUtils' with static functions to calculate the factorial, square root, and cube root of a number.

class MathUtils {
    companion object {
        fun factorial(num: Int): Int {
            if (num == 0 || num == 1) return 1
            var res = 0
            for (i in 0..num) res *= i
            return res
        }
    }
}

fun sqrt(n: Double): Double {
    return kotlin.math.sqrt(n)
}

fun cbrt(n: Double): Double {
    return Math.cbrt(n)
}

fun main() {
    val number = 7

    val factorial = MathUtils.factorial(number)
    println("Factorial of $number is: $factorial")

    val squareRoot = sqrt(number.toDouble())
    println("Square root of $number is: $squareRoot")

    val cubeRoot = cbrt(number.toDouble())
    println("Cube root of $number is: $cubeRoot")
}