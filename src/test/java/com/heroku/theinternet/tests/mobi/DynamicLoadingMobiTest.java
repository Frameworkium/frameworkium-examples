package com.heroku.theinternet.tests.mobi;

import static com.google.common.truth.Truth.assertThat;

import org.testng.annotations.Test;

import com.frameworkium.core.ui.tests.BaseTest;
import com.heroku.theinternet.pages.web.DynamicLoadingExamplePage;
import com.heroku.theinternet.pages.web.WelcomePage;

public class DynamicLoadingMobiTest extends BaseTest {

    @Test(description = "Test element visibility")
    public final void testElementVisibility() {
        // Navigate to the dynamic loading hidden element page
        DynamicLoadingExamplePage dynamicLoadingPage =
                WelcomePage.open().then().clickDynamicLoading().then().clickExample1();

        // Assert that the element is hidden
        assertThat(dynamicLoadingPage.isElementDisplayed()).named("element visibility").isFalse();

        // Click start and wait for element to be displayed
        dynamicLoadingPage.clickStart().then().waitForElementToBeDisplayed();

        // Assert that the element is indeed displayed
        assertThat(dynamicLoadingPage.isElementDisplayed()).named("element visibility").isTrue();
    }

    @Test(description = "Test element presence")
    public final void testElementPresence() {
        // Navigate to the dynamic loading element not yet rendered page
        DynamicLoadingExamplePage dynamicLoadingPage =
                WelcomePage.open().then().clickDynamicLoading().then().clickExample2();

        // Assert that the element is not present
        assertThat(dynamicLoadingPage.isElementPresent()).named("element presence").isFalse();

        // Click start and wait for element to be displayed
        dynamicLoadingPage.clickStart().then().waitForElementToBeDisplayed();

        // Assert that the element is indeed present
        assertThat(dynamicLoadingPage.isElementPresent()).named("element presence").isTrue();
    }
}
