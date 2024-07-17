package exercises.classes

//  Write a Kotlin program that creates a class 'Product' with properties for name, price, and quantity. Calculate the total cost of the product with a function.
class Product (val name: String, val price: Double, val quantity: Int) {
    fun totalCost() = price * quantity
}

fun main() {
    val product = Product("Desktop", 2000.0, 4)
    println(product.totalCost())
}