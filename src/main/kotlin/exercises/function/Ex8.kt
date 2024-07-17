package exercises.function

// . Viết một hàm Kotlin tính Chỉ số khối cơ thể (BMI) của một người. Hàm nên lấy chiều cao (tính bằng mét) và trọng lượng (tính bằng kilôgam) làm đối số. Sử dụng các đối số mặc định cho chiều cao và cân nặng.

fun main() {
    val height = 1.65
    val weight = 63.5
    val bmi = calculateBMI(height, weight)
    println("BMI: $bmi")
}

fun calculateBMI(height: Double, weight: Double) : Double {
    return weight / (height * height)
}