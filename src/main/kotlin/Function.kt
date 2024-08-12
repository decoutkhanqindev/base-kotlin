fun main() {
    println(sum1(1, 2, 3))
    sum2(2, 2, 3)
    sum2(a = 1, b = 3, c = 3)
    println(sum3(100))
    println(sum4())
    println(sum5())

    val list = listOf(1, 2, 3)
    list.forEach { print("$it ") }

    println()

    // lamda
    list.forEach(fun(v: Int) {
        print("$v ")
    })

    println()

    list.forEach { v: Int ->
        print("$v ")
    }

    println()

    list.forEach { printElement() }

    val a = A()
    a.print1("Minh")
    a print2 "Khang"

    val v = 50
    doMore(v)
}

// kieu tra ve
fun sum1(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

// khong tra ve = void
fun sum2(a: Int, b: Int, c: Int) {
    println("${a + b + c}")
}

// ham co the dat gia tri mac dinh
fun sum3(a: Int, b: Int = 20, c: Int = 30): Int {
    return a + b + c
}

fun sum4(a: Int = 10, b: Int = 20, c: Int = 30): Int = a + b + c

// ham co the tra ve 2 gia tri
fun sum5(a: Int = 10, b: Int = 20, c: Int = 30): Pair<Int, String> {
    return Pair(a + b + c, "abc")
}

// lambda func
private fun printElement() = fun(v: Int) {
    print("$v ")
}

class A {
    fun print1(s: String) {
        println(s)
    }

    infix fun print2(s: String) {
        println(s)
    }
}

// ham mo rong
fun doMore(v: Int) {
    println("doMore $v")
}