package delegation

class LazySample1 {
    init {
        println("created!")
    }

    private val lazy: Lazy<String> = lazy {
        println("computed!")
        "my lazy"
    }

    val lazyStr: String by lazy
}

fun main() {
    val sample = LazySample()
    println(sample.lazyStr)
    println(sample.lazyStr)
    println(sample.lazyStr)
    println(sample.lazyStr)
}
