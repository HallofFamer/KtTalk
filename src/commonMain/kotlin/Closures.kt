package com.mysidia.kttalk

typealias Predicate = () -> Boolean
typealias Block = () -> Unit
typealias Closure = () -> Any?

/**
 * evaluates the supplied code block as long as the receiver predicate evaluates to true.
 *
 * @param code block of code to execute while the predicate evaluates to true
 */
infix fun Predicate.whileTrue(code: Block) {
    if(this()){
        code()
        this whileTrue code
    }
}

/**
 * evaluates the supplied code block as long as the receiver predicate evaluates to false.
 *
 * @param code block of code to execute while the predicate evaluates to false
 */
infix fun Predicate.whileFalse(code: Block){
    if(!this()){
        code()
        this whileFalse code
    }
}

/**
 * evaluates the supplied code block regardless of whether the receiver block executes successfully.
 *
 * @param code block of code to execute always
 */
inline infix fun Block.ensure(code: Block){
    try{
        this()
    }
    finally{
        code()
    }
}

/**
 * evaluates the supplied code block regardless of whether the receiver closure executes successfully.
 *
 * @param code block of code to execute always
 * @return Any?
 */
inline infix fun Closure.ensure(code: Block): Any? {
    try{
        return this()
    }
    finally{
        code()
    }
}

/**
 * evaluates the supplied code block if the receiver block execution fails with error/exception.
 *
 * @param code block of code to execute if error happens
 */
inline infix fun Block.ifCurtailed(code: Block){
    try{
        this()
    }
    catch(ex: Throwable){
        code()
        throw ex
    }
}

/**
 * evaluates the supplied code block if the receiver closure execution fails with error/exception.
 *
 * @param code block of code to execute if error happens
 * @return Any?
 */
inline infix fun Closure.ifCurtailed(code: Block) : Any?{
    try{
        return this()
    }
    catch(ex: Throwable){
        code()
        throw ex
    }
}

/**
 * evaluates the supplied code block if the receiver block execution throws an exception of type T.
 *
 * @param T generic parameter which must implements Throwable interface
 * @param code block of code to execute if caught Exception of type T
 */
inline fun <reified T: Throwable> Block.on(code: (T) -> Unit){
    try{
        this()
    }
    catch(ex: Throwable){
        if(ex is T) code(ex)
        else throw ex
    }
}

/**
 * evaluates the supplied code block if the receiver block execution throws an exception of type T.
 *
 * @param T generic parameter which must implements Throwable interface
 * @param code block of code to execute if caught Exception of type T
 * @return Any?
 */
inline fun <reified T : Throwable> Closure.on(code: (T) -> Unit) : Any?{
    return try{
        this()
    }
    catch(ex: Throwable){
        if(ex is T) code(ex)
        else throw ex
    }
}

/**
 * evaluates the supplied code block if the receiver block execution throws an exception of type T, and always evaluates the second code block.
 *
 * @param T generic parameter which must implements Throwable interface
 * @param code block of code to execute if caught Exception of type T
 * @param ensure block of code to always execute
 */
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

/**
 * evaluates the supplied code block if the receiver closure execution throws an exception of type T, and always evaluates the second code block.
 *
 * @param T generic parameter which must implements Throwable interface
 * @param code block of code to execute if caught Exception of type T
 * @param ensure block of code to always execute
 * @return Any?
 */
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