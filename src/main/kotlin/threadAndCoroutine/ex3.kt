package threadAndCoroutine

fun fetchData1(): Int {
    Thread.sleep(1000)
    return 1
}

fun fetchData2(value: Int): Int {
    Thread.sleep(1000)
    return 1 + value
}

fun renderItem(value: Int) {
    println("Render item $value")
}

fun main() {
    println("Current thread: ${Thread.currentThread().name}")

    // chay tren main thread
//    val fetchData1 = fetchData1()
//    val fetchData2 = fetchData2(fetchData1)
//    renderItem(fetchData2)

    // chuyen sang chay tren thread khac
    Thread {
        println("Current thread to handle fetch data: ${Thread.currentThread().name}") // -> thread-0
        val fetchData1 = fetchData1()
        val fetchData2 = fetchData2(fetchData1)
        renderItem(fetchData2)
    }.start()

    println("Main thread is done")
}