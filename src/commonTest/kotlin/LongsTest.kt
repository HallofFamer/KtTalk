package com.mysidia.kttalk

import kotlin.test.*

class LongsTest {

    private val num = 1L
    private val num2 = 2L
    private val num3 = -5L

    @Test
    fun testAbs(){
        assertEquals(num.abs(), 1L)
        assertEquals(num2.abs(), 2L)
        assertEquals(num3.abs(), 5L)
    }

    @Test
    fun testEven(){
        assertFalse(num.even())
        assertTrue(num2.even())
        assertFalse(num3.even())
    }

    @Test
    fun testFactorial(){
        assertEquals(num.factorial(), 1L)
        assertEquals(num2.factorial(), 2L)
        assertEquals(num3.abs().factorial(), 120L)
        assertEquals((0L).factorial(), 1L)
        assertFailsWith<ArithmeticException> { (-1L).factorial() }
    }

    @Test
    fun testGcd(){
        assertEquals((6L).gcd(8L), 2L)
        assertEquals((6L).gcd(9), 3L)
        assertEquals(num.gcd(num2), 1L)
        assertEquals(num2.gcd(num3), -1L)
    }

    @Test
    fun testLcm() {
        assertEquals((3L).lcm(5L), 15L)
        assertEquals(6L.lcm(8), 24L)
        assertEquals(num.lcm(num2), 2L)
        assertEquals(num2.lcm(num3), 10L)
    }


    @Test
    fun testOdd(){
        assertTrue(num.odd())
        assertFalse(num2.odd())
        assertTrue(num3.odd())
    }

    @Test
    fun testTimesRepeat(){
        val list = mutableListOf<Long>()
        5L timesRepeat { list.add(it) }
        assertEquals(list[0], 1L)
        assertEquals(list[1], 2L)
        assertEquals(list[4], 5L)
        assertEquals(list.size, 5)
    }

    @Test
    fun testUpTo(){
        val list = mutableListOf<Long>()
        (2L).upTo(5L){ list.add(it) }
        assertEquals(list[0], 2L)
        assertEquals(list[1], 3L)
        assertEquals(list[3], 5L)
        assertEquals(list.size, 4)
    }

    @Test
    fun testDownTo(){
        val list = mutableListOf<Long>()
        (5L).downTo(3L) { list.add(it) }
        assertEquals(list[0], 5L)
        assertEquals(list[1], 4L)
        assertEquals(list[2], 3L)
        assertEquals(list.size, 3)
    }
}