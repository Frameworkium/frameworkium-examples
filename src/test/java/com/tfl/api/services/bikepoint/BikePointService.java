package com.tfl.api.services.bikepoint;

import com.frameworkium.core.api.services.BaseService;
import com.frameworkium.core.api.services.ServiceFactory;

import java.util.Collections;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public interface BikePointService {

    static <T extends BaseService<T>> T newInstance(Class<T> serviceClass) {
        return newInstance(serviceClass, Collections.emptyMap());
    }

    static <T extends BaseService<T>> T newInstance(
            Class<T> serviceClass, Map<String, String> params) {

        return ServiceFactory.newInstance(
                serviceClass,
                "http://api.tfl.gov.uk/BikePoint",
                given().parameters(params));
    }

}
