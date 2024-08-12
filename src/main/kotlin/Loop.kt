fun main() {
    val list = listOf(1, 2, 3, 4, 5)
    println("--for--")
    for (i in 0..list.size) {
        print("${list[i]} ")
    }
    println("\n------")
    for (i in 0 until list.size) {
        print("${list[i]} ")
    }
    println("\n------")
    for (i in (list.size - 1) downTo 0) {
        print("${list[i]} ")
    }
    println("\n------")
    for (i in 0 until list.size step 2) {
        print("${list[i]} ")
    }
    println("\n------")
    for (i in (list.size - 1) downTo 0 step 2) {
        print("${list[i]} ")
    }

    println("\n--foreach--")
    for (element in list) {
        print("$element ")
    }
    println("\n------")
    list.forEach {
        print("$it ")
    }

    println("\n--break--")
    for (i in 0 until list.size) {
        if (i == 3) break
        print("${list[i]} ")
    }

    println("\n--continue--")
    for (i in 0 until list.size) {
        if (i == 3) continue
        print("${list[i]} ")
    }

    println("\n--while--")
    var i = 0
    while (i < list.size) {
        print("${list[i]} ")
        i++
    }

    println("\n--do while--")
    i = 0
    do {
        print("${list[i]} ")
        i++
    } while (i < list.size)

    println("\n--while true--")
    i = 0
    while (true) {
        print("${list[i]} ")
        i++
        if (i >= list.size) break
    }
}