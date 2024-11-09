package threadAndCoroutine

fun main() {
    val thread1 = Thread {
        println("Thread 1 is running")
    }

    val thread2 = Thread {
        println("Thread 2 is running")
    }

    thread1.start()
    thread2.start()
}