package threadAndCoroutine

import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(): Unit = runBlocking {
  val job: Job = launch {
    try {
      repeat(1000) { i ->
        println("job: I'm sleeping $i ...")
        delay(500L)
      }
    } finally {
      withContext(NonCancellable) { // chuyen sang dispatcher khac va tra ve 1 ket qua
        println("job: I'm running finally")
        delay(1000L)
        println("job: And I've just delayed for 1 sec because I'm non-cancellable")
        // neu khong boc ben trong cua withContext(NonCancellable)
        // thi chi in ra job: I'm running finally
        // vi delay(1000L) la suspend function no se check xem job isActive hay khong
        // trong truong hop nay notActive nen se khong in ra job: And I've just delayed for 1 sec because I'm non-cancellable
      }
    }
  }
  delay(1300L) // delay a bit
  println("main: I'm tired of waiting!")
  job.cancelAndJoin() // cancels the job and waits for its completion
  println("main: Now I can quit.")
}