package punk.api.service;


import com.frameworkium.core.api.services.BaseService;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import punk.api.constant.BrewdogEndpoint;

import java.util.List;

/** Base Service for RestfulBooker specific services. */
public abstract class AbstractBrewdogService extends BaseService {

    /**
     * @return a Rest Assured {@link RequestSpecification} with the baseUri
     *         (and anything else required by most Capture services).
     */
    @Override
    protected RequestSpecification getRequestSpec() {
        return RestAssured.given()
                .baseUri(BrewdogEndpoint.BASE_URI.getUrl())
                .relaxedHTTPSValidation() // trusts even invalid certs
                // .log().all() // uncomment to log each request
                .contentType("application/json")
                .accept("application/json");
    }

    /**
     * @return a Rest Assured {@link ResponseSpecification} with basic checks
     *         (and anything else required by most services).
     */
    @Override
    protected ResponseSpecification getResponseSpec() {
        return RestAssured.expect().response()
                .statusCode(HttpStatus.SC_OK);
    }
    protected ExtractableResponse get(String url) {
       return getRequestSpec()
                .log().all()
                .when()
                .get(url)
                .then()
                .log().everything()
                .extract();
    }
    protected int getBeerById(int id) {
        List<Integer> response = get(BrewdogEndpoint.BEER_ID.getUrl(id)).path("id");
        return response.stream().findFirst().get();
    }
}
