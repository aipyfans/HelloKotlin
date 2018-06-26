package com.william.dream.kotlin02


/**
 * 定义一个【无返回值】的函数
 */
fun helloWho(name: String) {
    println("Hello $name")
}


/**
 * 定义一个【有返回值】的函数
 */
fun maxOne(x: Int, y: Int): Int {
    return if (x > y) x else y
}


/**
 * 定义一个【有返回值】的函数
 */
fun maxTwo(x: Int, y: Int): Int = if (x > y) x else y


/**
 * 定义一个值对象的类
 */
class PersonOne(var name: String, var sex: Boolean) {

    override fun toString(): String {
        return "PersonOne(name='$name', sex=$sex)"
    }

}

/**
 * 定义一个带有默认属性的类
 */
class PersonTwo {

    var name: String = "Dream"

    var isMarried: Boolean = false

    override fun toString(): String {
        return "PersonTwo(name='$name', isMarried=$isMarried)"
    }

}

/**
 * 定义一个带有自定义访问器的类
 */
class Rectangle(val width: Int, val height: Int) {

    val isSquare: Boolean
        get() {
            return width == height
        }

    override fun toString(): String {
        return "Rectangle(width=$width, height=$height)"
    }

}


fun main(args: Array<String>) {

    println(helloWho("Kotlin"))
    println(maxOne(1,2))
    println(maxTwo(2,10))

    val personOne = PersonOne("William", true)
    println(personOne)

    val personTwo = PersonTwo()
    println(personTwo)

    val rectangle = Rectangle(200, 200)
    println(rectangle.isSquare)

}