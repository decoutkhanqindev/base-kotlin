package threadAndCoroutine

class NonSync {
    // shared resource
    private var counter: Int = 0

    fun count() {
        val thread1 = Thread {
            repeat(10000) {
                counter++
            }
        }

        val thread2 = Thread {
            repeat(10000) {
                counter++
            }
        }

        thread1.start()
        thread2.start()

        thread1.join() // doi khi nao thread1 hoan thanh
        thread2.join() // doi khi nao thread2 hoan thanh

        println("Counter = $counter")
    }
}

fun main() {
    val nonSync = NonSync()
    nonSync.count()
    // -> in ra cac counter khac nhau
    // <-> khi 1 thread dang write va 1 thread khac dang read
    // -> data race
}