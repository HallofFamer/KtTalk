package com.mysidia.kttalk

import kotlin.math.*

/**
 * computes the absolute value of the receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.abs(): Double{
    return abs(this.toDouble())
}

/**
 * computes the arc cosine value of the receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.arcCos(): Double{
    return acos(this.toDouble())
}

/**
 * computes the arc hyperbolic cosine value of the receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.arcCosh(): Double{
    return acosh(this.toDouble())
}

/**
 * computes the arc sine value of the receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.arcSin(): Double{
    return asin(this.toDouble())
}

/**
 * computes the arc hyperbolic sine value of the receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.arcSinh(): Double{
    return asinh(this.toDouble())
}

/**
 * computes the arc tangent value of the receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.arcTan(): Double{
    return atan(this.toDouble())
}

/**
 * computes the arc tangent value between two numbers.
 *
 * @receiver Number
 * @param that another number
 * @return Double
 */
fun Number.arcTan(that: Number): Double{
    return atan2(this.toDouble(), that.toDouble())
}

/**
 * computes the arc hyperbolic tangent value of the receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.arcTanh(): Double{
    return atanh(this.toDouble())
}

/**
 * rounds to the next integer value greater than this receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.ceil(): Double{
    return ceil(this.toDouble())
}

/**
 * computes the cosine value of the receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.cos(): Double{
    return cos(this.toDouble())
}

/**
 * computes the hyperbolic cosine value of the receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.cosh(): Double{
    return cosh(this.toDouble())
}

/**
 * computes the value of exp(x) where x is this receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.exp(): Double{
    return exp(this.toDouble())
}

/**
 * rounds to the next integer value less than this receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.floor(): Double{
    return floor(this.toDouble())
}

/**
 * computes the square root of the square of this receiver number with another number.
 *
 * @receiver Number
 * @param that another number to compute the hypot value
 * @return Double
 */
fun Number.hypot(that: Number): Double{
    return hypot(this.toDouble(), that.toDouble())
}

/**
 * computes the value of ln(x) where x is this receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.ln(): Double{
    return ln(this.toDouble())
}

/**
 * computes the value of log(x) where x is this receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.log(): Double{
    return log10(this.toDouble())
}

/**
 * computes the value of log(x) where x is this receiver number, with supplied argument as base.
 *
 * @receiver Number
 * @param base the base for the logarithmic computation
 * @return
 */
fun Number.log(base: Number): Double{
    return log(this.toDouble(), base.toDouble())
}

/**
 * computes the reciprocal value of this receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.reciprocal(): Double{
    return 1 / this.toDouble()
}

/**
 * rounds the receiver number to the nearest integer.
 *
 * @receiver Number
 * @return Double
 */
fun Number.round(): Double{
    return round(this.toDouble())
}

/**
 * rounds the receiver number to the supplied number of digits.
 *
 * @receiver Number
 * @param numDigits number of digits to round to
 * @return Double
 */
fun Number.round(numDigits: Int) : Double{
    val factor = 10.0.pow(numDigits.toDouble())
    return (this.toDouble() * factor).roundToInt() / factor
}

/**
 * computes the sine value of this receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.sin(): Double{
    return sin(this.toDouble())
}

/**
 * computes the hyperbolic sine value of this receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.sinh(): Double{
    return sinh(this.toDouble())
}

/**
 * computes the square root of this receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.sqrt(): Double{
    return sqrt(this.toDouble())
}

/**
 * computes the square of this receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.squared(): Double{
    return this.toDouble().pow(2)
}

/**
 * computes the tangent value of this receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.tan(): Double{
    return tan(this.toDouble())
}

/**
 * computes the hyperbolic tangent value of this receiver number.
 *
 * @receiver Number
 * @return Double
 */
fun Number.tanh(): Double{
    return tanh(this.toDouble())
}

/**
 * evaluates the supplied lambda block with the cursor starting at the receiver number, until it reaches the ending number.
 * The step size defaults to 1.
 *
 * @receiver Number
 * @param to the ending number
 * @param lambda the lambda expression to execute until reaching the ending number
 *
 */
fun Number.step(to: Number, lambda: (Number) -> Unit){
    this.step(to, 1, lambda)
}

/**
 * evaluates the supplied lambda block with the cursor starting at the receiver number, until it reaches the ending number.
 *
 * @receiver Number
 * @param to the ending number
 * @param step the step size
 * @param lambda the lambda expression to execute until reaching the ending number
 * @throws IllegalArgumentException
 */
inline fun Number.step(to: Number, step: Number, lambda: (Number) -> Unit){
    if(step == 0) throw IllegalArgumentException("parameter step cannot be 0.")
    var current = this.toDouble()
    if(step.toDouble() > 0){
        while(current <= to.toDouble()){
            lambda(current)
            current += step.toDouble()
        }
    }
    else{
        while(current >= to.toDouble()){
            lambda(current)
            current += step.toDouble()
        }
    }
}