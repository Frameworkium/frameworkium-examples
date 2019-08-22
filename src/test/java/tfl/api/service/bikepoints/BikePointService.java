package tfl.api.service.bikepoints;

import io.qameta.allure.Step;
import tfl.api.dto.bikepoints.BikePoints;
import tfl.api.dto.common.Place;
import tfl.api.dto.common.PlacesResponse;
import tfl.api.service.BaseTFLService;

import java.util.Map;

import static tfl.api.constant.Endpoint.BIKE_POINT;

public class BikePointService extends BaseTFLService {

    @Step("Get Bike Points")
    public BikePoints getBikePoints() {
        var places = get(BIKE_POINT.getUrl()).as(Place[].class);
        return new BikePoints(places);
    }

    @Step("Search Bike Points")
    public BikePoints searchBikePoints(Map<String, String> params) {
        var placesResponse =
                get(params, BIKE_POINT.getUrl()).as(PlacesResponse.class);
        return new BikePoints(placesResponse);
    }
}
