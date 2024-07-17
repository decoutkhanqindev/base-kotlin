package exercises.function

// Viết một hàm Kotlin lấy các đối số được đặt tên là 'name', 'age' và 'city' và in các chi tiết của một người.

fun main() {
    printDetails(name = "Gerhard Rikuto", age = 22, city = "New York")
}

fun printDetails(name: String, age: Int, city: String) {
    println("Name: $name")
    println("Age: $age")
    println("City: $city")
}