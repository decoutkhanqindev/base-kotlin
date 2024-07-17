package exercises.controlFlow

// Viết một chương trình Kotlin để tạo bảng cửu chương của một số nhất định.

fun main() {
    val number = 7

    println("Multiplication table of $number:")
    generateMultiplicationTable(number)
}

fun generateMultiplicationTable(number: Int) {
    var res = 0
    for (i in 1 .. 10){
        res = number * i
        println("$number * $i = $res")
    }
}