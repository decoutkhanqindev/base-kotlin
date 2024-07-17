package exercises.function

// Viết một hàm Kotlin lấy danh sách các số nguyên làm đối số và chỉ in các số chẵn trong danh sách. Hàm sẽ trả về Đơn vị.

fun main() {
    val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14)
    printEvenNumbers(numberList)
}

fun printEvenNumbers(numbers: List<Int>) {
    for (i in numbers) {
        if (i % 2 == 0) {
            print("$i ")
        }
    }
}