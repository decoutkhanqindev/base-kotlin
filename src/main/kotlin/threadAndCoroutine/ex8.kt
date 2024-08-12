package threadAndCoroutine

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.cancel
import kotlinx.coroutines.job

fun main() = runBlocking {
    val coroutineScope: CoroutineScope = CoroutineScope(context = Dispatchers.IO)
    println(coroutineScope)

    repeat(20) {
        coroutineScope.launch { // -> job is CoroutineContext
            println(">>>> START coroutine $it")
            try {
                delay(500)
            } catch (e: CancellationException) {
                println(">>>> CANCEL coroutine $it $e")
                throw (e)
            }
            println(">>>> END coroutine $it")
        }
    }

    val childrenScope = coroutineScope.coroutineContext.job.children.toList()
    println(childrenScope.forEach {
        println("CHILD >>>> $it") // repeat(20) -> 20 children scope
    })

    delay(200)
    // scope have 1 parent job
    // parent.cancel() -> children job canceled
    coroutineScope.cancel() // cancel 20 children scope
    Thread.sleep(1000)
}