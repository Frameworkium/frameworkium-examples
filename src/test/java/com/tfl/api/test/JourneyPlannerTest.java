package com.tfl.api.test;

import com.frameworkium.core.api.tests.BaseTest;
import com.google.common.collect.ImmutableMap;
import org.testng.annotations.Test;
import com.tfl.api.services.journeyPlanner.JourneyPlannerDisambiguation;
import com.tfl.api.services.journeyPlanner.JourneyPlannerItineraryService;
import com.tfl.api.services.journeyPlanner.JourneyPlannerService;

import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

public class JourneyPlannerTest extends BaseTest {

    @Test
    public void journey_planner_london_search_journey_duration() {

        JourneyPlannerDisambiguation journeyPlannerDisambiguation =
                JourneyPlannerService.newInstance(
                        "Blue Fin Building, Southwark",
                        "Waterloo Station, London",
                        JourneyPlannerDisambiguation.class);

        String from = journeyPlannerDisambiguation.getFrom();
        String to = journeyPlannerDisambiguation.getFirstDisambiguatedTo();

        assertThat(
                JourneyPlannerService.newInstance(from, to, JourneyPlannerItineraryService.class)
                        .getShortestJourneyDuration())
                .isLessThan(30);
    }

    @Test
    public void journey_planner_national_search_journey_duration() {

        Map<String, String> params = ImmutableMap.of("nationalSearch", "True");

        JourneyPlannerItineraryService journeyPlannerItineraryService =
                JourneyPlannerService.newInstance(
                        "Blue Fin Building, Southwark",
                        "Surrey Research Park, Guildford",
                        params,
                        JourneyPlannerItineraryService.class);

        assertThat(
                journeyPlannerItineraryService.getShortestJourneyDuration())
                .isGreaterThan(45);
    }

}
