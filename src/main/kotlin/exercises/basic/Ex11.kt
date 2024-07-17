package exercises.basic

// Viết chương trình Kotlin để chuyển đổi nhiệt độ từ độ C sang độ F và ngược lại.

fun main() {
    val temperature = readLine()!!.toDouble()
    if (temperature != null) {
        displayMenu()
        when (readLine()!!.toInt()) {
            1 -> {
                val fahrenheit = celsiusToFahrenheit(temperature)
                println("Temperature in Fahrenheit: $fahrenheit")
            }

            2 -> {
                val celsius = fahrenheitToCelsius(temperature)
                println("Temperature in Celsius: $celsius")
            }
        }
    }
}

fun displayMenu() {
    println("1. Celsius To Fahrenheit.")
    println("2. Fahrenheit To Celsius.")
}

fun celsiusToFahrenheit(celsius: Double): Double {
    return (celsius * 9 / 5) + 32
}

fun fahrenheitToCelsius(fahrenheit: Double): Double {
    return (fahrenheit - 32) * 5 / 9
}