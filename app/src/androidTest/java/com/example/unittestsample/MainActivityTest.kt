package com.example.unittestsample

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest{

    // Open MainActivity for test as it is required for test cases
    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    //click next three times and check the quote text
    @Test
    fun testNextButton_expected_correctQuote(){
        onView(withId(R.id.nextBtn)).perform(click())
        onView(withId(R.id.nextBtn)).perform(click())
        onView(withId(R.id.nextBtn)).perform(click())
        onView(withId(R.id.quoteText)).check(matches(withText("Moon Walk")))
    }

    @Test
    fun testShareButton_expected_intentChooser(){
        Intents.init()
        val expected = allOf(hasAction(Intent.ACTION_SEND))
        onView(withId(R.id.floatingActionButton)).perform(click())
        intended(expected)
        Intents.release()
    }
}