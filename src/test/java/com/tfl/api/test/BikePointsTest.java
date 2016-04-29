package com.tfl.api.test;

import com.frameworkium.core.api.tests.BaseTest;
import com.google.common.collect.ImmutableMap;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import com.tfl.api.entities.Place;
import com.tfl.api.services.bikepoint.BikePointService;
import com.tfl.api.services.bikepoint.BikePointsPlacesService;
import com.tfl.api.services.bikepoint.BikePointsService;

import java.util.List;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

public class BikePointsTest extends BaseTest {

    @Test
    public void all_bikes_contains_something_and_there_are_a_lot_of_them() {

        List<String> allNames = BikePointService
                .newInstance(BikePointsService.class)
                .getAllNames();

        assertThat(allNames).contains("Evesham Street, Avondale");
        assertThat(allNames.size()).isAtLeast(700);
    }

    @Test
    public void all_bikes_contains_something_and_there_are_a_lot_of_them2() {

        List<String> allNames = BikePointService
                .newInstance(BikePointsService.class)
                .getAllNames();

        assertThat(allNames).contains("Evesham Street, Avondale");
        assertThat(allNames.size()).isAtLeast(700);
    }

    @Test
    @TestCaseId("TEST-1")
    public void given_lat_long_of_point_point_appears_in_lat_long_search() {

        // Get random bike point
        Place randomBP = BikePointService
                .newInstance(BikePointsService.class)
                .getRandomBikePoint();

        // Search for lat long of said bike point with 200m radius
        // TODO: make more resistant to changes, e.g. if radius->rad how to easily fix?
        Map<String, String> params = ImmutableMap.of(
                "lat", randomBP.lat,
                "lon", randomBP.lon,
                "radius", "200");
        BikePointsPlacesService latLongBikePoints =
                BikePointService.newInstance(params, BikePointsPlacesService.class);

        // Then said bike point is part of result set
        assertThat(latLongBikePoints.getAllNames()).contains(randomBP.commonName);
    }
}
