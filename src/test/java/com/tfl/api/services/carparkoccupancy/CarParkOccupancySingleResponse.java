package com.tfl.api.services.carparkoccupancy;

import com.frameworkium.core.api.annotations.DeserialiseAs;
import com.frameworkium.core.api.services.BaseService;
import ru.yandex.qatools.allure.annotations.Step;
import com.tfl.api.entities.CarParkOccupancy;

import java.util.Arrays;

public class CarParkOccupancySingleResponse
        extends BaseService<CarParkOccupancySingleResponse> {

    @DeserialiseAs
    private CarParkOccupancy carParkOccupancy;

    @Step
    public CarParkOccupancy getCPO() {
        return carParkOccupancy;
    }

    @Step
    public int getNumFreeSpaces() {
        return Arrays.stream(carParkOccupancy.bays)
                .mapToInt(bay -> bay.free)
                .sum();
    }
}
