package com.william.dream.kotlin02

import kotlin.math.min

/**
 * 枚举类-不带属性和方法
 */
enum class Color {
    RED, GREEN, BLUE
}


/**
 * 枚举类-带有属性和方法
 */
enum class Color2(val r: Int, val g: Int, val b: Int) {

    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255);

    fun rgb() = (r * 256 + g) * 256 + b

}


/**
 * 使用when处理枚举类
 */
fun getMnenonic(color: Color) =
        when (color) {
            Color.RED -> "Richard"
            Color.GREEN -> "Gave"
            Color.BLUE -> "Battle"
        }


/**
 * 使用when处理枚举类
 * 在一个when分支上合并多个选项
 */
fun getMnenonic2(color: Color) =
        when (color) {
            Color.RED, Color.GREEN -> "Richard@Gave"
            Color.BLUE -> "Battle"
        }

/**
 * 在when结构中使用任意对象
 */
fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(Color.RED, Color.GREEN) -> Color.BLUE
            setOf(Color.GREEN, Color.BLUE) -> Color.RED
            setOf(Color.BLUE, Color.RED) -> Color.GREEN
            else -> throw Exception("Dirty color")
        }


/**
 * 使用不带参数的when
 */
fun mixOptimized(c1: Color, c2: Color) =
        when {
            (c1 == Color.RED && c2 == Color.GREEN) || (c1 == Color.GREEN && c2 == Color.RED) -> Color.BLUE
            (c1 == Color.GREEN && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.GREEN) -> Color.RED
            (c1 == Color.BLUE && c2 == Color.RED) || (c1 == Color.RED && c2 == Color.BLUE)-> Color.GREEN
            else -> throw Exception("Dirty color")
        }

fun main(args: Array<String>) {

    println("------------------------------------------------------------")
    println(getMnenonic(Color.BLUE))
    println(getMnenonic2(Color.GREEN))
    println("------------------------------------------------------------")
    println(mix(Color.BLUE, Color.RED))
    println(mixOptimized(Color.BLUE, Color.RED))
    println("------------------------------------------------------------")

}