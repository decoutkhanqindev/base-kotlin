package exercises.function

import kotlin.math.PI

//  Viết hàm Kotlin tính diện tích hình tròn. Sử dụng giá trị mặc định là 3,14 cho pi.
fun main() {
    val radius = 4.0
    val area = calculateCircleArea(radius)
    println("The area of the circle with radius $radius is $area")
}

fun calculateCircleArea(radius: Double) : Double {
    return PI * radius * radius
}