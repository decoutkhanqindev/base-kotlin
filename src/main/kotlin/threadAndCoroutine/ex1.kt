package threadAndCoroutine

class MyThread : Thread() {
    override fun run() {
        for (i in 0..10) {
            println("Thread is running $i, in thread: ${Thread.currentThread().name}")
            Thread.sleep(1000)
        }
    }
}

class MyRunnable : Runnable {
    override fun run() {
        for (i in 0..10) {
            println("Runnable is running $i, in thread: ${Thread.currentThread().name}")
            Thread.sleep(1000)
        }
    }

}

fun main() {
//    val myThread = MyThread()
//    myThread.start()

    val  myThread = Thread(MyRunnable())
    myThread.start()
}