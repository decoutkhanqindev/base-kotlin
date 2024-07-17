package exercises.function

// Viết một hàm Kotlin tính toán và trả về diện tích của một hình chữ nhật. Nó sẽ lấy 'length' và 'width' làm đối số, với các giá trị mặc định là 0.0.
fun main() {
    val area = calculateArea(7.0, 3.0)
    println("The area of the rectangle is: $area")
}

fun calculateArea(length: Double = 0.0, width: Double = 0.0): Double {
    return width * length
}