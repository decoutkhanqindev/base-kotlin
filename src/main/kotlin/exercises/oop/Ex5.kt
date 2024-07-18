package exercises.oop

// Write a Kotlin object-oriented program that implements the factory method pattern by creating an abstract class
// Animal with subclasses Tiger and Lion. Use a factory class to create instances of animals based on user input.

interface Animal {
    fun makeSound(sound: String): String
}

class Tiger : Animal {
    override fun makeSound(sound: String): String = "$this: $sound"
}

class Lion : Animal {
    override fun makeSound(sound: String): String = "$this: $sound"
}

class AnimalFactory {
    fun createAnimal(typeOfAnimal: String): Animal? {
        return when (typeOfAnimal) {
            "Tiger" -> Tiger()
            "Lion" -> Lion()
            else -> null
        }
    }
}

fun main() {
    val animalFactory = AnimalFactory()
    val userInput = "Tiger"
    val animal = animalFactory.createAnimal(userInput)
    println(animal?.makeSound("roar"))
}