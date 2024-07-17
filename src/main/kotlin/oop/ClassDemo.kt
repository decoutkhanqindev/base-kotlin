package oop

class Human1 {
    // property
    private var name: String
    private var year: Int

    // constructor
    constructor(name: String, year: Int) {
        this.name = name
        this.year = year
    }

    // method / function
    fun printIn4() {
        println("Human1: name = $name, year = $year")
    }
}

// primary constructor
class Student1(id: Int = 0, name: String = "", year: Int = 0) {
    // property
    private var _id: Int = id
    private var _name: String = name
    private var _year: Int = year

    // getter va setter
    var id: Int = _id
        get() = field
        set(value) {
            field = value
        }

    var name: String = _name
        get() = field
        set(value) {
            field = value
        }

    var year: Int = _year
        get() = field
        set(value) {
            field = value
        }

    fun printIn4() {
        println("Student1: id = $id, name = $name, year = $year")
    }
}

// open de cac class khac co the ke thua
open class Human2(open var name: String, open var year: Int) {

    open fun printIn4() {
        println("Human2: name = $name, year = $year")
    }
}

// ke thua
class Student2(
    id: Int = 0,
    name: String = "",
    year: Int = 0
) : Human2(name, year) {

    var id: Int = id
        get() = field
        set(value) {
            field = value
        }


    override var name: String = name
        get() = field
        set(value) {
            field = value
        }

    override var year: Int = year
        get() = field
        set(value) {
            field = value
        }

    // override
    override fun printIn4() {
        print("Student2: id = $id, ")
        super.printIn4()
    }
}

// truu tuong
interface People1 {
    var name: String
    var year: Int

    fun printIn4()
}

abstract class People2 {
    private lateinit var name: String
    private var year: Int = 0

    fun printIn4() {
        println("People2: name = $name, year = $year")
    }
}

class Teacher(name: String, year: Int) : People1 {
    // getter va setter
    override var name: String = name
        get() = field
        set(value) {
            field = value
        }

    override var year: Int = year
        get() = field
        set(value) {
            field = value
        }

    override fun printIn4() {
        println("Teacher: name = $name, year = $year")
    }

    // static method
    // goi fun ma khong can tao doi tuong
    companion object {
        fun doubleYear(t: Teacher): Teacher {
            return Teacher(t.name, t.year * 2)
        }
    }
}

// enum la 1 tap hop cac hang so
enum class LoadingStatus {
    Init, Loading, Error, Done
}

sealed class Human3(private var name: String, private var year: Int) {
    class DefaultValue : Human3("Default name", 10)

    fun printIn4() {
        println("Human3: name = $name, year = $year")
    }
}

// data class là một loại lớp đặc biệt được thiết kế để lưu trữ dữ liệu. Các lớp dữ liệu
// tự động cung cấp một số phương thức tiện ích như equals(), hashCode(), toString(), copy(),
// và các phương thức componentN() dựa trên các thuộc tính của lớp.
data class Human4(private var name: String, private var year: Int) //data json, xml