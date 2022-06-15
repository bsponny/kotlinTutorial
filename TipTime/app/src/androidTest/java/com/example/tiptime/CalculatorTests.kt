package com.example.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTests {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculateThirtyPercent() {
        onView(withId(R.id.totalBillEditText))
            .perform(typeText("100.00"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculateButton)).perform(click())

        onView(withId(R.id.tipResult))
            .check(matches(withText(containsString("$30.00"))))
    }

    @Test
    fun calculateTwentyfivePercent() {
        onView(withId(R.id.totalBillEditText))
            .perform(typeText("100.00"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.twentyFivePercent)).perform(click())

        onView(withId(R.id.calculateButton)).perform(click())

        onView(withId(R.id.tipResult))
            .check(matches(withText(containsString("$25.00"))))
    }

    @Test
    fun calculateTwentyPercent() {
        onView(withId(R.id.totalBillEditText))
            .perform(typeText("100.00"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.twentyPercent)).perform(click())

        onView(withId(R.id.calculateButton)).perform(click())

        onView(withId(R.id.tipResult))
            .check(matches(withText(containsString("$20.00"))))
    }

    @Test
    fun calculateEighteenPercent() {
        onView(withId(R.id.totalBillEditText))
            .perform(typeText("100.00"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.eighteenPercent)).perform(click())

        onView(withId(R.id.calculateButton)).perform(click())

        onView(withId(R.id.tipResult))
            .check(matches(withText(containsString("$18.00"))))
    }

    @Test
    fun calculateFifteenPercent() {
        onView(withId(R.id.totalBillEditText))
            .perform(typeText("100.00"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.fifteenPercent)).perform(click())

        onView(withId(R.id.calculateButton)).perform(click())

        onView(withId(R.id.tipResult))
            .check(matches(withText(containsString("$15.00"))))
    }
}