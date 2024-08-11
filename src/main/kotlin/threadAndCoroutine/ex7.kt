package threadAndCoroutine

import kotlinx.coroutines.CloseableCoroutineDispatcher
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.newSingleThreadContext
import java.util.concurrent.Executors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
fun main(): Unit = runBlocking {
//    println(Runtime.getRuntime().availableProcessors()) // threads cua may ~ Dispatchers.Default
//
//    val scope: CoroutineScope = CoroutineScope(context = Dispatchers.Default)
//    // IO ~ 64 threads
//    // Default ~ 12 threads
//
//    // task
//    repeat(200) { it: Int ->
//        scope.launch {
//            println(">>>> i=$it, thread=${Thread.currentThread().name}")
//            Thread.sleep(500)
//            println("<<<< i=$it, thread=${Thread.currentThread().name}")
//        }
//    }
//
//    delay(20000)
//    println("Task is done")

    // dispatcher unconfined
    val singleThreadDispatcher: CloseableCoroutineDispatcher = newSingleThreadContext(name = "new single thread")
    val dispatcherThreadPool: ExecutorCoroutineDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

//    withContext(Dispatchers.IO) {
    withContext(Dispatchers.Unconfined) {
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
    val LimitIO3 = Dispatchers.IO.limitedParallelism(3)
    repeat(100) {
        CoroutineScope(LimitIO3).launch {
            println("START $it thread=${Thread.currentThread().name}")
            Thread.sleep(500)
            println("END $it thread=${Thread.currentThread().name}")
        }
    }

    delay(15_000)
}