# KtTalk
A kotlin library that adds smalltalk style methods to objects.

## Motivation
Smalltalk is a pure OO language in which everything is an object, and everything happens by sending messages(aka method calls). For this reason, it does not have built-in control structures, and you will achieve conditional branches and iterations/loops by calling methods. 

For example, if statements in smalltalk are implemented as sending message ifTrue: trueClosure ifFalse: falseClosure to a Boolean object:

```smalltalk
(17 * 13 > 220) 
   ifTrue: [ Transcript show: ’17 x 13 is greater than 220’ ] 
// The true block will execute, prints "17 x 13 is greater than 220" on the transcript. 
```

Similarly, sending message whileTrue: block to a closure object achieves something similar to a while loop: 

```smalltalk
n := 1. 
[ n < 1000 ] whileTrue: [ n := n*2 ]. 
// n is now 1024.
```

This is an elegant OO approach to handle the procedural control structures, combining the strength of OOP and FP. Unfortunately modern OO languages have abandoned this approach, and due to the language limitations its usually impossible to build such a userland library in the mainstream languages. The good new is that, it is actually possible to achieve such behaviors in Kotlin, thanks to its powerful language support for extension methods, trailing closures, infix function syntax and nonlocal return. With the KtTalk library, the above two smalltalk code can be written in Kotlin: 

```kotlin
(17 * 13 > 200) ifTrue { println("17 x 13 is greater than 220") }
var n = 1
{ n < 1000 } whileTrue { n = n * 2 }
```

As you see, Kotlin is a beautiful language that we can hope to write elegant code as we could in smalltalk. This library also provides other extension methods on Any, Boolean, Number and Closure types.


## More Examples
The last section already provides two simple examples of achieving smalltalk-style if and while statement, but there are much more than that. You can use the method ifNull(block) on Any? and it will evaluates the supplied block if the receiver is null:

```Kotlin
val p = Person()
p.name ifNull { throw Exception("An error occurred, the person does not have a name yet!") }
```

Smalltalk actively uses such methods to handle error conditions at the absence of a value/property. To me, this is a rather elegant way to throw an exception based on certain conditions, compared to writing lots of if checks. 

On the other hand, you can use call the method timesRepeat(block) on an integer object i to evaluate the provided block of code i times:

```Kotlin
val i = 5
i timesRepeat { println("Iteration: ${it}") }
```

It will print the line 5 times with the value of **it** ranging from 1 to 5. Similarly, there are methods upTo(to, block), downTo(to, block) and step(to, stepsize, block) that you can use for number objects. They are more elegant than writing traditional for loops(well Kotlin does not have C style for loops anyway), and thanks to Kotlin's support for trailing closures the code looks nice even for methods accepting multiple arguments.

If you wonder how smalltalk handles exceptions, well, this is not rocket science either. There are such methods you can call on a block/closure object, as the below code snipper demonstrates:

```Kotlin
val i = 5
{ i / 0 }.on<ArithmeticException> { println("Cannot divide a number by 0") }
```

This will attempt to evaluate the receiver block/closure object, which may throw an ArithmeticException. If this exception is thrown, catches it and evaluates another block. This look stunningly similar to a traditional try...catch statement, doesnt it?

Now we can see clearly that we may not need any control structures at all in a highly expressive/elegant programming language, as it is possible to implement all of them as methods on receiver objects. I quite like the notion of 'receiver' in Kotlin language, which reminds me of Smalltalk's idea of 'sending messages to receiver objects'. 


## How to use? 
This library is open source, and you may simply download it and build it with gradle. On the other hand, I've uploaded the pre-built .jar files in the directory /build/lib. Just add them to the class library of your Kotlin project and you are good to go. These .jar files are for different platforms, and you may use any of them for the specific platform you are targeting. 

Unfortunately, kttalk is not currently on maven repository as I do not have an account with sonatype.org. This may change in future.


## Documentation
The documentation of this library is generated with the help of kdoc and dokka, visit the below link for the online version of the document:
http://kttalk.mysidiahost.com/


## Extension Methods List

The list of type alias and extension methods are provided below:

#### Type Alias
* `typealias Predicate` - `() -> Boolean`, a closure that evaluates to boolean value.
* `typealias Block` - `() -> Unit`, a closure that returns no value.
* `typealias Closure` - `() -> Any?`, a closure that returns any values.

#### Any? Methods
* `Any?.isNull() : Boolean` - checks if the receiver object is null.
* `inline infix Any?.ifNull(block: Block)` - evaluates a block if the receiver object is null.
* `inline infix Any?.ifNotNull(block: Block)` - evaluates a block if the receiver object is not null.
* `inline infix Any?.ifNull(block: Block, otherwise: Block)` - evaluates first block if receiver object is null, otherwise evaluates the second block.
* `inline infix Any?.ifNotNull(block: Block, otherwise: Block)` - evaluates first block if receiver object is not null, otherwise evaluates the second block.

#### Boolean Methods
* `inline infix Boolean.ifTrue(block: Block)` - evaluates a block if the receiver is boolean true value, this is smalltalk's way of if statement.
* `inline infix Boolean.ifFalse(block: Block)` - evaluates a block if the receiver is boolean false value, this is smalltalk's way of unless statement.
* `inline infix Boolean.ifTrue(block: Block, ifFalse: Block)` - evaluates first block if the receiver is boolean true value, otherwise evaluates the second block, this is smalltalk's way of if...else statement.
* `inline infix Boolean.ifFalse(block: Block, ifTrue: Block)` - evaluates first block if the receiver is boolean false value, otherwise evaluates the second block, this is smalltalk's way of unless...else statement.

