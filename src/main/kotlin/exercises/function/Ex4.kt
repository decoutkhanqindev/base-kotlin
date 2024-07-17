package exercises.function

import java.lang.StringBuilder

// Viết một hàm Kotlin đảo ngược một chuỗi nhất định.

fun main() {
    val str = "Kotlin function."
    print(reverseString(str))
}

fun reverseString(str: String) : String {
    val rvStr = StringBuilder()
    for (i in (str.length - 1) downTo 0) {
        rvStr.append(str[i])
    }
    return rvStr.toString()
}