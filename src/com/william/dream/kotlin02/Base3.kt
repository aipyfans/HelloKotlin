package com.william.dream.kotlin02

import java.util.*

interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

/**
 * 合并类型检查和自动转换
 */
fun eval(e: Expr): Int {

    if (e is Num) {
        return e.value
    }

    if (e is Sum) {
        return eval(e.left) + eval(e.right)
    }

    throw IllegalArgumentException("Unknown expression")

}


/**
 * 使用有返回值的if表达式
 */
fun eval2(e: Expr): Int =
        if (e is Num) {
            e.value
        } else if (e is Sum) {
            eval(e.left) + eval(e.right)
        } else {
            throw IllegalArgumentException("Unknown expression")
        }


/**
 * 用when代替if
 */
fun eval3(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval(e.left) + eval(e.right)
            else -> throw IllegalArgumentException("Unknown expression")
        }

/**
 * 代码块作为"if"和"when"的分支
 */
fun evalWithLogging(e: Expr): Int =
        when (e) {
            is Num -> {
                println("num : ${e.value}")
                e.value
            }

            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sum : $left + $right")
                left + right
            }

            else -> throw IllegalArgumentException("Unknown expression")
        }

/**
 * "while"循环和"for"循环
 */
fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun forWhile() {
    // one
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
    println()

    // two
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }
    println()

    // three
    var i = 0
    while (i in 1..100) {
        print(fizzBuzz(i))
        i++
    }
    println()

    // four
    i = 0
    do {
        print(fizzBuzz(i))
        i++
    } while (i in 1..10)
    println()

}

/**
 * 迭代map
 */
fun iterableMap() {

    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    // 跟踪当前项的下标
    val list = arrayListOf("10","11","12")
    for ((index,element) in list.withIndex()){
        println("$index : $element")
    }
}

/**
 * 使用in检查区间成员
 */
fun isLetter(c:Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c:Char) = c !in '0'..'9'

/**
 * in运算符和！in也适用于When表达式
 */
fun recognize(c:Char) = when(c){
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z' , in 'A'..'Z' -> "It's a letter!"
    else -> "I don't known..."
}


fun main(args: Array<String>) {

    println(eval(Sum(Sum(Num(1), Num(2)), Num(5))))
    println(eval2(Sum(Sum(Num(1), Num(2)), Num(5))))
    println(eval3(Sum(Sum(Num(1), Num(2)), Num(5))))
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(5))))

    println(forWhile())
    iterableMap()

    println(isLetter('Q'))
    println(isNotDigit('r'))

    println(recognize('2'))
    println(recognize('o'))
    println(recognize('#'))

}