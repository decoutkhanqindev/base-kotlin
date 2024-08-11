package threadAndCoroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

@OptIn(ExperimentalStdlibApi::class)
suspend fun demoCoroutineContext() {
    val ctx: CoroutineContext = currentCoroutineContext()
    println(ctx)

    val dispatcher: CoroutineDispatcher? = ctx[CoroutineDispatcher.Key]
    print(dispatcher)

    val count: Int = ctx.fold(0) { acc, e ->
        println("acc=$acc, e=$e")
        acc + 1
    }
    println("count=$count")

    val minusDispatcher: CoroutineContext? = ctx.minusKey(CoroutineDispatcher.Key)
    println("minusDispatcher=$minusDispatcher")
}

fun main() = runBlocking {
    demoCoroutineContext()
}