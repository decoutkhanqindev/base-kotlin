package exercises.classes

// Write a Kotlin program that creates an enum class 'Color' with values for different colors. Use the enum class to represent an object's color.
enum class Color {
    RED, GREEN, BLUE, BLACK, ORANGE
}

data class Obj(val name: String, val color: Color)

fun main() {
    val plants = Obj("Plants", Color.GREEN)
    val cloud = Obj("Cloud", Color.BLACK)
    val flowers = Obj("Flowers", Color.RED)
    println("${plants.name} color: ${plants.color}")
    println("${cloud.name} color: ${cloud.color}")
    println("${flowers.name} color: ${flowers.color}")
}