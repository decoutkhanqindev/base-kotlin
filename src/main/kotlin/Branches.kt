@Suppress("VARIABLE_WITH_REDUNDANT_INITIALIZER")
fun main() {
    // if else
    var a = 5
    val b = 6
    var max1 = if (a > b) a else b // a > b ? a : b
    println("$max1")
    max1 = if (a > b) a else if (a < b) b else a
    println("$max1")

    a = 7
    var max2 = 0
    if (a > b)
        max2 = a
    else
        max2 = b
    println("$max2")

    var max3 = 0
    if (a > b)
        max3 = a
    else if (a < b)
        max3 = b
    else
        println("a = b")
    println("$max3")

    // switch case = when
    var s = "hello"
    var check = 1
    var result = ""
    when (check) {
        1 -> result = s.uppercase()
        2, 3, 4 -> result = s.lowercase()
        in 4..10 -> result = "world"
        else -> result = s
    }
    println("$result")

    s = "minh"
    check = 2
    when {
        check == 1 -> result = s.uppercase()
        check in 2..4 -> result = s.lowercase()
        else -> result = s
    }
    println("$result")

    result = when {
        check == 1 -> s.uppercase()
        check in 2..4 -> s.lowercase()
        else -> s
    }
    println("$result")
}