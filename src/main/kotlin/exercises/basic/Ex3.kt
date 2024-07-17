package exercises.basic

import java.text.SimpleDateFormat
import java.util.Date

//  Viết một chương trình Kotlin để hiển thị ngày và giờ hiện tại.
fun main() {
    val currentDate = Date()
    val format = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
    val dateFormatted = format.format(currentDate)
    println("$dateFormatted")
}