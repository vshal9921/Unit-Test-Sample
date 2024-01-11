package com.example.unittestsample.utils

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedHelperTest(val input: String, val expected: Boolean) {

    lateinit var helper: Helper
    @Before
    fun setup(){
        helper = Helper()
    }

    @Test
    fun parameterizedTest(){

        val result = helper.checkPalindrome(input)
        Assert.assertEquals(expected, result)
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is plaindrome - {1}" )
        fun data() : List<Array<Any>>{

            return listOf(
                arrayOf("qwerty", false),
                arrayOf("tenet", true),
                arrayOf("x", true),
                arrayOf("admin", false)
            )
        }

    }
}