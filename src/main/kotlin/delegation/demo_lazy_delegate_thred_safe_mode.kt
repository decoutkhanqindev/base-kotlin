package delegation

import kotlin.concurrent.thread

class LazySample1 {
    init {
        println("created!")
    }

//    LazyThreadSafetyMode.PUBLICATION
    private val lazy: Lazy<String> = lazy(LazyThreadSafetyMode.PUBLICATION) {
        println("computed!")
        "my lazy"
    }

    val lazyStr: String by lazy // lazy.value
}

fun main() {
    val sample = LazySample1()
    val threads = List(1000) {
        thread {
            repeat(100) {
                println(sample.lazyStr)
            }
        }
    }
    threads.forEach() { it.join() }
    println("Thread is done!")
}
