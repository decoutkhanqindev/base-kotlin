package exercises.function

// Viết một hàm Kotlin bên trong một hàm khác để tính bình phương của một số.

fun main() {
    val numbers = arrayOf(44, 90)
    swap(numbers)

    val strings = arrayOf("Hello", "World")
    swap(strings)
}

// Trong hàm swap, việc sử dụng <T> khai báo đây là một hàm generic, nghĩa là hàm có thể làm việc với nhiều kiểu dữ liệu khác nhau.
fun <T> swap(array: Array<T>) {
    val temp = array[0]
    array[0] = array[1]
    array[1] = temp
    println("After swap: ${array[0]}, ${array[1]}")
}