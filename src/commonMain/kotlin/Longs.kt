package com.mysidia.kttalk

import kotlin.math.*

/**
 * computes the absolute value of the receiver integer.
 *
 * @receiver Long
 * @return Long
 */
fun Long.abs(): Long{
    return abs(this)
}

/**
 * checks if the receiver integer is even number.
 *
 * @receiver Long
 * @return Boolean
 */
fun Long.even(): Boolean{
    return this % 2 == 0L
}

/**
 * computes the factorial of the receiver integer.
 *
 * @receiver Long
 * @return Long
 * @throws ArithmeticException
 */
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

/**
 * finds the greatest common divisor of two integers.
 *
 * @receiver Long
 * @param that the other number
 * @return Long
 */
fun Long.gcd(that: Int): Long{
    if(that == 0) return this
    return that.toLong().gcd(this % that)
}

/**
 * finds the greatest common divisor of two integers.
 *
 * @receiver Long
 * @param that the other number
 * @return Long
 */
fun Long.gcd(that: Long): Long{
    if(that == 0L) return this
    return that.gcd(this % that)
}

/**
 * finds the least common multiple of two integers.
 *
 * @receiver Long
 * @param that the other number
 * @return Long
 */
fun Long.lcm(that: Int): Long{
    return this / this.gcd(that) * that
}

/**
 * finds the least common multiple of two integers.
 *
 * @receiver Long
 * @param that the other number
 * @return Long
 */
fun Long.lcm(that: Long): Long{
    return this / this.gcd(that) * that
}

/**
 * checks if the receiver integer is odd number.
 *
 * @receiver Long
 * @return Boolean
 */
fun Long.odd(): Boolean{
    return this % 2 != 0L
}

/**
 * evaluates the supplied lambda block as many times as the receiver integer.
 *
 * @receiver Long
 * @param lambda a lambda expression to evaluate
 */
inline infix fun Long.timesRepeat(lambda: (Long) -> Unit){
    var i = 1L
    while(i <= this){
        lambda(i)
        i++
    }
}

/**
 * evaluates the supplied lambda block with the cursor starting at the receiver integer until it reaches the ending integer, step size is 1.
 *
 * @receiver Long
 * @param that the upper limit
 * @param lambda lambda expression to evaluate until reaching upper limit
 */
inline fun Long.upTo(that: Long, lambda: (Long) -> Unit){
    var i = this
    while(i <= that){
        lambda(i)
        i++
    }
}

/**
 * evaluates the supplied lambda block with the cursor starting at the receiver integer until it reaches the ending integer, step size is -1.
 *
 * @receiver Long
 * @param that the lower limit
 * @param lambda lambda expression to evaluate until reaching lower limit
 */
inline fun Long.downTo(that: Long, lambda: (Long) -> Unit){
    var i = this
    while(i >= that){
        lambda(i)
        i--
    }
}