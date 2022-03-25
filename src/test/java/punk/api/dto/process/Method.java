package punk.api.dto.process;

import com.fasterxml.jackson.annotation.JsonProperty;
import punk.api.dto.units.MashTemp;

import java.util.List;

public class Method {

    @JsonProperty("mash_temp")
    List<MashTemp> mash_temp;
    @JsonProperty("fermentation")
    Fermentation fermentation;
    @JsonProperty("twist")
    String twist;
}
