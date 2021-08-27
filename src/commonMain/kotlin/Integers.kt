package com.mysidia.kttalk

import kotlin.math.*

fun Int.abs(): Int{
    return abs(this)
}

fun Int.even(): Boolean{
    return this % 2 == 0
}

fun Int.factorial(): Int{
    if(this < 0) throw ArithmeticException("Cannot compute factorial of negative integers.")
    var i = 1
    var product = 1
    while(i <= this){
        product *= i
        i++
    }
    return product
}

fun Int.gcd(that: Int): Int{
    if(that == 0) return this
    return that.gcd(this % that)
}

fun Int.gcd(that: Long): Long{
    if(that == 0L) return this.toLong()
    return that.gcd(this % that)
}

fun Int.lcm(that: Int): Int{
    return this / this.gcd(that) * that
}

fun Int.lcm(that: Long): Long{
    return this.toLong() / this.toLong().gcd(that) * that
}

fun Int.odd(): Boolean{
    return this % 2 != 0
}

inline infix fun Int.timesRepeat(lambda: (Int) -> Unit){
    var i = 1
    while(i <= this){
        lambda(i)
        i++
    }
}

inline fun Int.upTo(that: Int, lambda: (Int) -> Unit){
    var i = this
    while(i <= that){
        lambda(i)
        i++
    }
}

inline fun Int.downTo(that: Int, lambda: (Int) -> Unit){
    var i = this
    while(i >= that){
        lambda(i)
        i--
    }
}