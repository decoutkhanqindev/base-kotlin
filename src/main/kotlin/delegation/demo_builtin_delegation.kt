package delegation

import kotlin.properties.Delegates

class User {
    var name: String by Delegates.observable("<no name>") { property, oldValue, newValue ->
        println("onChanged: $oldValue -> $newValue")
    }

    var address: String by Delegates.notNull() // ~~ lateinit val

    var age: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
        newValue >= 0
    }

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

