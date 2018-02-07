package com.google.tests;

import com.frameworkium.core.ui.tests.BaseUITest;
import com.google.pages.HomePage;
import com.google.pages.ResultsPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static com.google.common.truth.Truth.assertThat;

public class SearchTest extends BaseUITest {

    @TestCaseId("FT-1")
    @Test(description = "Run a search on Google and check result returned",
            enabled = false) // not working on Travis...
    public void searchTest() {

        // Navigate to google and run a search
        ResultsPage resultsPage = HomePage.open().then()
                .clickSearchBar()
                .setSearchBarText("Hello World")
                .clickEnter();

        // Check that the results contains the expected result
        String expectedTitle = "\"Hello, World!\" program - Wikipedia";
        assertThat(resultsPage.getResultTitles())
                .contains(expectedTitle);
    }
}
