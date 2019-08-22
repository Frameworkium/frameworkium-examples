package tfl.web.tests;

import com.frameworkium.core.ui.tests.BaseUITest;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import tfl.web.pages.HomePage;

import static com.google.common.truth.Truth.assertThat;

public class PlanJourneyTest extends BaseUITest {

    // disabled due to lack of time for maintenance
    // still useful as an example
    @TmsLink("TFL-1")
    @Test(enabled = false)
    public final void planJourneyTest() {

        var planJourneyPage = HomePage.open().clickPlanJourneyLink();

        // Plan a journey between two locations
        var resultsPage = planJourneyPage
                .planJourney("Clapham Junction", "Oxford Circus Underground Station");

        // Check that the title displayed on the page is "JOURNEY RESULTS"
        assertThat(resultsPage.getTitleText()).isEqualTo("JOURNEY RESULTS");
    }
}
