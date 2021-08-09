package com.mysidia.kttalk

import kotlin.math.*

fun Long.timesRepeat(lambda: (Int) -> Unit){
    var i = 1
    while(i <= this){
        lambda(i)
        i++
    }
}

fun Long.even(): Boolean{
    return this % 2 == 0L
}

fun Long.odd(): Boolean{
    return this % 2 != 0L
}

fun Long.factorial(): Long{
    var i = 1L;
    var product = 1L
    while(i <= this){
        product *= i
        i++;
    }
    return product;
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

fun Long.abs(): Long{
    return abs(this)
}