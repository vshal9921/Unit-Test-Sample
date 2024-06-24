package com.example.unittestsample.utils

import org.junit.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test

class HelperPasswordTest {

    lateinit var helper : Helper
    @Before
    fun setUp() {
        helper = Helper()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testPass_input_empty_exected_true(){
        var value = helper.checkPassword("")
        assertEquals(false, value)
    }

    @Test
    fun testPass_input_abcd_exected_false(){
        var value = helper.checkPassword("abcd")
        assertEquals(false, value)
    }

    @Test
    fun testPass_input_abcdefgh_exected_true(){
        var value = helper.checkPassword("abcdefgh")
        assertEquals(true, value)
    }

    @Test
    fun testPass_input_abcdefghdbewdjiewjkj_exected_true(){
        var value = helper.checkPassword("abcdefghdbewdjiewjkj")
        assertEquals(false, value)
    }

    // tests for reverse string

    @Test
    fun testReverseString_input_empty_expeceted_pass(){
        var result = helper.reverseString("")
        assertEquals("", result)
    }

    @Test
    fun testReverseString_input_qwert_expeceted_pass(){
        var result = helper.reverseString("qwert")
        assertEquals("trewq", result)
    }

    @Test
    fun testReverseString_input_trip_expeceted_fail(){
        var result = helper.reverseString("trip")
        assertEquals("pirt", result)
    }

}