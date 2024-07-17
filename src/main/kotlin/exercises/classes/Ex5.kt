package exercises.classes

// Write a Kotlin program that creates a class 'Book' with properties for title, author, and publication year. Include a function to display book details.
class Book(val title: String, val author: String, val publicationYear: Int) {
    override fun toString(): String {
        return "Book(title='$title', author='$author', publicationYear=$publicationYear)"
    }
}

fun main() {
    val book1 = Book("Anne of Green Gables", "Lucy Maud Montgomery", 1908)
    val book2 = Book("The Call of the Wild", "Jack London", 1903)

    println(book1.toString() + "\n" + book2.toString())
}