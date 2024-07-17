package exercises.function

//  Viết một hàm Kotlin lấy tên của một người làm đối số và in một tin nhắn chúc mừng với tên. Hàm sẽ trả về Đơn vị.

fun printGreeting(name: String) {
    println("Hello, $name! Welcome!")
}

fun main() {
    val personName = "Moerani Cornell"
    printGreeting(personName)
}