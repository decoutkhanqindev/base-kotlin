package threadAndCoroutine

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.cancelAndJoin

fun main(): Unit = runBlocking {
//    throw IOException("IOException") // bi crash

    CoroutineScope(Dispatchers.IO).launch {
        throw CancellationException("CancellationException") // co throw exception nhung k bao gio bi crash
    }
}

private fun handelException() {
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val result = callApi()
            // handle result
        } catch (e: CancellationException) { // loi dac biet khong bao gio crash
            throw e
        } catch (e: IOException) {
            // show error in UI
        }
    }
}

suspend fun callApi(): String = "OK"
