package com.example.unittestsample

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import java.io.FileNotFoundException

class QuoteManagerTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test(expected = FileNotFoundException::class)
    fun populateQuotesFromAssets_expected_FileNotFound() {

        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuotesFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun testPopulateQuotesFromAssets_expected_InvalidJson() {

        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuotesFromAssets(context, "malformed.json")
    }

    @Test()
    fun testPopulateQuotesFromAssets_expected_ValidJson() {

        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuotesFromAssets(context, "quote.json")
        assertEquals(7, quoteManager.quoteList.size)
    }

    @Test
    fun testQuote_previousQuote(){
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(arrayOf(
            Quote("What is Qwerty", "Dino"),
            Quote("This is Qwerty", "Dine"),
            Quote("That is Qwerty", "Dimo"),
            Quote("Who is Qwerty", "Dimo"),
        ))

        val quote = quoteManager.getPreviousQuote()
        assertEquals("Dino", quote.author)
    }

    @Test
    fun testQuote_nextQuote(){
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(arrayOf(
            Quote("What is Qwerty", "Dino"),
            Quote("This is Qwerty", "Dine"),
            Quote("That is Qwerty", "Dimo"),
            Quote("Who is Qwerty", "Dimo"),
        ))

        val quote = quoteManager.getNextQuote()
        assertEquals("Dine", quote.author)
    }

}