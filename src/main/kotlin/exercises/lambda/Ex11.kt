package exercises.lambda

// Write an anonymous Kotlin function to count the number of vowels in a string.
fun main() {
//    val countVowels: (String) -> Int = fun(str: String): Int {
//        var count = 0
//        val vowels = listOf('a', 'e', 'i', 'o', 'u')
//        for (c in str) {
//            if (c in vowels) count++
//        }
//        return count
//    }

    val countVowels: (String) -> Int = { s: String ->
        val vowels = listOf('a', 'e', 'i', 'o', 'u')
        s.count { it in vowels }
    }
    println(countVowels("Hello, World!"))
}