package threadAndCoroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

fun main(): Unit = runBlocking {
    var counter: Int = 0

//    val lock = Any()

    val mutex = Mutex()
    withContext(Dispatchers.Default) {
        repeat(1000) {
            launch {
//                synchronized(lock) {
//                    counter++
//                }

//                mutex.lock() // truoc khi truy cap thi lock
//                counter++
//                mutex.unlock() // sau khi truy cap thi unlock

                mutex.withLock {
                    counter++
                }
            }
        }

        println("Current thread in coroutine=${currentCoroutineContext()}")
    }

    println("Counter=$counter Current thread in coroutine=${currentCoroutineContext()}")
}