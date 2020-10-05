package com.example.ui_test

import android.widget.Button
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_win2.*
import org.junit.Rule
import org.junit.Test

class UI_Test {


    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(
        MainActivity::class.java
    )
    var activity = ActivityTestRule<win2>(
        win2::class.java
    )

    @Test
    fun Test_Win_X() {
        Espresso.onView(withId(activityRule.activity.pusk.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt1.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt2.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt5.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt3.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt9.id)).perform(ViewActions.click())
        Espresso.onView(withText("X")).check(matches(isDisplayed()))
    }

    @Test
    fun Test_Win_O() {
        Espresso.onView(withId(activityRule.activity.pusk.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt1.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt2.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt3.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt5.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt4.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt8.id)).perform(ViewActions.click())
        Espresso.onView(withText("O")).check(matches(isDisplayed()))
    }

    @Test
    fun Test_Win_O_end_X() {
        Espresso.onView(withId(activityRule.activity.pusk.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt1.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt2.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt3.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt5.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt4.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt7.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt6.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt9.id)).perform(ViewActions.click())
        Espresso.onView(withId(activityRule.activity.bt8.id)).perform(ViewActions.click())
        Espresso.onView(withText("ничья")).check(matches(isDisplayed()))

    }
}