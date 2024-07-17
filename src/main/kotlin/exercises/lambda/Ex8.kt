package exercises.lambda

// Write an anonymous Kotlin function to check if a string is a palindrome.

fun main() {
    val isPalindrome: (String) -> Boolean = { str ->
        val cleanStr = str.lowercase().replace(Regex("[^a-zA-Z0-9]"), "")
        cleanStr == cleanStr.reversed()
    }

    println(isPalindrome("abc"))
}