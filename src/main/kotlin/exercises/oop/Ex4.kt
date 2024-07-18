package exercises.oop

// Write a Kotlin object-oriented program that implements the decorator pattern by creating a base class Component
// and decorator classes BoldDecorator and ItalicDecorator to modify the behavior of the component.

// Interface Component xác định hành vi chung cho tất cả các component
interface Component {
    fun render(): String
}

// Class TextComponent impl interface Component, đại diện cho thành phần ban đầu.
class TextComponent : Component {
    override fun render(): String = "Kotlin OOP"
}

// abstract class TextDecorator impl interface Component, giu reference den component khac va la base class cho cac decorator
abstract class TextDecorator(private val component: Component) : Component {
    override fun render(): String = component.render()
}

// "BoldDecorator" và "ItalicDecorator" la cac subclasses cua TextDecorator
class BoldDecorator(component: Component) : TextDecorator(component) {
    override fun render(): String {
        return "<b>${super.render()}</b>"
    }
}

class ItalicDecorator(component: Component) : TextDecorator(component) {
    override fun render(): String {
        return "<i>${super.render()}</i>"
    }
}

fun main() {
    val originalComponent = TextComponent() // instance cua interface Component
    println(originalComponent.render())
    val boldDecorator = BoldDecorator(originalComponent)
    println(boldDecorator.render())
    val italicDecorator = ItalicDecorator(originalComponent)
    println(italicDecorator.render())
    val boldItalicDecorator = ItalicDecorator(BoldDecorator(originalComponent))
    println(boldItalicDecorator.render())
}