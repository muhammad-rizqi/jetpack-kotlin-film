@file:Suppress("DEPRECATION")

package com.rizqi.nontonkuy

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.rizqi.nontonkuy.data.WebServices
import com.rizqi.nontonkuy.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

  private val data = WebServices()
  private val movies = data.getMovies()
  private val tvs = data.getTvs()

  @get:Rule
  var activityRule = ActivityTestRule(MainActivity::class.java)

  @Before
  fun setUp() {
    IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
  }

  @After
  fun tearDown() {
    IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
  }

  @Test
  fun loadMovies() {
    onView(withId(R.id.rv_movie_list)).check(matches(isDisplayed()))
    onView(withId(R.id.rv_movie_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
      movies.size
    ))
  }

  @Test
  fun loadDetailMovies() {
    onView(withId(R.id.rv_movie_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
    onView(withId(R.id.movie_name)).check(matches(isDisplayed()))
    onView(withId(R.id.movie_name)).check(matches(withText(movies[0].original_title)))

    onView(withId(R.id.movie_date)).check(matches(isDisplayed()))
    onView(withId(R.id.movie_date)).check(matches(withText(movies[0].release_date)))

    onView(withId(R.id.movie_overview)).check(matches(isDisplayed()))
    onView(withId(R.id.movie_overview)).check(matches(withText(movies[0].overview)))

    onView(withId(R.id.movie_vote)).check(matches(isDisplayed()))
    onView(withId(R.id.movie_vote)).check(matches(withText(movies[0].vote_average.toString())))

  }

  @Test
  fun loadTVs() {
    onView(withText("TV SHOW")).perform(click())
    onView(withId(R.id.rv_tv_list)).check(matches(isDisplayed()))
    onView(withId(R.id.rv_tv_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
      tvs.size
    ))
  }

  @Test
  fun loadDetailTvs() {
    onView(withText("TV SHOW")).perform(click())

    onView(withId(R.id.rv_tv_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
    onView(withId(R.id.tv_show_name)).check(matches(isDisplayed()))
    onView(withId(R.id.tv_show_name)).check(matches(withText(tvs[0].name)))

    onView(withId(R.id.tv_first_air_date)).check(matches(isDisplayed()))
    onView(withId(R.id.tv_first_air_date)).check(matches(withText(tvs[0].first_air_date)))

    onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
    onView(withId(R.id.tv_overview)).check(matches(withText(tvs[0].overview)))

    onView(withId(R.id.tv_vote_average)).check(matches(isDisplayed()))
    onView(withId(R.id.tv_vote_average)).check(matches(withText(tvs[0].vote_average.toString())))
    onView(withId(R.id.tv_vote_count)).check(matches(isDisplayed()))

  }

  @Test
  fun loadBookmarks() {
    onView(withId(R.id.menu_favorite)).perform(click())
    onView(withId(R.id.rv_movie_list)).check(matches(isDisplayed()))
    onView(withText("TV SHOW")).perform(click())
    onView(withId(R.id.rv_tv_list)).check(matches(isDisplayed()))
    onView(isRoot()).perform(ViewActions.pressBack())
  }

}