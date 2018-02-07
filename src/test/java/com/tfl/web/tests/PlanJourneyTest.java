package com.tfl.web.tests;

import com.frameworkium.core.ui.tests.BaseUITest;
import com.tfl.web.pages.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static com.google.common.truth.Truth.assertThat;

public class PlanJourneyTest extends BaseUITest {

    // disabled due to lack of time for maintenance
    // still useful as an example
    @TestCaseId("TFL-1")
    @Test(description = "Plan a journey test", enabled = false)
    public final void planJourneyTest() {

        // Navigate to homepage
        HomePage homePage = HomePage.open();

        // Click the the plan journey link
        PlanJourneyPage planJourneyPage = homePage.clickPlanJourneyLink();

        // Plan a journey between two locations
        JourneyPlannerResultsPage resultsPage = planJourneyPage
                .planJourney("Clapham Junction", "Oxford Circus Underground Station");

        // Check that the title displayed on the page is "JOURNEY RESULTS"
        assertThat(resultsPage.getTitleText()).isEqualTo("JOURNEY RESULTS");
    }
}
