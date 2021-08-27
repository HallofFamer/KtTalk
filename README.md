# KtTalk
A kotlin library that add smalltalk style methods to objects.

Smalltalk is a pure OO language in which everything is an object, and everything happens by sending messages(aka method calls). For this reason, it does not have built-in control structures, and you will achieve conditional branches and iterations/loops by calling methods. 

For example, if statements in smalltalk are implemented as sending message ifTrue: trueClosure ifFalse: falseClosure to a Boolean object:

```
(17 * 13 > 220) 
   ifTrue: [ Transcript show: ’17 x 13 is greater than 220’ ] 
// The true block will execute, prints "17 x 13 is greater than 220" on the transcript. 
```

Similarly, sending message whileTrue: block to a closure object achieves something similar to a while loop: 

```
n := 1. 
[ n < 1000 ] whileTrue: [ n := n*2 ]. 
// n is now 1024.
```

This is an elegant OO approach to handle the procedural control structures, combining the strength of OOP and FP. Unfortunately modern OO languages have abandoned this approach, and due to the language limitations its usually impossible to build such a userland library in the mainstream languages. The good new is that, it is actually possible to achieve such behaviors in Kotlin, thanks to its powerful language support for extension methods, trailing closures, infix function syntax and nonlocal return. With the KtTalk library, the above two smalltalk code can be written in Kotlin: 

```
(17 * 13 > 200) ifTrue { println("17 x 13 is greater than 220") }
var n = 1
{ n < 1000 } whileTrue { n = n * 2 }
```

As you see, Kotlin is a beautiful language that we can hope to write elegant code as we could in smalltalk. This library also provides other extension methods on Boolean, Number and Closure types. A full list will be provided below shortly. 

***Note***:
1. Due to the restriction of non-local return being inline methods only in Kotlin, it will not be possible to return from recursive methods such as *whileTrue* and *whileFalse* on Predicate objects. 
2. Unless an infix method is used, it is necessary to wrap integer values in parentheses when calling extension methods on them. This is not an issue with float/double values.