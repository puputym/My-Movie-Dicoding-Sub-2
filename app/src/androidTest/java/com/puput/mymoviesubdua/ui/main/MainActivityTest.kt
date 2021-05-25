package com.puput.mymoviesubdua.ui.main

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import com.puput.mymoviesubdua.R
import com.puput.mymoviesubdua.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    private lateinit var instrumentalContext: Context

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        instrumentalContext = InstrumentationRegistry.getInstrumentation().targetContext
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }


    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                10
            )
        )
    }

    @Test
    fun loadDetailActivityMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.img_item_photo)).check(matches(isDisplayed()))
        onView(withId(R.id.title)).check(matches(isDisplayed()))
        onView(withId(R.id.year)).check(matches(isDisplayed()))
        onView(withId(R.id.durasi)).check(matches(isDisplayed()))
        onView(withId(R.id.score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc)).check(matches(isDisplayed()))

    }

    @Test
    fun loadTvShow() {
        onView(withText(R.string.tv_show)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                10
            )
        )

    }

    @Test
    fun loadDetailActivityTvShow() {
        onView(withText(R.string.tv_show)).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.img_item_photo))
            .check(matches(isDisplayed()))
        onView(withId(R.id.title))
            .check(matches(isDisplayed()))

        onView(withId(R.id.year)).check(matches(isDisplayed()))

        onView(withId(R.id.durasi))
            .check(matches(isDisplayed()))

        onView(withId(R.id.score))
        onView(withId(R.id.tv_desc))
            .check(matches(isDisplayed()))


    }

}