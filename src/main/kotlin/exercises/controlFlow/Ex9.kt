package exercises.controlFlow

// Viết một chương trình Kotlin để đếm số phần tử chẵn và lẻ trong một mảng.

fun main() {
    val numbers = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)

    val evenCount = countEvenNumbers(numbers)
    val oddCount = countOddNumbers(numbers)

    println("Number of even elements: $evenCount")
    println("Number of odd elements: $oddCount")
}

fun countEvenNumbers(numbers: MutableList<Int>): Int {
    var count = 0
    for (i in numbers) {
        if (i % 2 == 0) count++
    }
    return count
}

fun countOddNumbers(numbers: MutableList<Int>): Int {
    var count = 0
    for (i in numbers) {
        if (i % 2 != 0) count++
    }
    return count
}