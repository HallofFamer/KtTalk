package com.mysidia.kttalk

fun Any?.isNull() : Boolean{
    return (this == null)
}

inline infix fun Any?.ifNull(block: Block){
    if(this == null) block()
}

inline infix fun Any?.ifNotNull(block: Block){
    if(this != null) block()
}

inline fun Any?.ifNull(block: Block, otherwise: Block){
    if(this == null) block()
    else otherwise()
}

inline fun Any?.ifNotNull(block: Block, otherwise: Block){
    if(this != null) block()
    else otherwise()
}