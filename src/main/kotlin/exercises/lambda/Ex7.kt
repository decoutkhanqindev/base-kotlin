package exercises.lambda

//  Write a Kotlin program that implements a lambda expression to convert a list of strings to uppercase.
fun main() {
    val strings = listOf("red", "green", "blue", "white", "orange", "black")
    val uppercaseList = strings.map { it.uppercase() }
    println(uppercaseList)
}