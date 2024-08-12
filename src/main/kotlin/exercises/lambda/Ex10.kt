package exercises.lambda

//  Write an anonymous Kotlin function to find the maximum element in an array.
fun main() {
//    val maxElement: (Array<Int>) -> Int = fun(arr: Array<Int>): Int {
//        var max = Int.MIN_VALUE
//        for (element in arr) {
//            if (element > max) max = element
//        }
//        return max
//    }
    val maxElement: (Array<Int>) -> Int = { numbers -> numbers.max() }
    println(maxElement(arrayOf(5, 7, 8, 3, 2, 4, 12, 6)))
}