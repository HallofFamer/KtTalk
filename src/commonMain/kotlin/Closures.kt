package com.mysidia.kttalk

typealias Predicate = () -> Boolean
typealias Block = () -> Unit

infix fun Predicate.whileTrue(code: Block) {
    if(this()){
        code()
        this whileTrue code
    }
}

infix fun Predicate.whileFalse(code: Block){
    if(!this()){
        code()
        this whileFalse code
    }
}

inline infix fun Block.ensure(code: Block){
    try{
        this()
    }
    finally{
        code()
    }
}

inline fun Block.ifCurtailed(code: Block){
    try{
        this()
    }
    catch(ex: Throwable){
        code()
    }
}

inline fun <reified T: Throwable> Block.on(code: (T) -> Unit){
    try{
        this()
    }
    catch(ex: Throwable){
        if(ex is T) code(ex)
        else throw ex
    }
}

inline fun <reified T: Throwable> Block.on(code: (T) -> Unit, ensure: Block){
    try{
        this()
    }
    catch(ex: Throwable){
        if(ex is T) code(ex)
        else throw ex
    }
    finally{
        ensure()
    }
}