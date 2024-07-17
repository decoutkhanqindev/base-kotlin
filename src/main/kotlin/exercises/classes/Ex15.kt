package exercises.classes

// Write a Kotlin program that creates a class 'Person' with a nested class 'ContactInfo' to store the person's contact information.

class Person1(val name: String) {
    private var contactInfo: ContactInfo? = null

    fun setContactInfo(email: String, phone: String) {
        contactInfo = ContactInfo(email, phone)
    }

    fun displayContactInfo() {
        contactInfo?.let {
            println("Contact Information of $name:")
            println("Email: ${it.email}")
            println("Phone: ${it.phone}")
        }
    }

    inner class ContactInfo(val email: String, val phone: String)
}

fun main() {
    val person = Person1("Mitko Leida")
    person.setContactInfo("mitkoleida@example.com", "01234567")
    person.displayContactInfo()
}