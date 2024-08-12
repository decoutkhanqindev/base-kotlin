package threadAndCoroutine

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job = launch {
        repeat(1000) {
            println("Job is sleeping $it")
            delay(500L)
        }
    }

    delay(1300L) // delay main thread 1.3s

    println("main: I'm tired of waiting!")
    job.cancel() // cancel job
}