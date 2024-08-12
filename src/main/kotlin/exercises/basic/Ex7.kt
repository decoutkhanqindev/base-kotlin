package exercises.basic

fun main(args: Array<String>) {
    val num1 = 10
    val num2 = 90
    val num3 = 20
    val minNum = minOf(num1, num2, num3)
    val maxNum = maxOf(num1, num2, num3)
    println("min is $minNum")
    println("max is $maxNum")
}