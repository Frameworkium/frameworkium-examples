package com.tfl.api.services.journeyPlanner;

import com.frameworkium.core.api.services.BaseService;
import com.frameworkium.core.api.services.ServiceFactory;

import java.util.Collections;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public interface JourneyPlannerService {

    static <T extends BaseService<T>> T newInstance(
            String from, String to, Class<T> serviceClass) {
        return newInstance(from, to, Collections.emptyMap(), serviceClass);
    }

    static <T extends BaseService<T>> T newInstance(
            String from, String to, Map<String, String> params, Class<T> serviceClass) {

        return ServiceFactory.newInstance(
                serviceClass,
                String.format("http://api.tfl.gov.uk/Journey/JourneyResults/%s/to/%s", from, to),
                given().parameters(params));
    }
}
