package com.tfl.api.services.carparkoccupancy;

import com.frameworkium.core.api.services.ServiceFactory;

public interface CarParkOccupancyService {

    static CarParkOccupancyResponse newInstance() {
        return ServiceFactory.newInstance(
                CarParkOccupancyResponse.class,
                "https://api.tfl.gov.uk/Occupancy/CarPark");
    }

    static CarParkOccupancySingleResponse newInstance(String id) {
        return ServiceFactory.newInstance(
                CarParkOccupancySingleResponse.class,
                "https://api.tfl.gov.uk/Occupancy/CarPark/" + id);
    }
}
