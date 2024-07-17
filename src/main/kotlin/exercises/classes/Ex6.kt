package exercises.classes

// Write a Kotlin program that creates a class 'BankAccount' with properties for account number, balance, and account holder name. Include deposit and withdrawal functions.
class BankAccount(val accNum: String, var balance: Double, val accHolderName: String) {
    override fun toString(): String {
        return "BankAccount(accNum=$accNum, balance=$balance, accHolderName='$accHolderName')"
    }

    fun deposit(amount: Double): Unit {
        balance += amount
        println("Deposit of $amount successful. New balance: $balance")
    }

    fun withdrawal(amount: Double) {
        if (amount >= balance) println("Insufficient balance ($balance). Withdrawal ($amount) failed.")
        balance -= amount
        println("Withdrawal of $amount successful. New balance: $balance")
    }
}

fun main() {
    val account = BankAccount("SB-12340", 2000.0, "Lotte Nazir")

    println(account.toString())

    account.deposit(500.0)
    account.withdrawal(400.0)
    account.withdrawal(2500.0)
}