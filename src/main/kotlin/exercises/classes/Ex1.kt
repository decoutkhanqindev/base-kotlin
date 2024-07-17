package exercises.classes

// Write a Kotlin program that creates a class 'Person' with properties for name, age, and country. Include a function to print the person's details.

class Person(private val name: String, private val age: Int, private val country: String) {
    override fun toString(): String {
        return "Person(name='$name', age=$age, country='$country')"
    }
}

fun main() {
    val person = Person("Dilara Cilla", 25, "Spain")
    println(person.toString())
}