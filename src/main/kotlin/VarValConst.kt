const val kc: String = "Hello"

fun main() {
//    var - Biến có thể thay đổi
//    val - Biến không thể thay đổi
//    const val - giong nhu val nhung no se dc xu ly trong qua trinh bien dich
//    lateinit var / val - bien co the null, hay dung trong khai bao thuoc tinh cua class
//    var i : Long? = null - them dau hoi thi bien se dc khai bao null

    var i: Byte = 0
    i++
    val j = 1
    println("$i $j")

    val k: String = "Hello"

    lateinit var s: String //attribute in class
    var l: Long? = null

    val o: Any = " World"
    k.uppercase()
    (o as String).uppercase()
    var o2: Any? = null
    o2 = "Hello World"
}