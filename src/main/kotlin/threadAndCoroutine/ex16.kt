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

fun main(): Unit = runBlocking {
    var counter: Int = 0

    val lock = Any()

    withContext(Dispatchers.Default) {
        repeat(1000) {
            launch {
                synchronized(lock) {
                    counter++
                }
            }
        }

        println("Current thread in coroutine=${currentCoroutineContext()}")
    }

    println("Counter=$counter Current thread in coroutine=${currentCoroutineContext()}")
}