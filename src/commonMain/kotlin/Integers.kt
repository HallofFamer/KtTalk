package com.mysidia.kttalk

import kotlin.math.*

fun Int.timesRepeat(lambda: (Int) -> Unit){
    var i = 1
    while(i <= this){
        lambda(i)
        i++
    }
}

fun Int.even(): Boolean{
    return this % 2 == 0
}

fun Int.odd(): Boolean{
    return this % 2 != 0
}

fun Int.factorial(): Int{
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

fun Int.abs(): Int{
    return kotlin.math.abs(this)
}
