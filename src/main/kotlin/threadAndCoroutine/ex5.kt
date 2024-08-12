package threadAndCoroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@OptIn(ExperimentalStdlibApi::class)
suspend fun demo() {
    val ctx: CoroutineContext = currentCoroutineContext()
    println(ctx)

    val dispatcher = ctx[CoroutineDispatcher.Key]
    println("dispatcher=$dispatcher")

    val count = ctx.fold(initial = 0) { acc, e ->
        println("acc=$acc, e=$e")
        acc + 1
    }
    println("count=${count}")

    val minusDispatcher = ctx.minusKey(CoroutineDispatcher.Key)
    println("minusDispatcher=$minusDispatcher")

    // EmptyCoroutineContext ~ emptyMap
    println("EmptyCoroutineContext + ctx: ${EmptyCoroutineContext + ctx}")
    println("EmptyCoroutineContext + ctx: ${ctx + EmptyCoroutineContext}")
}

// Element == Singleton Context
class MyDemoCoroutineContext(
    private val name: String,
) : AbstractCoroutineContextElement(key = MyDemoCoroutineContext) {

    companion object Key : CoroutineContext.Key<MyDemoCoroutineContext>

    override fun toString(): String = "MyDemoCoroutineContext($name)"
}

suspend fun demoPrint() {
    val currentContext = currentCoroutineContext()
    val myContext = currentContext[MyDemoCoroutineContext]
    println("currentContext=$currentContext")
    println("myContext=$myContext")
    println("-".repeat(80))
}

fun main() = runBlocking {
//  println(mapOf(1 to "a", 2 to "b") + mapOf(1 to "C"))
//  println(emptyMap<Int, String>() + mapOf(1 to "2", 2 to "c"))
    demo()

    withContext(EmptyCoroutineContext) {
        demoPrint()
    }

    // withContext: current context + new context => new context
    withContext(MyDemoCoroutineContext(name = "Outer 1")) {
        demoPrint()

        withContext(MyDemoCoroutineContext(name = "Inner 1")) {
            demoPrint()

            withContext(MyDemoCoroutineContext(name = "Inner 2")) {
                demoPrint()
            }
        }
    }
}