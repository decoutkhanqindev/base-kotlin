package exercises.function

// Viết một hàm Kotlin để kiểm tra xem một chuỗi có phải là palindrome hay không.

fun main() {
    val str1 = "Madam"
    val str2 = "Kotlin"

    println("$str1 is palindrome: ${isPalindrome(str1)}")
    println("$str2 is palindrome: ${isPalindrome(str2)}")
}

fun isPalindrome(str: String): Boolean {
    // chi nhan chuoi co chua chu va so
    val cleanStr = str.lowercase().replace(Regex("[^a-zA-Z0-9]"), "")
    return cleanStr == cleanStr.reversed()
}