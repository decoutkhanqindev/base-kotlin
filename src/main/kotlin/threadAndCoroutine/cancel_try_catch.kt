package threadAndCoroutine

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.IOException

fun main(): Unit = runBlocking {
  val job: Job = launch {
    repeat(5) {
      try {
        println("Job is sleeping $it")
        delay(500L)
        // All suspend functions will check a Job is active or not, if Job active -> execute otherwise not execute
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

// in android
private fun fetchRemoteData() {
  CoroutineScope(Dispatchers.IO).launch {
    try {
      val response: String = callApi()
      delay(1000)
      println("callApi: $response")
      // handle result
    } catch (cancel: CancellationException) {
      throw cancel
      // CancellationException is used to indicate that the coroutine is being cancelled.
      // Cancellation is cooperative, meaning coroutines check for cancellation and stop their work gracefully.
      // + not rethrow it, the coroutine might not terminate properly, leading to unexpected behavior
      // -> propagation of coroutine cancellation.
      // + rethrowing the CancellationException, you allow the coroutine to terminate correctly.
      // -> Without rethrowing, the coroutine might continue running (despite the cancellation), leading to
      // resource leaks or inconsistent states.
    } catch (e: IOException) {
      // show error in UI
    }
  }
}

suspend fun callApi(): String {
  delay(2000L)
  return "Hello World"
}

