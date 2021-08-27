package com.mysidia.kttalk

import kotlin.math.*

fun Long.abs(): Long{
    return abs(this)
}

fun Long.even(): Boolean{
    return this % 2 == 0L
}

fun Long.factorial(): Long{
    if(this < 0L) throw ArithmeticException("Cannot compute factorial of negative integers.")
    var i = 1L
    var product = 1L
    while(i <= this){
        product *= i
        i++
    }
    return product
}

fun Long.gcd(that: Int): Long{
    if(that == 0) return this
    return that.toLong().gcd(this % that)
}

fun Long.gcd(that: Long): Long{
    if(that == 0L) return this
    return that.gcd(this % that)
}

fun Long.lcm(that: Int): Long{
    return this / this.gcd(that) * that
}

fun Long.lcm(that: Long): Long{
    return this / this.gcd(that) * that
}

fun Long.odd(): Boolean{
    return this % 2 != 0L
}

inline infix fun Long.timesRepeat(lambda: (Long) -> Unit){
    var i = 1L
    while(i <= this){
        lambda(i)
        i++
    }
}

inline fun Long.upTo(that: Long, lambda: (Long) -> Unit){
    var i = this
    while(i <= that){
        lambda(i)
        i++
    }
}

inline fun Long.downTo(that: Long, lambda: (Long) -> Unit){
    var i = this
    while(i >= that){
        lambda(i)
        i--
    }
}