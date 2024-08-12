package exercises.classes

// Write a Kotlin program that creates a class 'Customer' with properties for name, email, and address. Include a function to send a welcome email to the customer.

class Customer(val name: String, val email: String, val address: String) {
    fun sendWelcome() = println("Sending a welcome email to $name at $email...")
}

fun main() {
    val customer = Customer("Ime Juan", "imejuan@example.com", "100 ABC Street")
    customer.sendWelcome()
}