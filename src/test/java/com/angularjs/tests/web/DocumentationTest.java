package com.angularjs.tests.web;

import com.angularjs.pages.web.DeveloperGuidePage;
import com.angularjs.pages.web.HomePage;
import com.frameworkium.core.ui.tests.BaseTest;

import org.testng.annotations.Test;

import static com.google.common.truth.Truth.*;

public class DocumentationTest extends BaseTest {

    @Test(description = "Tests the developer documentation on AngularJS, and the search function")
    public void documentationTest() {
        DeveloperGuidePage developerGuidePage = HomePage.open().then().clickDeveloperGuide();
        developerGuidePage.searchDeveloperGuide("Bootstrap").then().clickBootstrapSearchItem();
        assertThat(developerGuidePage.getGuideTitle()).isEqualTo("Bootstrap");
    }

}