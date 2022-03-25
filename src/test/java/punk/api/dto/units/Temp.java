package punk.api.dto.units;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temp {

    @JsonProperty("value")
    public String value;
    @JsonProperty("unit")
    public String unit;
}
