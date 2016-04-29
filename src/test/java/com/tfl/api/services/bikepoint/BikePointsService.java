package com.tfl.api.services.bikepoint;

import com.frameworkium.core.api.annotations.DeserialiseAs;
import com.frameworkium.core.api.services.BaseService;
import com.frameworkium.core.api.services.ServiceFactory;
import ru.yandex.qatools.allure.annotations.Step;
import com.tfl.api.entities.Place;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.jayway.restassured.RestAssured.given;

public class BikePointsService extends BaseService<BikePointsService> {

    @DeserialiseAs
    private Place[] bikePoints;

    /**
     * @return a list of common names
     */
    @Step
    public List<String> getAllNames() {
        return Arrays.stream(bikePoints)
                .map(bp -> bp.commonName)
                .collect(Collectors.toList());
    }

    @Step
    public Place getRandomBikePoint() {
        return bikePoints[new Random().nextInt(bikePoints.length)];
    }

}
