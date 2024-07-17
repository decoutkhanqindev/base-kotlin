package exercises.classes

// Write a Kotlin program that creates a class 'Logger' with a companion object that provides logging functionality.
class Logger private constructor() {
    companion object {
        fun log(message: String) = println(message)
    }
}

fun main() {
    Logger.log("This is a message")
}