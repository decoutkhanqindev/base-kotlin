package exercises.function

import kotlin.math.pow

//  Viết một hàm Kotlin tính tổng của một chuỗi số học hoặc hình học đã cho.
//  Hàm nên lấy thuật ngữ đầu tiên, chênh lệch / tỷ lệ chung và số lượng số hạng làm đối số.
//  Sử dụng các kiểu chung để xử lý cả chuỗi số học và hình học.

fun main() {
    val arithmeticSum = calculateSeriesSum(2, 3, 5)
    println("Arithmetic Sum: $arithmeticSum")

    val geometricSum = calculateSeriesSum(2.0, 3.0, 5)
    println("Geometric Sum: $geometricSum")
}

fun <T: Number> calculateSeriesSum(firstTerm: T, commonDiffRatio: T, numTerms: Int) : Double {
    require(numTerms > 0) { "Number of terms must be greater than 0." }

    val a = firstTerm.toDouble()
    val n = numTerms.toDouble()

    return when (commonDiffRatio) {
        is Double -> {
            if (commonDiffRatio == 1.0) {
                a * n
            } else {
                a * (1 - commonDiffRatio.pow(n)) / (1 - commonDiffRatio)
            }
        }
        is Int -> {
            if (commonDiffRatio == 0) {
                a * n
            } else {
                (n / 2) * (2 * a + (n - 1) * commonDiffRatio)
            }
        }
        else -> throw IllegalArgumentException("Unsupported data type for common difference/ratio.")
    }
}