package com.mysidia.kttalk
import kotlin.test.Test
import kotlin.test.assertEquals

class NumbersTest {

    private val num = 2.5
    private val num2 = 1.6f
    private val num3 = -5

    @Test
    fun testAbs(){
        assertEquals(num.abs(), 2.5)
        assertEquals(num2.abs(), 1.6)
        assertEquals(num3.abs(), 5)
    }

    @Test
    fun testArcCos(){
        assertEquals(1.0.arcCos(), 0.0)
        assertEquals(0.5.arcCos().round(2), 1.05)
        assertEquals(num.arcCos(), Double.NaN)
    }

    @Test
    fun testArcCosh(){
        assertEquals(num.arcCosh().round(2), 1.57)
        assertEquals(num2.arcCosh().round(2), 1.05)
        assertEquals(num3.arcCosh(), Double.NaN)
    }

    @Test
    fun testArcSin(){
        assertEquals(0.0.arcSin(), 0.0)
        assertEquals(0.5.arcSin().round(2), 0.52)
        assertEquals(num.arcSin(), Double.NaN)
    }

    @Test
    fun testArcSinh(){
        assertEquals(num.arcSinh().round(2), 1.65)
        assertEquals(num2.arcSinh().round(2), 1.25)
        assertEquals(num3.arcSinh().round(2), -2.31)
    }

    @Test
    fun testArcTan(){
        assertEquals(num.arcTan().round(2), 1.19)
        assertEquals(num2.arcTan().round(2), 1.01)
        assertEquals(num3.arcTan().round(2), -1.37)
    }

    @Test
    fun testArcTan2(){
        assertEquals(num.arcTan(num2).round(2), 1.00)
        assertEquals(num.arcTan(num3).round(2), 2.68)
        assertEquals(num2.arcTan(num3).round(2), 2.83)
    }

    @Test
    fun testArcTanh(){
        assertEquals(0.0.arcTanh(), 0.0)
        assertEquals(0.5.arcTanh().round(2), 0.55)
        assertEquals(num.arcTanh(), Double.NaN)
    }

    @Test
    fun testCeil(){
        assertEquals(num.ceil(), 3.0)
        assertEquals(num2.ceil(), 2.0)
        assertEquals(num3.ceil(), -5.0)
    }

    @Test
    fun testCos(){
        assertEquals(0.0.cos(), 1.0)
        assertEquals(0.5.cos().round(2), 0.88)
        assertEquals(num.cos().round(2), -0.80)
        assertEquals(num2.cos().round(2), -0.03)
        assertEquals(num3.cos().round(2), 0.28)
    }

    @Test
    fun testCosh(){
        assertEquals(0.0.cosh(), 1.0)
        assertEquals(0.5.cosh().round(2), 1.13)
        assertEquals(num.cosh().round(2), 6.13)
        assertEquals(num2.cosh().round(2), 2.58)
        assertEquals(num3.cosh().round(2), 74.21)
    }

    @Test
    fun testExp(){
        assertEquals(0.0.exp(), 1.0)
        assertEquals(num.exp().round(2), 12.18)
        assertEquals(num2.exp().round(2), 4.95)
        assertEquals(num3.exp().round(4), 0.0067)
    }

    @Test
    fun testFloor(){
        assertEquals(num.floor(), 2.0)
        assertEquals(num2.floor(), 1.0)
        assertEquals(num3.floor(), -5.0)
    }

    @Test
    fun testHypot(){
        assertEquals(num.hypot(1).round(2), 2.69)
        assertEquals(num2.hypot(1.5).round(2), 2.19)
        assertEquals(num3.hypot(0.45).round(2), 5.02)
    }

    @Test
    fun testLn(){
        assertEquals(1.0.ln(), 0.0)
        assertEquals(kotlin.math.E.ln(), 1.0)
        assertEquals(num.ln().round(2), 0.92)
        assertEquals(num2.ln().round(2), 0.47)
        assertEquals(num3.ln(), Double.NaN)
    }

