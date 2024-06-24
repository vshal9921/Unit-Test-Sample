package com.example.unittestsample.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    lateinit var helper: Helper

    @Before
    fun setup(){
        helper = Helper()
    }

    @After
    fun testFinish(){
        println("test case finished")
    }

    @Test
    fun checkPalindrome() {


        val result = helper.checkPalindrome("abba")
        assertEquals( true, result)
    }

    @Test
    fun checkPalindrome_input_levels_expected_false() {

        val result = helper.checkPalindrome("levels")
        assertEquals( false, result)
    }

    @Test
    fun checkPalindrome_input_staats_expected_true(){

        val result = helper.checkPalindrome("staats")
        assertEquals(true, result)
    }
}