package com.rxmobileteam.course006.lecture06

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val scope: CoroutineScope = CoroutineScope(
        context = Dispatchers.Default + Job() +
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
