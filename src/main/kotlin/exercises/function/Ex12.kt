package exercises.function

//  Viết một hàm Kotlin lấy số nguyên n làm đối số và in các số từ 1 đến n trên các dòng riêng biệt. Hàm sẽ trả về Đơn vị.

fun main() {
    val n = 7
    printNumbers(n)
}

fun printNumbers(n: Int) {
    for (i in 1..n) {
        println(i)
    }
}