package com.mysidia.kttalk

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ClosuresTest {

    private val list = listOf(1, 2, 3, 4, 5)
    private var message = ""
    private var message2 = ""

    @Test
    fun testWhileTrue(){
        var sum = 0
        var i = 0
        { i < 5 } whileTrue {
            sum += list[i]
            i++
        }
        assertEquals(sum, 15)
    }

    @Test
    fun testWhileFalse(){
        var sum = 0
        var i = 4
        { i < 0 } whileFalse {
            sum += list[i]
            i--
        }
        assertEquals(sum, 15)
    }

    @Test
    fun testEnsure(){
        var message = ""
        var i = 0
        { i = list[0] + list[1] } ensure {
            message = "executed without exception"
        }
        assertEquals(message, "executed without exception")

        assertFailsWith<ArithmeticException> {
            { list[2] / 0 } ensure {
                message = "executed despite exception"
            }
        }
        assertEquals(message, "executed despite exception")
    }

    @Test
    fun testIfCurtailed(){
        var message = ""
        var i = 0
        { i = list[0] + list[1] } ifCurtailed {
            message = "executed with exception"
        }
        assertEquals(message, "")

        assertFailsWith<ArithmeticException> {
            { list[2] / 0 } ifCurtailed {
                message = "executed with exception"
            }
        }
        assertEquals(message, "executed with exception")
    }

    @Test
    fun testOn(){
        var message = ""
        var i = 0
        { i = list[0] + list[1] }.on<ArithmeticException> { message = "caught exception ${it::class.simpleName}"}
        assertEquals(message, "");

        { list[2] / 0 }.on<ArithmeticException>{ message = "caught exception ${it::class.simpleName}"}
        assertEquals(message, "caught exception ArithmeticException")
    }

    @Test
    fun testOnEnsureForBlock() {
        var i = 0
        { i = list[0] + list[1] }.on<ArithmeticException>({
            message = "caught exception ${it::class.simpleName}"
        }, ensure = {
            message2 = "executed without exception"
        })
        assertEquals(message, "")
        assertEquals(message2, "executed without exception")
    }

    @Test
    fun testOnEnsureForClosure(){
        { list[2] / 0 }.on<ArithmeticException>({
            message = "caught exception ${it::class.simpleName}"
        }, ensure = {
            message2 = "executed without exception"
        })
        assertEquals(message, "caught exception ArithmeticException")
        assertEquals(message2, "executed without exception")
    }
}