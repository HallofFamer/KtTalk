package com.mysidia.kttalk

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AnysTest {

    private var a = "Hello World"
    private var b: String? = ""
    private var c: String? = null
    private var message = ""

    @Test
    fun testIsNull(){
        assertFalse(a.isNull())
        assertFalse(b.isNull())
        assertTrue(c.isNull())
    }

    @Test
    fun testIfNull(){
        a ifNull {
            message = "Variable a is null"
        }
        assertEquals(message, "")

        b ifNull {
            message = "Variable b is null"
        }
        assertEquals(message, "")

        c ifNull {
            message = "Variable c is null"
        }
        assertEquals(message, "Variable c is null")
    }

    @Test
    fun testIfNotNull(){
        a ifNotNull {
            message = "Variable a is not null"
        }
        assertEquals(message, "Variable a is not null")

        b ifNotNull {
            message = "Variable b is not null"
        }
        assertEquals(message, "Variable b is not null")

        c ifNotNull {
            message = "Variable c is not null"
        }
        assertEquals(message, "Variable b is not null")
    }

    @Test
    fun testIfNullOtherwise(){
        a.ifNull({
            message = "Variable a is null"
        }, otherwise = {
            message = "Variable a is not null"
        })
        assertEquals(message, "Variable a is not null")

        b.ifNull({
            message = "Variable b is null"
        }, otherwise = {
            message = "Variable b is not null"
        })
        assertEquals(message, "Variable b is not null")

        c.ifNull({
            message = "Variable c is null"
        }, otherwise = {
            message = "Variable c is not null"
        })
        assertEquals(message, "Variable c is null")
    }

    @Test
    fun testIfNotNullOtherwise(){
        a.ifNotNull({
            message = "Variable a is not null"
        }, otherwise = {
            message = "Variable a is null"
        })
        assertEquals(message, "Variable a is not null")

        b.ifNotNull({
            message = "Variable b is not null"
        }, otherwise = {
            message = "Variable b is null"
        })
        assertEquals(message, "Variable b is not null")

        c.ifNotNull({
            message = "Variable c is not null"
        }, otherwise = {
            message = "Variable c is null"
        })
        assertEquals(message, "Variable c is null")
    }
}