package com.mysidia.kttalk

inline infix fun Boolean.ifTrue(block: Block){
    if(this) block()
}

inline infix fun Boolean.ifFalse(block: Block){
    if(!this) block()
}

inline fun Boolean.ifTrue(block: Block, ifFalse: Block){
    if(this) block()
    else ifFalse()
}

inline fun Boolean.ifFalse(block: Block, ifTrue: Block){
    if(!this) block()
    else ifTrue()
}