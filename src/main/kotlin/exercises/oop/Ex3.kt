package exercises.oop

//  Write a Kotlin object-oriented program that creates a sealed class Result with subclasses Success and Error
//  to represent the result of an operation. Use pattern matching to handle different result types.

sealed class Result {
    data class Success(val data: String) : Result()
    data class Failure(val message: String) : Result()
}

fun processResult(result: Result): String {
    return when (result) {
        is Result.Success -> "Process is successful with data = ${result.data}"
        is Result.Failure -> "Process is fail with error message = ${result.message}"
    }
}

fun main() {
    val success = Result.Success("123")
    val failure = Result.Failure("failll")

    println(processResult(success))
    println(processResult(failure))
}