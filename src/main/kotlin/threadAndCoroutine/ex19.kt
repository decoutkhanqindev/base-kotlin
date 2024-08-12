package com.rxmobileteam.course006.lecture06

import kotlin.random.Random
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    // SupervisorJob co tinh chat cancel doc lap -> cac child cua scope co the cancel doc lap nhau

    val scope: CoroutineScope = CoroutineScope(
        context = Dispatchers.Default + SupervisorJob()
    )

    val d1 = scope.async<Int>{
        println("launch 1")
        delay(1)
        println("launch 1 throws...")
        throw RuntimeException("launch 1 failed")
    }

    val d2 = scope.async {
        println("launch 2")
        delay(1000)
        Random.nextInt()
            .also {
                println(">>> launch 2 done with $it")
            }
    }

    val d3 = scope.async {
        println("launch 3")
        delay(100)
        println(">>> launch 3 done")
    }

    try {
        d1.await()
    }catch (e: RuntimeException){
        println("d1 failed: $e")
    }

    try {
        val r2 = d2.await()
        println("r2 is $r2")
    }catch (e: RuntimeException){
        println("d2 failed: $e")
    }

    delay(5_000)
}


//launch 1
//launch 2
//launch 3
//launch 1 throws...
//d1 failed: java.lang.RuntimeException: launch 1 failed
//d2 failed: kotlinx.coroutines.JobCancellationException: Parent job is Cancelling; job=JobImpl{Cancelled}@4ca8195f