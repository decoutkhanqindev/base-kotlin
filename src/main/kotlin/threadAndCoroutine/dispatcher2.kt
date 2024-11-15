package threadAndCoroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
fun main(): Unit = runBlocking {
//  println(Runtime.getRuntime().availableProcessors()) // threads cua may ~ Dispatchers.Default
//
//  val scope: CoroutineScope = CoroutineScope(context = Dispatchers.Default)
//  // IO ~ 64 threads
//  // Default ~ 12 threads
//
//  // task
//  repeat(200) { it: Int ->
//    scope.launch {
//      println(">>>> i=$it, thread=${Thread.currentThread().name}")
//      Thread.sleep(500)
//      println("<<<< i=$it, thread=${Thread.currentThread().name}")
//    }
//  }
//
//  delay(20000)
//  println("Task is done")

  // dispatcher unconfined execute on current thread
  val singleThreadDispatcher: CoroutineDispatcher =
      newSingleThreadContext(name = "new single thread")
  val dispatcherThreadPool: ExecutorCoroutineDispatcher =
      Executors.newSingleThreadExecutor().asCoroutineDispatcher()

//    withContext(Dispatchers.IO) {
  withContext(Dispatchers.IO) {
    withContext(singleThreadDispatcher) {
      println("[1] thread=${Thread.currentThread().name}")
      delay(100)
    }
    
    println("[2] thread=${Thread.currentThread().name}")
    delay(100)
    
    withContext(dispatcherThreadPool) {
      println("[3] thread=${Thread.currentThread().name}")
      delay(100)
    }
    
    println("[4] thread=${Thread.currentThread().name}")
    delay(100)
    
    println("[5] thread=${Thread.currentThread().name}")
  }
  
  dispatcherThreadPool.close()
  
  // gioi han so theads chay trong IO
  val LimitIO3: CoroutineDispatcher = Dispatchers.IO.limitedParallelism(parallelism = 3)
  repeat(100) { it: Int ->
    CoroutineScope(LimitIO3).launch {
      println("START $it thread=${Thread.currentThread().name}")
      Thread.sleep(500)
      println("END $it thread=${Thread.currentThread().name}")
    }
  }

  delay(15_000)
}