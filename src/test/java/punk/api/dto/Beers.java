package punk.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONPropertyIgnore;

import java.util.Arrays;
import java.util.List;

public class Beers {
    public List<Beer> beer;

    public Beers(Beer[] beers)
    {
        beer = Arrays.asList(beers);
    }
}
