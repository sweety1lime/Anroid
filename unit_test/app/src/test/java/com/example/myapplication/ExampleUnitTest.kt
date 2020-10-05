package com.example.myapplication

import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun test() {
        var clas = Test_Unit()
        var publishedAt = clas.API("http://newsapi.org/v2/top-headlines?country=ru&apiKey=c22cef390cbf4ccb856d8e359c4cc21d")

        assertEquals("",publishedAt)
    }

}