package com.angularjs.tests;

import com.angularjs.pages.HomePage;
import com.frameworkium.core.ui.tests.BaseUITest;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class DocumentationTest extends BaseUITest {

    private static String TERM_TO_SEARCH = "Bootstrap";

    @Test(description =
            "Tests the AngularJS developer documentation and search function")
    public void documentationTest() {
        String guideTitle = HomePage
                .open()
                .clickDevelopMenu()
                .clickDeveloperGuideLink()
                .clickSearchBar()
                .setSearchBar(TERM_TO_SEARCH)
                .clickLinkWithTitle(TERM_TO_SEARCH)
                .getGuideTitle(TERM_TO_SEARCH);

        assertThat(guideTitle)
                .isEqualTo(TERM_TO_SEARCH);
    }

}