#### Number Methods
* `Number.abs(): Double` - computes the absolute value of the receiver number.
* `Number.arcCos() : Double` - computes the arc cosine value of the receiver number.
* `Number.arcCosh() : Double` - computes the arc hyperbolic cosine value of the receiver number.
* `Number.arcSin() : Double` - computes the arc sine value of the receiver number.
* `Number.arcSinh() : Double` - computes the arc hyperbolic sine value of the receiver number.
* `Number.arcTan() : Double` - computes the arc tangent value of the receiver number.
* `Number.arcTanh(): Double` - computes the arc hyperbolic tangent value of the receiver number.
* `Number.ceil() : Double` - rounds to the next integer value greater than this receiver number.
* `Number.cos() : Double` - computes the cosine value of the receiver number.
* `Number.cosh() : Double` - computes the hyperbolic cosine value of the receiver number.
* `Number.exp() : Double` - computes the value of exp(x) where x is this receiver number.
* `Number.floor() : Double` - rounds to the next integer value less than this receiver number.
* `Number.hypot(that: Number) : Double` - computes the square root of the square of this receiver number with another number.
* `Number.ln(): Double` - computes the value of ln(x) where x is this receiver number.
* `Number.log() : Double` - computes the value of log(x) where x is this receiver number.
* `Number.reciprocal() : Double` - computes the reciprocal value of this receiver number.
* `Number.round(numDigits: Int) : Double` - rounds the receiver number to the supplied number of digits.
* `Number.sin() : Double` - computes the sine value of this receiver number.
* `Number.sinh() : Double` - computes the hyperbolic sine value of this receiver number.
* `Number.sqrt() : Double` - computes the square root of this receiver number.
* `Number.square() : Double` - computes the square of this receiver number.
* `Number.tan() : Double` - computes the tangent value of this receiver number.
* `Number.tanh() : Double` - computes the hyperbolic tangent value of this receiver number.
* `inline Number.step(to: Number, step: Number, lambda: (Number) -> Unit)` - evaluates the supplied lambda block with the cursor starting at the receiver number, until it reaches the ending number. The step size may be provided optionally(default to 1).  

#### Int/Long Methods
* `Int|Long.abs() : Int|Long` - computes the absolute value of the receiver integer.
* `Int|Long.even() : Boolean` - checks if the receiver integer is even number.
* `Int|Long.factorial() : Int|Long` - computes the factorial of the receiver integer.
* `Int|Long.gcd(that: Int|Long) : Int|Long` - finds the greatest common divisor of two integers.
* `Int|Long.lcm(that: Int|Long) : Int|Long` - finds the least common multiple of two integers.
* `Int|Long.odd() : Boolean` - checks if the receiver integer is odd number.
* `inline infix Int|Long.timesRepeat(lambda: (Int|Long) -> Unit)` - evaluates the supplied lambda block as many times as the receiver integer.
* `inline Int|Long.upTo(that: Int|Long, lambda: (Int|Long) -> Unit)` - evaluates the supplied lambda block with the cursor starting at the receiver integer until it reaches the ending integer, step size is 1.
* `inline Int|Long.downTo(that: Int|Long, lambda: (Int|Long) -> Unit)` - evaluates the supplied lambda block with the cursor starting at the receiver integer until it reaches the ending integer, step size is -1.

#### Block/Closure Methods
* `inline infix Predicate.whileTrue(code: Block)` - evaluates the supplied code block as long as the receiver predicate evaluates to true, this is smalltalk's way of while statement.
* `inline infix Predicate.whileFalse(code: Block)` - evaluates the supplied code block as long as the receiver predicate evaluates to false, this is smalltalk's way of until statement.
* `inline infix Block|Closure.ensure(code: Block) : Unit|Any?` - evaluates the supplied code block regardless of whether the receiver block/closure executes successfully, this is smalltalk's way of try...finally statement.
* `inline infix Block|Closure.ifCurtailed(code: Block) : Unit|Any?` - evaluates the supplied code block if the receiver block/closure execution fails with error/exception.
* `inline infix Block|Closure.on<T: Throwable>(code: (T) -> Unit)` - evaluates the supplied code block if the receiver block/closure execution throws an exception of type T, this is smalltalk's way of try...catch statement.
* `inline infix Block|Closure.on<T: Throwable>(code: (T) -> Unit, ensure: Block)` - evaluates the supplied code block if the receiver block/closure execution throws an exception of type T, and always evaluates the second code block, this is smalltalk's way of try...catch...finally statement.


## Contribution
Feel free to submit an issue or a PR if you have any suggestions about the library, whether it is an unidentified bug or a suggestion for improvement. 


## Notes:
1. Unless an infix method is used, it is necessary to wrap integer values in parentheses when calling extension methods on them. For instance, `3.odd()` is an error, but `(3).odd()` works. This is not an issue with float/double numbers.
2. Although this library is fun, I do not recommend using it in serious corporate/enterprise applications. It is however, good enough to use in personal and hobbyist projects, especially if you enjoy Smalltalk like I do.
