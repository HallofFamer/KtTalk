package com.mysidia.kttalk

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ClosuresTest {

    @Test
    fun testWhileTrue(){
        val list = listOf(1, 2, 3, 4, 5)
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
        val list = listOf(1, 2, 3, 4, 5)
        var sum = 0
        var i = 5
        { i > 0 } whileFalse {
            sum += list[i]
            i--
        }
        assertEquals(sum, 15)
    }
}