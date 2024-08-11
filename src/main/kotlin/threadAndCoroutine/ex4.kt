package threadAndCoroutine

import kotlinx.coroutines.runBlocking

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

class SyncCounter {
    private var counter: Int = 0

    private val lock = Any()

    fun increment() {
        synchronized(lock) {
            counter++
        }
    }

    //    @Synchronized
    //    fun increment() = counter++

    fun count() {
        val thread1 = Thread {
            println("Current thread to increment counter: ${Thread.currentThread().name}")
            repeat(10000) {
                increment()
            }
        }

        val thread2 = Thread {
            println("Current thread to increment counter: ${Thread.currentThread().name}")
            repeat(10000) {
                increment()
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
    println("Current thread: ${Thread.currentThread().name}")

    // val nonSync = NonSync()
    // nonSync.count()
    // -> in ra cac counter khac nhau
    // <-> khi 1 thread dang write va 1 thread khac dang read
    // -> data race

    // handle data race -> mutex
    // -> trong 1 thoi diem thi chi co 1 thread duy nhat dc giu key
    // -> de thuc thi tac vu ma khong bi gian don voi bat ki thread nao -> atomic operation
    // -> sau khi thuc thi xong thi release lock de tra ky cho thread tiep theo
    // -> in ra counter khong thay doi
    val syncCounter = SyncCounter()
    syncCounter.count()

    // cyclic barrier
}