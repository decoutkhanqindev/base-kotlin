package threadAndCoroutine

import kotlinx.coroutines.CancellationException
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
        repeat(5) {
            try {
                println("Job is sleeping $it")
                delay(500L)
            } catch (cancel: CancellationException) {
                throw cancel
            }
        }
    }

    delay(1300L) // delay main thread 1.3s

    println("main: I'm tired of waiting!")
    job.cancel() // cancel job
    job.join() // wait for job completed
    println("main: Now I can quit.")
}