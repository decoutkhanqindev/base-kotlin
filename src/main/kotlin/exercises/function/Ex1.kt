package exercises.function

// Viết một hàm Kotlin lấy 'tên' làm đối số và in một tin nhắn chúc mừng được cá nhân hóa cho người dùng.

fun main() {
    helloUser("Minh Khang")
}

fun helloUser(name: String) {
    println("Hello $name")
}