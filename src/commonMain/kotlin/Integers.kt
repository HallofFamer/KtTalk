package com.mysidia.kttalk

import kotlin.math.*

/**
 * computes the absolute value of the receiver integer.
 *
 * @receiver Int
 * @return Int
 */
fun Int.abs(): Int{
    return abs(this)
}

/**
 * checks if the receiver integer is even number.
 *
 * @receiver Int
 * @return Boolean
 */
fun Int.even(): Boolean{
    return this % 2 == 0
}

/**
 * computes the factorial of the receiver integer.
 *
 * @receiver Int
 * @return Int
 * @throws ArithmeticException
 */
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

/**
 * finds the greatest common divisor of two integers.
 *
 * @receiver Int
 * @param that the other number
 * @return Int
 */
fun Int.gcd(that: Int): Int{
    if(that == 0) return this
    return that.gcd(this % that)
}

/**
 * finds the greatest common divisor of two integers.
 *
 * @receiver Int
 * @param that the other number
 * @return Long
 */
fun Int.gcd(that: Long): Long{
    if(that == 0L) return this.toLong()
    return that.gcd(this % that)
}

/**
 * finds the least common multiple of two integers.
 *
 * @receiver Int
 * @param that the other number
 * @return Int
 */
fun Int.lcm(that: Int): Int{
    return this / this.gcd(that) * that
}

/**
 * finds the least common multiple of two integers.
 *
 * @receiver Int
 * @param that the other number
 * @return Long
 */
fun Int.lcm(that: Long): Long{
    return this.toLong() / this.toLong().gcd(that) * that
}

/**
 * checks if the receiver integer is odd number.
 *
 * @receiver Int
 * @return Boolean
 */
fun Int.odd(): Boolean{
    return this % 2 != 0
}

/**
 * evaluates the supplied lambda block as many times as the receiver integer.
 *
 * @receiver Int
 * @param lambda a lambda expression to evaluate
 */
inline infix fun Int.timesRepeat(lambda: (Int) -> Unit){
    var i = 1
    while(i <= this){
        lambda(i)
        i++
    }
}

/**
 * evaluates the supplied lambda block with the cursor starting at the receiver integer until it reaches the ending integer, step size is 1.
 *
 * @receiver Int
 * @param that the upper limit
 * @param lambda lambda expression to evaluate until reaching upper limit
 */
inline fun Int.upTo(that: Int, lambda: (Int) -> Unit){
    var i = this
    while(i <= that){
        lambda(i)
        i++
    }
}

/**
 * evaluates the supplied lambda block with the cursor starting at the receiver integer until it reaches the ending integer, step size is -1.
 *
 * @receiver Int
 * @param that the lower limit
 * @param lambda lambda expression to evaluate until reaching lower limit
 */
inline fun Int.downTo(that: Int, lambda: (Int) -> Unit){
    var i = this
    while(i >= that){
        lambda(i)
        i--
    }
}