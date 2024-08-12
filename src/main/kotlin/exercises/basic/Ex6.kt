package exercises.basic

fun main(args: Array<String>) {
    val num = readLine()!!.toInt()
    if (num % 2 == 0) {
        println("$num is an odd number")
    } else {
        println("$num is an even number")
    }
}