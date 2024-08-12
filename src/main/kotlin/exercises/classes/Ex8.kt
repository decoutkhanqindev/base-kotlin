package exercises.classes

// Write a Kotlin program that creates a class 'Employee' with properties for name, age, and designation. Include a function to display employee details.

class Employee(
    val name: String,
    val age: Int,
    val designation: String,
) {
    override fun toString(): String {
        return "Employee(name='$name', age=$age, designation='$designation')"
    }
}

fun main() {
    val employee = Employee("Herais Lochlainn", 35, "Manager")
    println(employee.toString())
}