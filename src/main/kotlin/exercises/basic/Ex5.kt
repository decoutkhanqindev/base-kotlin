package exercises.basic

// Viết một chương trình Kotlin để thực hiện cộng, trừ, nhân và chia hai số.

fun main(args: Array<String>) {
    print("Enter num1: ")
    val num1 = readLine()!!.toDouble()
    print("Enter num1: ")
    val num2 = readLine()!!.toDouble()

    val sum = num1 + num2
    val difference = num1 - num2
    val product = num1 * num2
    val quotient = num1 / num2

    println("$num1 + $num2 = $sum")
    println("$num1 - $num2 = $difference")
    println("$num1 * $num2 = $product")
    println("$num1 / $num2 = $quotient")
}