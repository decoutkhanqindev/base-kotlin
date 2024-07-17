package exercises.lambda

//Write an anonymous Kotlin function to calculate the sum of all odd numbers in a list.
fun main() {
//    val sumOddElement: (List<Int>) -> Int = fun(numbers: List<Int>): Int {
//        var sum = 0
//        for (number in numbers) {
//            if (number % 2 != 0) sum += number
//        }
//        return sum
//    }

    val sumOddElement: (List<Int>) -> Int = {numbers -> numbers.filter { it % 2 != 0 }.sum()}
    println(sumOddElement(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)))
}