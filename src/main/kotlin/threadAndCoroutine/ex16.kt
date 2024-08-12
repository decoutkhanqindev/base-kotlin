package threadAndCoroutine

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

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