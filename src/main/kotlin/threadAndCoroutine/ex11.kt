package com.rxmobileteam.course006.lecture06

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    // handle exception in launch phai can handle dua tren ket qua tra ve = Deferred

    val scope: CoroutineScope = CoroutineScope(
        context = Dispatchers.Default + Job()
    )

    val d1: Deferred<Int> = scope.async<Int> {
        println("launch 1")
        delay(1)
        println("launch 1 throws...")
        throw RuntimeException("launch 1 failed")
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
        d1.await()
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
