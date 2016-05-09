package com.tfl.api.services.bikepoint;

import com.frameworkium.core.api.annotations.DeserialiseAs;
import com.frameworkium.core.api.services.BaseService;
import ru.yandex.qatools.allure.annotations.Step;
import com.tfl.api.entities.Places;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BikePointsPlacesResponse extends BaseService<BikePointsPlacesResponse> {

    @DeserialiseAs
    private Places places;

    /**
     * @return a list of common names
     */
    @Step
    public List<String> getAllNames() {
        return Arrays.stream(places.places)
                .map(bp -> bp.commonName)
                .collect(Collectors.toList());
    }

}
