package threadAndCoroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

fun main(): Unit = runBlocking {
  val dispatcherIO: CoroutineDispatcher = Dispatchers.IO
  val dispatcherDefault: CoroutineDispatcher = Dispatchers.Default
  val dispatcherMain: CoroutineDispatcher = Dispatchers.Main // for GUI
  val dispatcherMainImmediate: CoroutineDispatcher = Dispatchers.Main.immediate // for GUI
  val dispatcherPool: CoroutineDispatcher =
    Executors.newSingleThreadExecutor().asCoroutineDispatcher()

//    // low level
//    dispatcher5.dispatch(EmptyCoroutineContext) {
//        println("Block run on ${Thread.currentThread().name}")
//    }

  println("Outer block run on ${Thread.currentThread().name}")
  withContext(dispatcherIO) {
    println("Inner block run on ${Thread.currentThread().name}")
  }
}