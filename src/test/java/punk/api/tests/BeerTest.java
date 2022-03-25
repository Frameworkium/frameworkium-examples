package punk.api.tests;

import com.frameworkium.core.api.tests.BaseAPITest;
import org.testng.Assert;
import org.testng.annotations.Test;
import punk.api.dto.Beer;
import punk.api.dto.Beers;
import punk.api.dto.search.BeerSearchParameters;
import punk.api.service.beers.BeerService;

import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Test()
public class BeerTest extends BaseAPITest {


    public void get_all_beers() {
        var service = new BeerService();
        Beers beers = service.getBeers();
        Assert.assertTrue(beers.beer.size() > 1, "There are no more beers left");
    }

    public void get_random_beer() {
        var service = new BeerService();
        Beers beers = service.getRandomBeer();
        Assert.assertEquals(beers.beer.size(),  1, "More than one beer returned");
    }

    public void get_beer_id() {
        var random = ThreadLocalRandom.current();
        var service = new BeerService();
        int randInt = random.nextInt(service.getBeers().beer.size());
        Beers beers = service.getBeer(randInt);
        Assert.assertEquals(beers.beer.stream().findFirst().get().id,  randInt, "The wrong beer returned");
    }

    public void get_strong_beer() {
        var service = new BeerService();
        BeerSearchParameters searchParameters = new BeerSearchParameters();
        int percentage = 10;
        searchParameters.abv_gt = percentage;
        Beers beers = service.findBeer(searchParameters);
        beers.beer.forEach(beer -> Assert.assertTrue(beer.abv >= percentage, "Beer " + beer.name + " is not abv " +percentage));
    }

}
