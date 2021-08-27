package com.mysidia.kttalk

import kotlin.test.*

class IntegersTest {

    private val num = 1
    private val num2 = 2
    private val num3 = -5

    @Test
    fun testAbs(){
        assertEquals(num.abs(), 1)
        assertEquals(num2.abs(), 2)
        assertEquals(num3.abs(), 5)
    }

    @Test
    fun testEven(){
        assertFalse(num.even())
        assertTrue(num2.even())
        assertFalse(num3.even())
    }

    @Test
    fun testFactorial(){
        assertEquals(num.factorial(), 1)
        assertEquals(num2.factorial(), 2)
        assertEquals(num3.abs().factorial(), 120)
        assertEquals((0).factorial(), 1)
        assertFailsWith<ArithmeticException> { (-1).factorial() }
    }

    @Test
    fun testGcd(){
        assertEquals((6).gcd(8), 2)
        assertEquals((6).gcd(9L), 3)
        assertEquals(num.gcd(num2), 1)
        assertEquals(num2.gcd(num3), -1)
    }

    @Test
    fun testLcm() {
        assertEquals((3).lcm(5), 15)
        assertEquals(6.lcm(8L), 24)
        assertEquals(num.lcm(num2), 2)
        assertEquals(num2.lcm(num3), 10)
    }

    @Test
    fun testOdd(){
        assertTrue(num.odd())
        assertFalse(num2.odd())
        assertTrue(num3.odd())
    }

    @Test
    fun testTimesRepeat(){
        val list = mutableListOf<Int>()
        5 timesRepeat { list.add(it) }
        assertEquals(list[0], 1)
        assertEquals(list[1], 2)
        assertEquals(list[4], 5)
        assertEquals(list.size, 5)
    }

    @Test
    fun testUpTo(){
        val list = mutableListOf<Int>()
        (2).upTo(5){ list.add(it) }
        assertEquals(list[0], 2)
        assertEquals(list[1], 3)
        assertEquals(list[3], 5)
        assertEquals(list.size, 4)
    }

    @Test
    fun testDownTo(){
        val list = mutableListOf<Int>()
        (5).downTo(3) { list.add(it) }
        assertEquals(list[0], 5)
        assertEquals(list[1], 4)
        assertEquals(list[2], 3)
        assertEquals(list.size, 3)
    }
}