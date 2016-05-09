package com.tfl.api.services.journeyPlanner;

import com.frameworkium.core.api.annotations.DeserialiseAs;
import com.frameworkium.core.api.services.BaseService;
import ru.yandex.qatools.allure.annotations.Step;
import com.tfl.api.entities.JourneyPlanner.DisambiguationResult;

public class JourneyPlannerDisambiguationResponse
        extends BaseService<JourneyPlannerDisambiguationResponse> {

    @DeserialiseAs
    private DisambiguationResult result;

    @Step
    public String getFrom() {
        return result.journeyVector.from;
    }

    @Step
    public String getFirstDisambiguatedFrom() {
        return result.fromLocationDisambiguation.disambiguationOptions[0].parameterValue;
    }

    @Step
    public String getTo() {
        return result.journeyVector.to;
    }

    @Step
    public String getFirstDisambiguatedTo() {
        return result.toLocationDisambiguation.disambiguationOptions[0].parameterValue;
    }

}
