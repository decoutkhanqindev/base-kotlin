package threadAndCoroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
  val scope: CoroutineScope = CoroutineScope(
    context = Dispatchers.Default + Job()
  )
  
  // async -> concurrency
  // code below will have max time is 1000
  
  val d1: Deferred<String> = scope.async<String> {
    println("launch 1")
    delay(1)
    println(">>> launch 1 done")
    "this is result of launch 1"
//   println("launch 1 throws...")
//   throw RuntimeException("launch 1 failed")
  }
  
  val d2: Deferred<Unit> = scope.async {
    println("launch 2")
    delay(1000)
    println(">>> launch 2 done")
  }
  
  val d3: Deferred<Unit> = scope.async {
    println("launch 3")
    delay(100)
    println(">> launch 3 done")
  }
  
  try {
    println(d1.await())
  } catch (e: RuntimeException) {
    println("d1 failed: $e")
  }
  
  try {
    d2.await()
  } catch (e: RuntimeException) {
    println("d2 failed: $e")
  }
  
  try {
    d3.await()
  } catch (e: Exception) {
    println("d3 failed: $e")
  }
  
  delay(5_000)
}
