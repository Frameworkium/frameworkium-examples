package punk.api.dto.ingredients;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Ingredients {
    @JsonProperty("malt")
    List<Ingredient> malt;
    @JsonProperty("hops")
    List<Ingredient> hops;
    @JsonProperty("yeast")
    String yeast;

}
