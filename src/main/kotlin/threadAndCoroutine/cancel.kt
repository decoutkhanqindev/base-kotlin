package threadAndCoroutine

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
  val job: Job = launch {
    repeat(1000) {
      println("Job is sleeping $it")
      delay(500L)
    }
  }
  
  delay(1300L) // delay main thread 1.3s
  
  println("main: I'm tired of waiting!")
  job.cancel() // cancel job
  job.join() // wait for job completed
  println("main: Now I can quit.")
}