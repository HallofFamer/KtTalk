package com.mysidia.kttalk

/**
 * evaluates a block if the receiver is boolean true value, this is smalltalk's way of if statement.
 *
 * @param block block of code to execute if true
 */
inline infix fun Boolean.ifTrue(block: Block){
    if(this) block()
}

/**
 * evaluates a block if the receiver is boolean false value, this is smalltalk's way of unless statement.
 *
 * @param block block of code to execute if false
 */
inline infix fun Boolean.ifFalse(block: Block){
    if(!this) block()
}

/**
 * evaluates first block if the receiver is boolean true value, otherwise evaluates the second block, this is smalltalk's way of if...else statement.
 *
 * @param block block of code to execute if true
 * @param ifFalse block of code to execute if false
 */
inline fun Boolean.ifTrue(block: Block, ifFalse: Block){
    if(this) block()
    else ifFalse()
}

/**
 * evaluates first block if the receiver is boolean false value, otherwise evaluates the second block, this is smalltalk's way of unless...else statement.
 *
 * @param block block of code to execute if false
 * @param ifTrue block of code to execute if true
 */
inline fun Boolean.ifFalse(block: Block, ifTrue: Block){
    if(!this) block()
    else ifTrue()
}