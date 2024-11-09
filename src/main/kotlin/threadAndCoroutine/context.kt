package threadAndCoroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@OptIn(ExperimentalStdlibApi::class)
private suspend fun demo() {
  val ctx: CoroutineContext = currentCoroutineContext()
  println(ctx)

  val dispatcher: CoroutineDispatcher? = ctx[CoroutineDispatcher.Key]
  println("dispatcher=$dispatcher")

  val count: Int = ctx.fold(initial = 0) { acc: Int, e: CoroutineContext.Element ->
    println("acc=$acc, e=$e")
    acc + 1
  }
  println("count=${count}")

  val minusDispatcher: CoroutineContext = ctx.minusKey(key = CoroutineDispatcher.Key)
  println("minusDispatcher=$minusDispatcher")

  // EmptyCoroutineContext ~ emptyMap
  println("EmptyCoroutineContext + ctx: ${EmptyCoroutineContext + ctx}")
  println("ctx + EmptyCoroutineContext: ${ctx + EmptyCoroutineContext}")
}

// Custom coroutine context
// Element == Singleton Context
class MyCustomCoroutineContext(
  private val name: String,
) : AbstractCoroutineContextElement(key = Key) {

  companion object Key : CoroutineContext.Key<MyCustomCoroutineContext>

  override fun toString(): String = "MyCustomCoroutineContext($name)"
}

private suspend fun demoPrint() {
  val currentContext: CoroutineContext = currentCoroutineContext()
  val myContext: MyCustomCoroutineContext? = currentContext[MyCustomCoroutineContext.Key]
  println("currentContext=$currentContext")
  println("myContext=$myContext")
  println("-".repeat(80))
}

fun main(): Unit = runBlocking {
//  println(mapOf(1 to "a", 2 to "b") + mapOf(1 to "C"))
//  println(emptyMap<Int, String>() + mapOf(1 to "2", 2 to "c"))
  demo()
  
  println("-".repeat(80))

  withContext(context = EmptyCoroutineContext) {
    demoPrint()
  }

  // withContext: current context + new context => new context
  withContext(context = MyCustomCoroutineContext(name = "Outer 1")) {
    demoPrint()

    withContext(context = MyCustomCoroutineContext(name = "Inner 1")) {
      demoPrint()

      withContext(context = MyCustomCoroutineContext(name = "Inner 2")) {
        demoPrint()
      }
    }
  }
}