package threadAndCoroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

fun main() {
    val coroutineScope: CoroutineScope = CoroutineScope(context = Dispatchers.IO)
    println(coroutineScope)
}