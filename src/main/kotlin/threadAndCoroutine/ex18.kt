package com.rxmobileteam.course006.lecture06

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val scope: CoroutineScope = CoroutineScope(
        context = Dispatchers.Default + SupervisorJob() +
                CoroutineExceptionHandler { coroutineContext, throwable ->
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
//coroutineContext=[com.rxmobileteam.course006.lecture06.Job_launchKt$main$1$invokeSuspend$$inlined$CoroutineExceptionHandler$1@87d1c3d, StandaloneCoroutine{Cancelling}@39e7a9f3, Dispatchers.Default]
//job=StandaloneCoroutine{Cancelling}@39e7a9f3