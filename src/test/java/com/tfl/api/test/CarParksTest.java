package com.tfl.api.test;

import com.frameworkium.core.api.tests.BaseTest;
import com.tfl.api.entities.CarParkOccupancy;
import com.tfl.api.services.carparkoccupancy.CarParkOccupancyResponse;
import com.tfl.api.services.carparkoccupancy.CarParkOccupancyService;
import com.tfl.api.services.carparkoccupancy.CarParkOccupancySingleResponse;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static com.google.common.truth.Truth.assertThat;

public class CarParksTest extends BaseTest {

    @Test
    public void all_car_park_occupancies_more_than_10_spaces() {

        int totalFreeSpaces = CarParkOccupancyService
                .newInstance()
                .getTotalNumFreeSpaces();

        assertThat(totalFreeSpaces)
                .isGreaterThan(10);
    }

    @Test
    public void all_car_park_occupancies_contains_ruislip() {

        List<String> carParkNames = CarParkOccupancyService
                .newInstance()
                .getNames();

        assertThat(carParkNames)
                .contains("Ruislip Gardens Stn (LUL)");
    }

    @Test(enabled = false) // possible bug in the service
    public void free_and_occupied_equals_total() {

        CarParkOccupancyResponse response = CarParkOccupancyService.newInstance();

        int freeAndOccupiedCount = response.getTotalNumFreeSpaces()
                + response.getTotalNumOccupiedSpaces();

        assertThat(response.getTotalNumSpaces())
                .isEqualTo(freeAndOccupiedCount);
    }

    @Test
    public void single_car_park_request_information_the_same() {
        // N.B. this test might fail if the number of free/used bays changes
        // between the first and subsequent service call

        CarParkOccupancy randomCPO = getRandomCarParkOccupancy();

        // Get said CPO via ID
        CarParkOccupancySingleResponse specificCarParkQuery =
                CarParkOccupancyService.newInstance(randomCPO.id);
        CarParkOccupancy specificCPO = specificCarParkQuery.getCPO();

        // Make sure they are the same ignoring the details of the bays
        assertThat(specificCPO.equalsIgnoringBayDetails(randomCPO)).isTrue();
    }

    @Test
    public void single_car_park_has_sane_number_of_free_spaces() {

        // Get said CP via ID
        int freeSpaces = CarParkOccupancyService
                .newInstance(getRandomCarParkOccupancy().id)
                .getNumFreeSpaces();

        // Make sure things are sane
        assertThat(freeSpaces).isAtLeast(1);
        assertThat(freeSpaces).isLessThan(10000);
    }

    private CarParkOccupancy getRandomCarParkOccupancy() {

        // Pick a random CP from the list of all CPs
        CarParkOccupancy[] allCPOs = CarParkOccupancyService
                .newInstance()
                .getAll();

        return allCPOs[new Random().nextInt(allCPOs.length)];
    }

}
