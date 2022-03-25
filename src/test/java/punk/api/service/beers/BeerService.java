package punk.api.service.beers;

import io.restassured.response.ExtractableResponse;
import punk.api.constant.BrewdogEndpoint;
import punk.api.dto.Beer;
import punk.api.dto.Beers;
import punk.api.dto.search.BeerSearchParameters;
import punk.api.service.AbstractBrewdogService;

import java.util.List;

public class BeerService extends AbstractBrewdogService {

    public Beers getBeer(String name) {
        return get(BrewdogEndpoint.PARAMS.getUrl(name))
                .as(Beers.class);
    }

    public Beers getBeers() {
        return new Beers(get(BrewdogEndpoint.BASE_URI.getUrl()).as(Beer[].class));
    }

    public Beers getRandomBeer() {
        return new Beers(get(BrewdogEndpoint.RANDOM.getUrl()).as(Beer[].class));
    }

    public Beers getBeer(int id) {
        return new Beers(get(BrewdogEndpoint.BEER_ID.getUrl(id)).as(Beer[].class));
    }

    public Beers findBeer(BeerSearchParameters params) {
        return new Beers(get(BrewdogEndpoint.PARAMS.getUrl(BeerSearchParameters.SearchBuilder(params))).as(Beer[].class));
    }
}
