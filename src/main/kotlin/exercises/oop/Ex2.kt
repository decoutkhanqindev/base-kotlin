package exercises.oop

import kotlin.js.ExperimentalJsReflectionCreateInstance


// Write a Kotlin object-oriented program that implements a singleton pattern for a class Logger to provide logging functionality throughout the  application.

class Logger private constructor() {
    init {
        println("Logger initialized")
    }

    fun log(message: String): String {
        return "Logging: $message"
    }

    companion object {
        private var instance: Logger? = null

        fun getInstance(): Logger {
            if (instance == null) {
                synchronized(Logger::class.java) {
                    if (instance == null) {
                        instance = Logger()
                    }
                }
            }
            return instance!!
        }
    }
}

fun main() {
    val log1 = Logger.getInstance()
    println(log1.log("hello"))
}