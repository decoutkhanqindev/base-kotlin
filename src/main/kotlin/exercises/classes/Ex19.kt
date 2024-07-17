package exercises.classes

// Write a Kotlin program that creates an inline class ' Email' that represents an  email address. Use the inline class to enforce type safety.
inline class Email(val value: String)

fun sendEmail(email: Email) {
    println("Sending to email: ${email.value}")

}

fun main() {
    val email = Email("av@gmail.com")
    sendEmail(email)
}