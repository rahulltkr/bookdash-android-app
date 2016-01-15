package org.bookdash.android.presentation.about

import android.content.Intent
import android.net.Uri
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.intent.Intents
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v4.widget.NestedScrollView
import android.test.suitebuilder.annotation.SmallTest
import android.text.Html
import android.view.View

import junit.framework.Assert

import org.bookdash.android.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.scrollTo
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.matcher.IntentMatchers.hasAction
import android.support.test.espresso.intent.matcher.IntentMatchers.hasData
import android.support.test.espresso.matcher.RootMatchers.isDialog
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.contains


import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent

/**
 * @author rebeccafranks
 * *
 * @since 15/11/21.
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class AboutActivityTest {

    @Rule
    public fun getRule(): ActivityTestRule<AboutActivity> = ActivityTestRule(AboutActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    @Throws(Throwable::class)
    fun loadAboutBookDash_SeeInformation() {
        val about = Html.fromHtml(InstrumentationRegistry.getTargetContext().getString(R.string.why_bookdash))
        val headingAbout = InstrumentationRegistry.getTargetContext().getString(R.string.heading_about)

        onView(withText(headingAbout)).check(matches(isDisplayed()))

        onView(withText(about.toString())).perform(scrollTo()).check(matches(isDisplayed()))

    }

    @Test
    @Throws(Throwable::class)
    fun clickLearnMore_OpenBrowser() {

        onView(withText(R.string.learn_more)).perform(scrollTo(), click())

        intended(allOf(hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse("http://bookdash.org"))))
    }

}
