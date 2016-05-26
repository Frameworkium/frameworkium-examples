package com.google.tests.web;

import com.frameworkium.core.ui.tests.BaseTest;
import com.google.pages.web.HomePage;
import com.google.pages.web.ResultsPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static com.google.common.truth.Truth.assertThat;

public class SearchTest extends BaseTest {

    @TestCaseId("FT-1")
    @Test(description = "Run a search on google and check result returned")
    public void searchTest() {

        //Navigate to google and run a search
        ResultsPage resultsPage = HomePage.open().then().runSearch("Hello World");

        //Check that the results contains the expected result
        assertThat(resultsPage.getResultTitles())
                .contains("\"Hello, World!\" program - Wikipedia, the free encyclopedia");

    }
}
