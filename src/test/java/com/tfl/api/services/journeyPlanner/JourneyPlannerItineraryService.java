package com.tfl.api.services.journeyPlanner;

import com.frameworkium.core.api.annotations.DeserialiseAs;
import com.frameworkium.core.api.services.BaseService;
import com.frameworkium.core.api.services.ServiceFactory;
import ru.yandex.qatools.allure.annotations.Step;
import com.tfl.api.entities.JourneyPlanner.ItineraryResult;

import java.util.Arrays;

import static com.jayway.restassured.RestAssured.given;

public class JourneyPlannerItineraryService
        extends BaseService<JourneyPlannerItineraryService> {

    @DeserialiseAs
    private ItineraryResult itineraryResult;

    @Step
    public Integer getShortestJourneyDuration() {
        return Arrays.stream(itineraryResult.journeys)
                .map(j -> j.duration)
                .min(Integer::compareTo)
                .orElseThrow(IllegalStateException::new);
    }

}
