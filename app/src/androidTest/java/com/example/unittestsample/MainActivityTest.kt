package com.example.unittestsample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
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
}