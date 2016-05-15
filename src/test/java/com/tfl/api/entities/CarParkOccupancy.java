package com.tfl.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarParkOccupancy {
    public String id;
    public Bay[] bays;
    public String name;

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    public boolean equalsIgnoringBayDetails(Object obj) {
        CarParkOccupancy other = (CarParkOccupancy) obj;
        return EqualsBuilder.reflectionEquals(this, other, "bays")
                && bays.length == other.bays.length;
    }
}
