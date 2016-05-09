package com.tfl.api.services.carparkoccupancy;

import com.frameworkium.core.api.annotations.DeserialiseAs;
import com.frameworkium.core.api.services.BaseService;
import com.tfl.api.entities.Bay;
import com.tfl.api.entities.CarParkOccupancy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class CarParkOccupancyResponse extends BaseService<CarParkOccupancyResponse> {

    @DeserialiseAs
    private CarParkOccupancy[] carParkOccupancies;

    @Step
    public CarParkOccupancy[] getAll() {
        return carParkOccupancies;
    }

    @Step
    public List<String> getNames() {
        return stream(carParkOccupancies)      // create a Stream of the CPO array
                .map(cpo -> cpo.name)          // get the name
                .collect(Collectors.toList()); // collect the stream to a List
    }

    @Step
    public Integer getTotalNumSpaces() {
        return getSumFromBays(bay -> bay.bayCount);
    }

    @Step
    public Integer getTotalNumFreeSpaces() {
        return getSumFromBays(bay -> bay.free);
    }

    @Step
    public Integer getTotalNumOccupiedSpaces() {
        return getSumFromBays(bay -> bay.occupied);
    }

    private int getSumFromBays(ToIntFunction<Bay> bayToIntFunction) {
        return stream(carParkOccupancies)         // create a Stream of the CPO array
                .flatMap(cpo -> stream(cpo.bays)) // create a single Stream of Bays from each list of Bays in each CPO
                .mapToInt(bayToIntFunction)       // get the number of something from bays
                .sum();
    }
}
