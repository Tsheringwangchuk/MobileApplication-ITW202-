package edu.gcit.to_do_4;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AcitivityInputOutputTest {

    @Rule
    public ActivityTestRule mActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("edu.gcit.to_do_4", appContext.getPackageName());
    }
    @Test
    public void activityLaunch()
    {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.t3)).check(matches(isDisplayed()));

        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.t6)).check(matches(isDisplayed()));
    }

    @Test
    public void textInputOutput()
    {
        onView(withId(R.id.t1)).perform(typeText("This is a text"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.t3)).check(matches(withText("This is a text")));
//reply message
        onView(withId(R.id.t4)).perform(typeText("This is myreply"));
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.t6)).check(matches(withText("This is myreply")));
    }
}