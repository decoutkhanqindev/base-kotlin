package exercises.function

//  Viết một hàm Kotlin lấy một số nguyên làm đối số và trả về một Boolean cho biết số đó có phải là số nguyên tố hay không. Sử dụng loại trả hàng rõ ràng.

fun main() {
    val number = 13
    val isNumberPrime = isPrime(number)
    println("Is $number a prime number? $isNumberPrime")
}

fun isPrime(n: Int) : Boolean {
    if (n <= 1) return false
    for (i in 2 until n) {
        if (n % i == 0) return false
    }
    return true
}