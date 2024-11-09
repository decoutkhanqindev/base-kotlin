package threadAndCoroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main(): Unit = runBlocking {
  val coroutineScope: CoroutineScope = CoroutineScope(context = Dispatchers.IO)
  val parentJob: Job = coroutineScope.coroutineContext.job
  println("parentJob=$parentJob")
  
  val job: Job = coroutineScope.launch {
    println("Start task ... ${currentCoroutineContext().job}")
    delay(2000)
    println("End task ... ${currentCoroutineContext().job}")
  }
  
  println("job=$job")
  
  println(
    "" +
        "isActive: ${job.isActive}, " +
        "isCompleted=${job.isCompleted}, " +
        "isCancelled=${job.isCancelled} " +
        "--- parent=${job.parent}"
  )
  
  delay(100)
  
  job.cancel()
  
  job.join()
  
  println(
    "" +
        "isActive: ${job.isActive}, " +
        "isCompleted=${job.isCompleted}, " +
        "isCancelled=${job.isCancelled} " +
        "--- parent=${job.parent}"
  )
  
  delay(3000)
}