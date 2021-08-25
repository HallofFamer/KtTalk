package com.mysidia.kttalk

typealias Predicate = () -> Boolean
typealias Block = () -> Unit
typealias Closure = () -> Any?

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

inline infix fun Closure.ensure(code: Block): Any? {
    try{
        return this()
    }
    finally{
        code()
    }
}

inline infix fun Block.ifCurtailed(code: Block){
    try{
        this()
    }
    catch(ex: Throwable){
        code()
        throw ex
    }
}

inline infix fun Closure.ifCurtailed(code: Block) : Any?{
    try{
        return this()
    }
    catch(ex: Throwable){
        code()
        throw ex
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

inline fun <reified T : Throwable> Closure.on(code: (T) -> Unit) : Any?{
    return try{
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

inline fun <reified T: Throwable> Closure.on(code: (T) -> Unit, ensure: Block) : Any?{
    return try{
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