fun main() {
//    Trong Kotlin tat ca cac kieu du lieu deu la Object

//    Trong chuỗi thông thường (single - line string), bạn có thể sử dụng $ để chèn giá trị của biến hoặc biểu thức vào chuỗi.
//    Trong chuỗi đa dòng (multiline string), bạn cần sử dụng ký tự backslash (\) để escape ký tự $. Ví dụ: \"\\$100.00\".

    // integer
    val i = 1 // val i:Int = 1
    println("i = $i")

    // byte
    val b : Byte = 5
    println("b = $b")

    // long
    val l = 12L // val l:Long = 12L
    println("l = $l")

    // float
    val f = 3.14f // val f:Float = 3.14f
    println("f = $f")

    // double
    val d = 3.14 // val d:Double = 3.14
    println("d = $d")

    // string
    val s = "minh khang" // val s:String = "minh khang"
    println("s = $s")

    // char
    val c = s[1] //val c:Char = s[1]
    println("c = $c")

    // boolean
    val bl = true//val bl:Boolean = true
    println("bl = $bl")
    val bl1 = false//val bl:Boolean = true
    println("bl = $bl1")

    // pair
    val p = Pair(4, false)
    println("p = $p")
    println("p = ${p.first}")
    println("p = ${p.second}")
    val p1 = Pair<Long, Boolean>(9, true)
    println("p1 = $p1")
    val p2:Pair<Int, Boolean> = p // var p2:Pair<Long, Boolean> = Pair(4, false)
    println("p2 = $p2")
    val p3 = Pair("abc", true)
    println("p3 = $p3")
    val (p4, p5) = p
    println("p4 = $p4 \np5 = $p5")

    // triple
    val t = Triple("a", 5, true)
    println("t = $t")
    println("p4 = $p4 p5 = $p5 t3 = ${t.third}")

    // list
    val l1 = listOf(1, 2, 3) //val l1:List<Int> = listOf<Int>(1, 2, 3)
    println("l1 = $l1")
    val l2 = mutableListOf(4, 5, 6) // val l2:MutableList<Int> = mutableListOf(4, 5, 6)
    l2.removeAt(2)
    println("l2 = $l2")

    // set luu tru nhung phan tu khong trung lap
    val s1 = setOf("a", "a", "A", "B") // val s1:Set<String> = setOf<String>("a", "a", "A", "B")
    println("s1 = $s1")
    val s2 = mutableSetOf("a", "b", "e") // val s1:MutableSet<String> = MutableSetOf<String>("a", "a", "A", "B")
    s2.add("f")
    println("s2 = $s2")

    // map luu tru cac cap gia tri khong trung lap
    val m1 = mapOf("a" to 1, "b" to 2, "c" to 3) // val m:Map<String, Int> = mapOf<String, Int>("a" to 1, "b" to 2, "c" to 3)
    println("m1 = $m1")
    val m2 = mutableMapOf("a" to 1, "b" to 2, "c" to 3) // val m:MutableMap<String, Int> = mutableMapOf<String, Int>("a" to 1, "b" to 2, "c" to 3)
    m2["d"] = 4 // m2.put("d", 4)
    println("m2 = $m2")
}