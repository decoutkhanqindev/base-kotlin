package threadAndCoroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.async

fun main(): Unit = runBlocking {
    val scope: CoroutineScope = CoroutineScope(Dispatchers.IO + Job())

    val deferredString: Deferred<String> = scope.async {
        delay(1000)
        "hello"
    }

    val result = deferredString.await()
    println(result)
}