package exercises.lambda

//  Write a Kotlin program that implements a lambda expression to filter a list of strings. It returns only strings starting with the letter 'K'.
fun main() {
    val strings = listOf<String>("Kotlin", "Java", "Kotlin Programming", "Python", "Kotlin Language")
    val filteredList: (List<String>) -> List<String> = { strs -> strs.filter { it.startsWith("K") } }
    println(filteredList(strings))
}