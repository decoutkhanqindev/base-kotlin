package delegation

data class Product(val id: Int, val name: String)

interface ProductRepository {
    fun getFavoriteProducts(): List<Product>
    fun findById(id: Int): Product
}

// api/v1
class ApiV1 : ProductRepository {
    override fun getFavoriteProducts(): List<Product> {
        println("this is $this")
        return listOf(
            Product(1, "abc"), Product(2, "cde"), Product(3, "mnl")
        )
    }

    override fun findById(id: Int): Product {
        println("this is $this")
        return Product(id, "abc")
    }
}

// api/v2
class ApiV2(apiDelegate: ProductRepository) : ProductRepository by apiDelegate {
    override fun findById(id: Int): Product {
        println("this is $this")
        return Product(id, "abc")
    }
}

fun provideProductRepo(): ProductRepository = ApiV2(ApiV1())

fun main() {
    val repository = provideProductRepo()
    println(repository.getFavoriteProducts())
    println(repository.findById(10))
}