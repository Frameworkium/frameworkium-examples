package restfulbooker.api.service.ping;

import restfulbooker.api.constant.BookerEndpoint;
import restfulbooker.api.service.AbstractBookerService;
import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class PingService extends AbstractBookerService {

    public String ping() {
        return get(BookerEndpoint.PING.getUrl())
                .body().asString();
    }

    /**
     * Used in template method {@link AbstractBookerService#get(String)}
     */
    @Override
    protected ResponseSpecification getResponseSpec() {
        return RestAssured.expect().response()
                .statusCode(HttpStatus.SC_CREATED);
    }
}
