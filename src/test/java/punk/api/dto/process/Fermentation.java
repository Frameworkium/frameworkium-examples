package punk.api.dto.process;

import com.fasterxml.jackson.annotation.JsonProperty;
import punk.api.dto.units.Temp;

public class Fermentation {

    @JsonProperty("temp")
    Temp temp;
}
