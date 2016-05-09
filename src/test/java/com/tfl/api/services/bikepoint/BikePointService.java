package com.tfl.api.services.bikepoint;

import com.frameworkium.core.api.services.BaseService;
import com.frameworkium.core.api.services.ServiceFactory;

import java.util.Collections;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public interface BikePointService {

    static <T extends BaseService<T>> T newInstance(Class<T> serviceClass) {
        return newInstance(Collections.emptyMap(), serviceClass);
    }

    static <T extends BaseService<T>> T newInstance(
            Map<String, String> params, Class<T> serviceClass) {

        return ServiceFactory.newInstance(
                serviceClass,
                "http://api.tfl.gov.uk/BikePoint",
                given().parameters(params));
    }

}
