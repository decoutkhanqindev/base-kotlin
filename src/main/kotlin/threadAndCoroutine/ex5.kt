package threadAndCoroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.withContext

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

// element ~ singleton context
class MyCustomCoroutineContext(
    private val name: String
) : AbstractCoroutineContextElement(key = Key) {

    companion object Key : CoroutineContext.Key<MyCustomCoroutineContext>

    override fun toString(): String = "MyCustomCoroutineContext($name)"
}

suspend fun demoPrint() {
    val currentContext: CoroutineContext = currentCoroutineContext()
    val myCoroutineContext: MyCustomCoroutineContext? = currentContext[MyCustomCoroutineContext.Key]
    println("currentCoroutineContext=$currentContext")
    println("myCoroutineContext=$myCoroutineContext")
    println("-".repeat(100))
}

fun main(): Unit = runBlocking {
//    demoCoroutineContext()
//    demoPrint()

    // withContext: current context + new context = new context
    withContext(MyCustomCoroutineContext("Outer 1")) {
        demoPrint()

        withContext(MyCustomCoroutineContext("Inner 1")) {
            demoPrint()
        }

        withContext(MyCustomCoroutineContext("Inner 2")) {
            demoPrint()
        }
    }
}