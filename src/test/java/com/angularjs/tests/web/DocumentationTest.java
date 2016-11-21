package com.angularjs.tests.web;

import com.angularjs.pages.web.HomePage;
import com.frameworkium.core.ui.tests.BaseTest;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class DocumentationTest extends BaseTest {

    @Test(description =
            "Tests the AngularJS developer documentation and search function")
    public void documentationTest() {
        String guideTitle = HomePage
                .open()
                .clickDeveloperGuide()
                .searchDeveloperGuide("Bootstrap")
                .clickBootstrapSearchItem()
                .getGuideTitle("Bootstrap");

        assertThat(guideTitle)
                .isEqualTo("Bootstrap");
    }

}
