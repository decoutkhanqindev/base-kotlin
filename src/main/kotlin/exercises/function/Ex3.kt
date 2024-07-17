package exercises.function

// Viết một hàm Kotlin 'countVowels' đếm số nguyên âm trong một chuỗi nhất định.

fun main() {
    val str = "Kotlin, function!"
    println(countVowelChar(str))
}

fun countVowelChar(str: String) : Int {
    val vowels = arrayOf('a', 'e', 'i', 'o', 'u')
    var count = 0
    for (i in str) {
        if (i in vowels) {
            count++
        }
    }
    return count
}