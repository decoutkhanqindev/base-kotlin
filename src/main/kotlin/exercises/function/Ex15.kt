package exercises.function

// Viết một hàm Kotlin in một mẫu dấu hoa thị dựa trên một kích thước nhất định. Kích thước thể hiện số hàng và cột trong mẫu. Sử dụng hàm biểu thức đơn.

fun printPattern(size: Int) = repeat(size) { println("*".repeat(size)) }

fun main() {
    val patternSize = 5
    printPattern(patternSize)
}