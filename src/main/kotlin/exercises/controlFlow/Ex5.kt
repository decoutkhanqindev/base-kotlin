package exercises.controlFlow

// Viết một chương trình Kotlin để in tam giác Pascal của một số hàng nhất định.

fun main() {
    val numRows = 7
    printPascalTriangle(numRows)
}

fun printPascalTriangle(rows: Int) {
    require(rows > 0) { "Number of rows must be greater than 0." }

    var prevRow = mutableListOf(1)
    println(prevRow.joinToString(" "))

    for (currentRow in 1 until rows) {
        val nextRow = mutableListOf<Int>()
        nextRow.add(1)

        for (i in 1 until currentRow) {
            val sum = prevRow[i - 1] + prevRow[i]
            nextRow.add(sum)
        }
        nextRow.add(1)

        println(nextRow.joinToString(" "))

        prevRow = nextRow
    }
}