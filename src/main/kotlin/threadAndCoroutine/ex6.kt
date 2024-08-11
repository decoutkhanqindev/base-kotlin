package threadAndCoroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.withContext

fun main(): Unit = runBlocking {
    val dispatcher1 = Dispatchers.IO
    val dispatcher2 = Dispatchers.Default
    val dispatcher3 = Dispatchers.Main
    val dispatcher4 = Dispatchers.Main.immediate
    val dispatcher5 = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

//    // low level
//    dispatcher5.dispatch(EmptyCoroutineContext) {
//        println("Block run on ${Thread.currentThread().name}")
//    }

    println("Block run on ${Thread.currentThread().name}")
    withContext(dispatcher5) {
        println("Inner block run on ${Thread.currentThread().name}")
    }
}