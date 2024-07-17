package delegation

import kotlin.properties.Delegates

class User {
    var name: String by Delegates.observable("<no name>") { property, old, new ->
        println("onChanged: $old -> $new")
    }

    var address:String by Delegates.notNull() // lateinit val
    override fun toString(): String {
        return "User(name='$name', '$address')"
    }
}

fun main() {
    val user = User()
//    user.name = "abc"
//    println(user)
//    user.name = "xyz"
//    println(user)

    user.address = "vn"
    println(user)
}

