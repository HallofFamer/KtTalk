package com.mysidia.kttalk

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BooleansTest{

    @Test
    fun testIfTrue(){
        val list = listOf(1, 2, 3, 4, 5)
        var element : Int? = null
        list.contains(0) ifTrue { element = 2 }
        assertNull(element)
        list.contains(2) ifTrue { element = 2 }
        assertEquals(element, 2)
    }

    @Test
    fun testIfFalse(){
        val list = listOf(1, 2, 3, 4, 5)
        var element: Int? = null
        list.contains(1) ifFalse { element = 1 }
        assertNull(element)
        list.contains(0) ifFalse  { element = 0 }
        assertEquals(element, 0)
    }

    @Test
    fun testIfTrueIfFalse(){
        val list = listOf(1, 2, 3, 4, 5)
        var element1 = ""
        var element2 = ""
        list[0].odd().ifTrue({ element1 = "odd" }, ifFalse = { element1 = "even" })
        list[1].odd().ifTrue({ element2 = "odd" }, ifFalse = { element2 = "even" })
        assertEquals(element1, "odd")
        assertEquals(element2, "even")
    }

    @Test
    fun testIfFalseIfTrue(){
        val list = listOf(1, 2, 3, 4, 5)
        var element1 = ""
        var element2 = ""
        list[3].odd().ifFalse({ element1 = "odd" }, ifTrue = { element1 = "even" })
        list[4].odd().ifFalse({ element2 = "odd" }, ifTrue = { element2 = "even" })
        assertEquals(element1, "odd")
        assertEquals(element2, "even")
    }
}