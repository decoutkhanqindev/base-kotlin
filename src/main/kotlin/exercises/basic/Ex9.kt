package exercises.basic

// Viết một chương trình Kotlin để kiểm tra xem một năm nhất định có phải là năm nhuận hay không.

fun main(args: Array<String>) {
    val year = 2004
    if (isLeapYear(year)) {
        println("$year is a leap year.")
    } else {
        println("$year is not a leap year.")
    }
}

fun isLeapYear(year: Int): Boolean {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
}
