package oop

fun main() {
    val human1 = Human1("khang", 2003)
    human1.printIn4()

    val student1 = Student1()
    student1.id = 2
    student1.name = "minh"
    student1.year = 2003
    student1.printIn4()

    val student2 = Student2()
    student2.id = 1
    student2.name = "khang"
    student2.year = 2003
    student2.printIn4()

    val teacher = Teacher("thuy", 1980)
    teacher.printIn4()

    val doubleYearTeacher = Teacher.doubleYear(teacher)
    doubleYearTeacher.printIn4()

    val status = LoadingStatus.Loading
    println(status)

    Human3.DefaultValue().printIn4()

    val human4 = Human4("Khang", 2003)
    val human5 = human4.copy(name = "Minh")
    println(human5.toString())
}