    @Test
    fun testLog(){
        assertEquals(1.0.log(), 0.0)
        assertEquals(10.0.log(), 1.0)
        assertEquals(num.log().round(2), 0.40)
        assertEquals(num2.log().round(2), 0.20)
        assertEquals(num3.log(), Double.NaN)
    }

    @Test
    fun testLog2(){
        assertEquals(1.0.log(2), 0.0)
        assertEquals(3.0.log(3), 1.0)
        assertEquals(num.log(5).round(2), 0.57)
        assertEquals(num2.log(8).round(2), 0.23)
        assertEquals(num3.log(15), Double.NaN)
    }

    @Test
    fun testReciprocal(){
        assertEquals(num.reciprocal(), 0.4)
        assertEquals(num2.reciprocal().round(3), 0.625)
        assertEquals(num3.reciprocal(), -0.2)
    }

    @Test
    fun testRound(){
        assertEquals(num.round(), 2.0)
        assertEquals(num2.round(), 2.0)
        assertEquals(num3.round(), -5.0)
    }

    @Test
    fun testRound2(){
        val pi = 3.14159265
        assertEquals(pi.round(2), 3.14)
        assertEquals(pi.round(4), 3.1416)
        assertEquals(pi.round(7), 3.1415927)
        assertEquals(num.round(3), 2.500)
    }

    @Test
    fun testSin(){
        assertEquals(0.0.sin(), 0.0)
        assertEquals(0.5.sin().round(2), 0.48)
        assertEquals(num.sin().round(2), 0.60)
        assertEquals(num2.sin().round(2), 1.00)
        assertEquals(num3.sin().round(2), 0.96)
    }

    @Test
    fun testSinh(){
        assertEquals(0.0.sinh(), 0.0)
        assertEquals(0.5.sinh().round(2), 0.52)
        assertEquals(num.sinh().round(2), 6.05)
        assertEquals(num2.sinh().round(2), 2.38)
        assertEquals(num3.sinh().round(2), -74.20)
    }

    @Test
    fun testSqrt(){
        assertEquals(0.0.sqrt(), 0.0)
        assertEquals(num.sqrt().round(2), 1.58)
        assertEquals(num2.sqrt().round(2), 1.26)
        assertEquals(num3.sqrt(), Double.NaN)
    }

    @Test
    fun testSquared(){
        assertEquals(0.0.squared(), 0.0)
        assertEquals(num.squared(), 6.25)
        assertEquals(num2.squared().round(2), 2.56)
        assertEquals(num3.squared(), 25.0)
    }

    @Test
    fun testTan(){
        assertEquals(num.tan().round(2), -0.75)
        assertEquals(num2.tan().round(2), -34.23)
        assertEquals(num3.tan().round(2), 3.38)
    }

    @Test
    fun testTanh(){
        assertEquals(0.0.tanh(), 0.0)
        assertEquals(0.5.tanh().round(2), 0.46)
        assertEquals(num.tanh().round(2), 0.99)
        assertEquals(num2.tanh().round(2), 0.92)
        assertEquals(num3.tanh().round(2), -1.00)
    }

    @Test
    fun testStep(){
        val list = mutableListOf<Number>()
        num3.step(num2) { list.add(it) }
        assertEquals(list[0],-5.0)
        assertEquals(list[1], -4.0)
        assertEquals(list[6], 1.0)
        assertEquals(list.size, 7)
    }

    @Test
    fun testStep2(){
        val list = mutableListOf<Number>()
        num2.step(num, 0.2) { list.add(it) }
        assertEquals(list[0].round(1), 1.6)
        assertEquals(list[1].round(1), 1.8)
        assertEquals(list[4].round(1), 2.4)
        assertEquals(list.size, 5)
    }

    @Test
    fun testStep3(){
        val list = mutableListOf<Number>()
        num.step(num2, -0.3) { list.add(it) }
        assertEquals(list[0].round(1), 2.5)
        assertEquals(list[1].round(1), 2.2)
        assertEquals(list[2].round(1), 1.9)
        assertEquals(list.size, 3)
    }
}