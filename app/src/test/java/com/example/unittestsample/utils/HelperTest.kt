package com.example.unittestsample.utils

import org.junit.Assert.*

import org.junit.Test

class HelperTest {

    @Test
    fun checkPalindrome() {

        val helper = Helper()
        val result = helper.checkPalindrome("abba")
        assertEquals( true, result)
    }
}