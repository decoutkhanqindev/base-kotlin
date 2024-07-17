package exercises.oop

import kotlin.math.sqrt

// Shape base class and Polymorphic subclasses.
interface Shape {
    fun area(): Double
    fun perimeter(): Double
}

class Circle (private val radius: Double) : Shape {
    override fun area(): Double {
        return Math.PI * radius * radius
    }

    override fun perimeter(): Double {
        return 2 * Math.PI * radius
    }
}

class Rectangle (private val width: Double, private val height: Double) : Shape {
    override fun area(): Double {
        return width * height
    }

    override fun perimeter(): Double {
        return 2 * (width + height)
    }
}

class Triangle(private val side1: Double, private val side2: Double, private val side3: Double) : Shape {
    override fun area(): Double {
        val semiPerimeter = perimeter() / 2
        return sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3))
    }

    override fun perimeter(): Double {
        return side1 + side2 + side3
    }
}

fun main() {
    val circle = Circle(4.5)
    val rectangle = Rectangle(7.0, 11.0)
    val triangle = Triangle(4.0, 5.0, 6.0)

    val shapes = listOf(circle, rectangle, triangle)

    shapes.forEach { println("$it -> area=${it.area()}, perimeter=${it.perimeter()}")}
}