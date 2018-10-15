package tfl.api.service.journeyplanner;

import io.qameta.allure.Step;
import tfl.api.dto.journeyplanner.Itinerary;
import tfl.api.service.BaseTFLService;

import static tfl.api.constant.Endpoint.JOURNEY_PLANNER;

public class ItineraryService extends BaseTFLService {

    @Step("Get itinerary from {0} to {1}")
    public Itinerary getItinerary(String from, String to) {
        return get(JOURNEY_PLANNER.getUrl(from, to))
                .as(Itinerary.class);
    }
}
