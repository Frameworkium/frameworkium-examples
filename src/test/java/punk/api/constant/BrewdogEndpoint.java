package punk.api.constant;

import com.frameworkium.core.api.Endpoint;

/** The various Endpoints of Restful Booker. */
public enum BrewdogEndpoint implements Endpoint {

    BASE_URI("https://api.punkapi.com/v2/beers"),
    BEER_ID("/%d"),
    RANDOM( "/random"),
    PARAMS("?%s");

    private String url;

    BrewdogEndpoint(String url) {
        this.url = url;
    }

    /**
     * @param params Arguments referenced by the format specifiers in the url.
     * @return A formatted String representing the URL of the given constant.
     */
    @Override
    public String getUrl(Object... params) {
        return String.format(url, params);
    }

}
