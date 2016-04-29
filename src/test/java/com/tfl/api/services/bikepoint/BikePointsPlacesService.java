package com.tfl.api.services.bikepoint;

import com.frameworkium.core.api.annotations.DeserialiseAs;
import com.frameworkium.core.api.services.BaseService;
import com.frameworkium.core.api.services.ServiceFactory;
import ru.yandex.qatools.allure.annotations.Step;
import com.tfl.api.entities.PlacesResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.jayway.restassured.RestAssured.given;

public class BikePointsPlacesService extends BaseService<BikePointsPlacesService> {

    @DeserialiseAs
    private PlacesResponse placesResponse;

    /**
     * @return a list of common names
     */
    @Step
    public List<String> getAllNames() {
        return Arrays.stream(placesResponse.places)
                .map(bp -> bp.commonName)
                .collect(Collectors.toList());
    }

}
