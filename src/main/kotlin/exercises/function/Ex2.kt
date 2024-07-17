package exercises.function

// Viết một hàm Kotlin lấy một mảng số nguyên và chỉ in số chẵn.

fun main() {
    val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    printEvenElements(array)
}

fun printEvenElements(array: Array<Int>) {
    for (i in array) {
        if (i % 2 == 0) {
            print("$i ")
        }
    }
}