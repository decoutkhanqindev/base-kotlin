package exercises.classes

// Write a Kotlin program that creates a class 'Car' with properties for make, model, and year. Include a function to display car information.

class Car (private val make: String, private val model: String, private val year: Int) {
    override fun toString(): String {
        return "Car(make='$make', model='$model', year=$year)"
    }
}

fun main() {
    val car = Car("Mercedes-Benz", "E 350 Sedan", 2021)
    println(car.toString())
}