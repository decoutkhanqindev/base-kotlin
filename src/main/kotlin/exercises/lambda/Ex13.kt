package exercises.lambda

// Write an anonymous Kotlin function to concatenate two strings and return the result.
fun main() {
    val concatStrings: (String, String) -> String = { s1, s2 -> s1 + s2 }
    val string1 = "Kotlin "
    val string2 = "Exercises."

    val result = concatStrings(string1, string2)
    println("Concatenated string: $result")
}