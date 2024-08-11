package threadAndCoroutine

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.runBlocking

suspend fun demoCoroutineContext() {
    val ctx = currentCoroutineContext()
    println(ctx)
}

fun main() = runBlocking {
    demoCoroutineContext()
}