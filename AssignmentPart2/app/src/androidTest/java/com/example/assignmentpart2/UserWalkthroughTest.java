package com.example.assignmentpart2;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class UserWalkthroughTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.CAMERA",
                    "android.permission.RECORD_AUDIO");

    @Test
    public void userWalkthroughTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.txtEmail),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("j.m.mcglinchey@live.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.txtPassword),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("Password"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.txtPassword), withText("Password"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText3.perform(pressImeActionButton());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btnLogin), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.btnOpenAdd),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1),
                                0),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btnOpenAdd), withText("Update Items"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                0),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btnDetect), withText("Detect"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.txtCode), withText("42277149"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1),
                                2),
                        isDisplayed()));
        editText.check(matches(isDisplayed()));

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.txtItemName),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                3),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("Nivea Men"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.txtItemName), withText("Nivea Men"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                3),
                        isDisplayed()));
        appCompatEditText5.perform(pressImeActionButton());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.txtPrice),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                4),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("1"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.txtPrice), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                4),
                        isDisplayed()));
        appCompatEditText7.perform(pressImeActionButton());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.txtQuant),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                5),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("1"), closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.txtQuant), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                5),
                        isDisplayed()));
        appCompatEditText9.perform(pressImeActionButton());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btnAddItem), withText("Add Item"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                6),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.txtCode), withText("Item Code"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1),
                                2),
                        isDisplayed()));
        editText2.check(matches(withText("Item Code")));

        pressBack();

        pressBack();

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btnOpenPantry), withText("View Pantry"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                2),
                        isDisplayed()));
        appCompatButton5.perform(click());

        DataInteraction linearLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.lstView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.txtCodeData), withText("Item Code: 42277149\nItem Name: Nivea Men\nItem Quantity: 1\nItem Price: £1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lstView),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        pressBack();

        pressBack();

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btnOpenRemove), withText("Remove Item"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btnDetect), withText("Detect"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.btnDetect), withText("Detect"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.btnDetect), withText("Detect"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatButton9.perform(click());

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.btnDetect), withText("Detect"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.btnDetect), withText("Detect"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatButton11.perform(click());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.txtCode), withText("42277149"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1),
                                2),
                        isDisplayed()));
        editText3.check(matches(isDisplayed()));

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.btnRemove), withText("Remove Item"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                6),
                        isDisplayed()));
        appCompatButton12.perform(click());

        pressBack();

        pressBack();

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.btnOpenPantry), withText("View Pantry"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                2),
                        isDisplayed()));
        appCompatButton13.perform(click());

        DataInteraction linearLayout2 = onData(anything())
                .inAdapterView(allOf(withId(R.id.lstView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout2.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.txtCodeData), withText("Item Code: 081287123453\nItem Name: Lighter fluid\nItem Quantity: 10\nItem Price: £1.5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lstView),
                                        0),
                                0),
                        isDisplayed()));
        textView2.check(matches(isDisplayed()));

        pressBack();

        pressBack();

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(R.id.btnOpenList), withText("Make List"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                3),
                        isDisplayed()));
        appCompatButton14.perform(click());

        DataInteraction linearLayout3 = onData(anything())
                .inAdapterView(allOf(withId(R.id.lstShop),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout3.perform(click());

        DataInteraction linearLayout4 = onData(anything())
                .inAdapterView(allOf(withId(R.id.lstShop),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout4.perform(click());

        DataInteraction linearLayout5 = onData(anything())
                .inAdapterView(allOf(withId(R.id.lstShop),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout5.perform(click());

        DataInteraction linearLayout6 = onData(anything())
                .inAdapterView(allOf(withId(R.id.lstShop),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout6.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.txtCodeData), withText("Item Code: 081287123453\nItem Name: Lighter fluid\nItem Quantity: 10\nItem Price: £1.5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.lstShop),
                                        0),
                                0),
                        isDisplayed()));
        textView3.check(matches(isDisplayed()));

        ViewInteraction appCompatButton15 = onView(
                allOf(withId(R.id.btnLogout), withText("Logout"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton15.perform(click());

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.txtTitle), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        0),
                                0),
                        isDisplayed()));
        textView4.check(matches(withText("Login")));

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.txtSignUp), withText("Not registered? Register here."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                4),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.txtTitle), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        0),
                                0),
                        isDisplayed()));
        textView5.check(matches(withText("Register")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
