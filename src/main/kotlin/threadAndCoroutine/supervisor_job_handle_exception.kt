import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

fun main(): Unit = runBlocking {
  // SupervisorJob co tinh chat cancel doc lap -> cac child cua scope co the cancel doc lap nhau
  
  val scope: CoroutineScope = CoroutineScope(
    context = Dispatchers.Default + SupervisorJob() +
        CoroutineExceptionHandler { coroutineContext: CoroutineContext, throwable: Throwable ->
          println("CoroutineExceptionHandler: throwable=$throwable")
          println("               coroutineContext=$coroutineContext")
          println("               job=${coroutineContext.job}")
          // crashlytics.logException(throwable)
        }
  )
  
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
//coroutineContext=[Supervisor_job_handle_exceptionKt$main$1$invokeSuspend$$inlined$CoroutineExceptionHandler$1@63e051b2, StandaloneCoroutine{Cancelling}@3490e9d0, Dispatchers.Default]
//job=StandaloneCoroutine{Cancelling}@3490e9d0
//launch 3 done
//launch 2 done