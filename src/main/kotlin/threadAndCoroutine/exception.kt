package threadAndCoroutine

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

fun main(): Unit = runBlocking {
  // handle exception với launch sẽ có tính chất tu dong lan truyền exception
  // nếu scope 1 bị exception thi scope 2, 3 cung bi cancel
  // sau do se lan truyen den root scope
  
  // handle exception với async sẽ có tính chất doc lap exception
  // nếu scope 1 bị exception can phai handle ket qua cua cua scope, cac scope con lai van tiep tuc
  
  val scope: CoroutineScope = // root scope
    CoroutineScope(
      context = Dispatchers.Default + Job() +
          CoroutineExceptionHandler { coroutineContext: CoroutineContext, throwable: Throwable ->
            println("CoroutineExceptionHandler: throwable=$throwable")
            println("               coroutineContext=$coroutineContext")
            println("               job=${coroutineContext.job}")
            // crashlytics.logException(throwable)
          })
  
  scope.launch {
    println("launch 1")
    delay(1)
    println("launch 1 throws...")
    throw RuntimeException("launch 1 failed")
  }
  
  scope.launch {
    println("launch 2")
    delay(1000)
    println("launch 2 done")
  }
  
  scope.launch {
    println("launch 3")
    delay(100)
    println("launch 3 done")
  }
  
  delay(5_000)
}

//launch 1
//launch 2
//launch 3
//launch 1 throws...
//CoroutineExceptionHandler: throwable=java.lang.RuntimeException: launch 1 failed
//coroutineContext=[threadAndCoroutine.ExceptionKt$main$1$invokeSuspend$$inlined$CoroutineExceptionHandler$1@1ff7ebb1, StandaloneCoroutine{Cancelling}@cff98b2, Dispatchers.Default]
//job=StandaloneCoroutine{Cancelling}@cff98b2