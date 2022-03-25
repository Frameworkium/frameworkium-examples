package punk.api.dto.units;

import com.fasterxml.jackson.annotation.JsonProperty;
import punk.api.dto.units.Temp;


public class MashTemp {

    @JsonProperty("temp")
    Temp temp;
    @JsonProperty("duration")
    String duration;

}

