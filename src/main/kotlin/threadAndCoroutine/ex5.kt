package threadAndCoroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@OptIn(ExperimentalStdlibApi::class)
suspend fun demoCoroutineContext() {
    val ctx: CoroutineContext = currentCoroutineContext()
    println("currentCoroutineContext=$ctx")

    val dispatcher: CoroutineDispatcher? = ctx[CoroutineDispatcher.Key]
    print("CoroutineDispatcher=$dispatcher")

    val count: Int = ctx.fold(0) { acc, e ->
        println("acc=$acc, e=$e")
        acc + 1
    }
    println("count=$count")

    val minusDispatcher: CoroutineContext? = ctx.minusKey(CoroutineDispatcher.Key)
    println("minusDispatcher=$minusDispatcher")

    // EmptyCoroutineContext ~ emptyMap
    println("EmptyCoroutineContext + ctx=${EmptyCoroutineContext + ctx}")
}

fun main() = runBlocking {
    demoCoroutineContext()
}