package exercises.oop


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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}

fun main() {
    val log1 = Logger.getInstance()
    val log2 = Logger.getInstance()

    if (log1 == log2) {
        println("log1=$log1 == log2=$log2 ")
        println("SINGLETON PATTERN")
    } else {
        println("NOT SINGLETON PATTERN")
    }
}