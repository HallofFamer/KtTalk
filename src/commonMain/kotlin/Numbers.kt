package com.mysidia.kttalk

import kotlin.math.*

fun Number.abs(): Double{
    return abs(this.toDouble())
}

fun Number.arcCos(): Double{
    return acos(this.toDouble())
}

fun Number.arcCosh(): Double{
    return acosh(this.toDouble())
}

fun Number.arcSin(): Double{
    return asin(this.toDouble())
}

fun Number.arcSinh(): Double{
    return asinh(this.toDouble())
}

fun Number.arcTan(): Double{
    return atan(this.toDouble())
}

fun Number.arcTan(x: Number): Double{
    return atan2(this.toDouble(), x.toDouble())
}

fun Number.arcTanh(): Double{
    return atanh(this.toDouble())
}

fun Number.ceil(): Double{
    return ceil(this.toDouble())
}

fun Number.cos(): Double{
    return cos(this.toDouble())
}

fun Number.cosh(): Double{
    return cosh(this.toDouble())
}

fun Number.exp(): Double{
    return exp(this.toDouble())
}

fun Number.floor(): Double{
    return floor(this.toDouble())
}

fun Number.hypot(that: Number): Double{
    return hypot(this.toDouble(), that.toDouble())
}

fun Number.ln(): Double{
    return ln(this.toDouble())
}

fun Number.log(): Double{
    return log10(this.toDouble())
}

fun Number.log(x: Number): Double{
    return log(this.toDouble(), x.toDouble())
}

fun Number.reciprocal(): Double{
    return 1 / this.toDouble()
}

fun Number.round(): Double{
    return round(this.toDouble())
}

fun Number.round(numDigits: Int) : Double{
    val factor = 10.0.pow(numDigits.toDouble())
    return (this.toDouble() * factor).roundToInt() / factor
}

fun Number.sin(): Double{
    return sin(this.toDouble())
}

fun Number.sinh(): Double{
    return sinh(this.toDouble())
}

fun Number.sqrt(): Double{
    return sqrt(this.toDouble())
}

fun Number.squared(): Double{
    return this.toDouble().pow(2)
}

fun Number.tan(): Double{
    return tan(this.toDouble())
}

fun Number.tanh(): Double{
    return tanh(this.toDouble())
}

fun Number.step(to: Number, lambda: (Number) -> Unit){
    this.step(to, 1, lambda)
}

fun Number.step(to: Number, step: Number, lambda: (Number) -> Unit){
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