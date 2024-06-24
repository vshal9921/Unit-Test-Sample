package com.example.unittestsample

import android.content.Context
import com.google.gson.Gson

class QuoteManager {

    var quoteList = emptyArray<Quote>()
    var currQuoteIndex = 0

    fun populateQuotesFromAssets(context: Context, fileName : String){
        val inputStream = context.assets.open(fileName)
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quoteList = gson.fromJson(json, Array<Quote>::class.java)
    }

    fun populateQuotes(quotues : Array<Quote>){
        quoteList = quotues
    }

    fun getCurrentQuote() : Quote{
        return quoteList.get(currQuoteIndex)
    }

    fun getNextQuote() : Quote{
        if (currQuoteIndex == quoteList.size - 1) return quoteList.get(currQuoteIndex)

        return quoteList.get(++currQuoteIndex)
    }

    fun getPreviousQuote() : Quote{
        if(currQuoteIndex == 0) return quoteList.get(currQuoteIndex)
        return quoteList.get(--currQuoteIndex)
    }
}