package com.tfl.api.test;

import com.frameworkium.core.api.tests.BaseTest;
import com.google.common.collect.ImmutableMap;
import com.tfl.api.services.bikepoint.BikePointsResponse;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import com.tfl.api.entities.Place;
import com.tfl.api.services.bikepoint.BikePointService;
import com.tfl.api.services.bikepoint.BikePointsPlacesResponse;

import java.util.List;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

public class BikePointsTest extends BaseTest {

    @Test
    public void all_bikes_contains_something_and_there_are_a_lot_of_them() {

        List<String> allNames = BikePointService
                .newInstance(BikePointsResponse.class)
                .getAllNames();

        assertThat(allNames).contains("Evesham Street, Avondale");
        assertThat(allNames.size()).isAtLeast(700);
    }

    @Test
    @TestCaseId("TEST-1")
    public void given_lat_long_of_point_point_appears_in_lat_long_search() {

        // Get random bike point
        Place randomBP = BikePointService
                .newInstance(BikePointsResponse.class)
                .getRandomBikePoint();

        // Search for lat long of said bike point with 200m radius
        // TODO: make more resistant to changes:
        // e.g. if radius->rad how to easily fix?
        // perhaps a factory to build service specific maps?
        // e.g. params = new BikePointsParamsBuilder().lat(lat).lon(lon).radius(radius).build()

        Map<String, String> params = ImmutableMap.of(
                "lat", randomBP.lat,
                "lon", randomBP.lon,
                "radius", "200");
        BikePointsPlacesResponse latLongBikePoints =
                BikePointService.newInstance(params, BikePointsPlacesResponse.class);

        // Then said bike point is part of result set
        assertThat(latLongBikePoints.getAllNames()).contains(randomBP.commonName);
    }
}
