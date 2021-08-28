package com.mysidia.kttalk

/**
 * checks if the receiver object is null.
 *
 * @return Boolean
 */
fun Any?.isNull() : Boolean{
    return (this == null)
}

/**
 * evaluates a block if the receiver object is null.
 *
 * @param block block of code to execute if null
 */
inline infix fun Any?.ifNull(block: Block){
    if(this == null) block()
}

/**
 * evaluates a block if the receiver object is not null.
 *
 * @param block block of code to execute if not null
 */
inline infix fun Any?.ifNotNull(block: Block){
    if(this != null) block()
}

/**
 * evaluates first block if receiver object is null, otherwise evaluates the second block.
 *
 * @param block block of code to execute if null
 * @param otherwise alternative block of code to execute if not null
 */
inline fun Any?.ifNull(block: Block, otherwise: Block){
    if(this == null) block()
    else otherwise()
}

/**
 * evaluates first block if receiver object is not null, otherwise evaluates the second block.
 *
 * @param block block of code to execute if not null
 * @param otherwise alternative block of code to execute if null
 */
inline fun Any?.ifNotNull(block: Block, otherwise: Block){
    if(this != null) block()
    else otherwise()
}