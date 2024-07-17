package exercises.classes

//  Write a Kotlin program that creates a class 'Animal' with properties for name and sound. Include a function to make the animal's sound.

class Animal(val name: String, val sound: String) {
    fun makeSound() = println("$name makes the sound: $sound")

}

fun main() {
    val tiger = Animal("Tiger", "Roar!")
    val lion = Animal("Lion", "Growls!")

    tiger.makeSound()
    lion.makeSound()
}