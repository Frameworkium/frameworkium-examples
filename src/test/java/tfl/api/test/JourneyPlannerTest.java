package tfl.api.test;

import com.frameworkium.core.api.tests.BaseAPITest;
import org.testng.annotations.Test;
import tfl.api.service.journeyplanner.DisambiguationService;
import tfl.api.service.journeyplanner.ItineraryService;

import static com.google.common.truth.Truth.assertThat;

public class JourneyPlannerTest extends BaseAPITest {

    @Test
    public void journey_planner_london_search_journey_duration() {
        var disambiguationResult = new DisambiguationService()
                .getDisambiguationResult(
                        "Blue Fin Building, Southwark",
                        "Waterloo Station, London"
                );

        String from = disambiguationResult.journeyVector.from;
        String to = disambiguationResult.getFirstDisambiguatedTo();

        int shortestJourneyDuration = new ItineraryService()
                .getItinerary(from, to)
                .getShortestJourneyDuration();

        assertThat(shortestJourneyDuration).isLessThan(31);
    }
}
