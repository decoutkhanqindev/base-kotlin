package exercises.controlFlow

// Viết một chương trình Kotlin để kiểm tra xem một ký tự nhất định là nguyên âm hay phụ âm.

fun main() {
    val char = 'a'

    if (isVowel(char)) {
        println("The character '$char' is a vowel.")
    } else {
        println("The character '$char' is a consonant.")
    }
}

fun isVowel(char: Char): Boolean {
    return when (char.lowercaseChar()) {
        'a', 'e', 'i', 'o', 'u' -> true
        else -> false
    }
}

fun isConsonant(char: Char): Boolean {
    return !isVowel(char) && char.isLetter()
}