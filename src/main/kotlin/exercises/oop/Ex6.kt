package exercises.oop

// Write a Kotlin object-oriented program that creates an interface Observable with methods subscribe and unsubscribe.
// Implement it in a class Publisher to allow objects to subscribe and unsubscribe from events.

interface Observable {
    fun subscribe(observer: Observer): Boolean
    fun unSubscribe(observer: Observer): Boolean
}

interface Observer {
    fun update(message: String)
}

class Publisher : Observable {
    private val observers = mutableListOf<Observer>()

    init {
        println("Publisher is created !!!")
    }

    override fun subscribe(observer: Observer): Boolean {
        println("Observer ${observer.javaClass.simpleName} subscribed.")
        return observers.add(observer)
    }

    override fun unSubscribe(observer: Observer): Boolean {
        println("Observer ${observer.javaClass.simpleName} unsubscribed.")
        return observers.remove(observer)
    }

    fun publishMessage(message: String) {
        println("Publishing message: $message")
        observers.forEach { it.update(message) }
    }
}

class EmailNotification : Observer {
    override fun update(message: String) {
        println("Email notification received: $message")
    }
}

class SMSNotification : Observer {
    override fun update(message: String) {
        println("SMS notification received: $message")
    }
}

fun main() {
    val publisher = Publisher()

    val emailNotification = EmailNotification()
    val smsNotification = SMSNotification()

    publisher.subscribe(emailNotification)
    publisher.subscribe(smsNotification)

    publisher.publishMessage("Hello")

    publisher.unSubscribe(emailNotification)

    publisher.publishMessage("Goodbye, subscribers!")
}