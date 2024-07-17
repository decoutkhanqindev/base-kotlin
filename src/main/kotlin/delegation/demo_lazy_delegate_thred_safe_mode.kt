package delegation

import kotlin.concurrent.thread
import kotlin.random.Random
class LazySample1 {
    init {
        println("created!")
    }

    //    LazyThreadSafetyMode.PUBLICATION
    private val lazy: Lazy<String> = lazy(LazyThreadSafetyMode.PUBLICATION) {
        println("computed!")
        "my lazy" + Random.nextInt()
    }

    val lazyStr: String by lazy // lazy.value
}

fun main() {
    val sample = LazySample1()
    val threads = List(100) {
        thread {
            repeat(100) {
                println(sample.lazyStr)
            }
        }
    }
    threads.forEach { it.join() }
    println("OK")
}
