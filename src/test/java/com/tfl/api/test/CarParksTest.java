package com.tfl.api.test;

import com.frameworkium.core.api.tests.BaseTest;
import org.testng.annotations.Test;
import com.tfl.api.entities.CarParkOccupancy;
import com.tfl.api.services.carparkoccupancy.CarParkOccupancyService;
import com.tfl.api.services.carparkoccupancy.CarParkOccupancySingleService;

import java.util.Random;

import static com.google.common.truth.Truth.assertThat;

public class CarParksTest extends BaseTest {

    @Test
    public void all_car_park_occupancies_more_than_10_spaces() {

        CarParkOccupancyService carParkOccupancyService = CarParkOccupancyService.newInstance();
        assertThat(carParkOccupancyService.getNumFreeSpaces()).isGreaterThan(10);
    }

    @Test
    public void all_car_park_occupancies_contains_ruislip() {

        CarParkOccupancyService carParkOccupancyService = CarParkOccupancyService.newInstance();
        assertThat(carParkOccupancyService.getCarParkNames()).contains("Ruislip Gardens Stn (LUL)");
    }

    @Test
    public void single_car_park_request_information_the_same() {

        CarParkOccupancyService carParkOccupancyService = CarParkOccupancyService.newInstance();
        CarParkOccupancy[] allCPOs = carParkOccupancyService.getAllCPOs();
        CarParkOccupancy randomCPO = allCPOs[new Random().nextInt(allCPOs.length)];
        CarParkOccupancySingleService specificCarParkQuery = CarParkOccupancySingleService.newInstance(randomCPO.id);
        CarParkOccupancy specificCPO = specificCarParkQuery.getCPO();
        assertThat(specificCPO).isEqualTo(randomCPO);
    }

}
