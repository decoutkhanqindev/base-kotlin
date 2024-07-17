package exercises.classes

// Write a Kotlin program that creates a class 'Student' with properties for name, age, and grade. Include a function to check if the student is eligible for promotion.
class Student(val name: String, val age: Int, val grade: Int) {
    fun isEligibleForPromotion() = grade > 8
}

fun main() {
    val student1 = Student("Ema Luella", 16, 9)
    val student2 = Student("Iclza Iqoqtux", 15, 7)

    println("${student1.name} is eligible for promotion: ${student1.isEligibleForPromotion()}")
    println("${student2.name} is eligible for promotion: ${student2.isEligibleForPromotion()}")
}