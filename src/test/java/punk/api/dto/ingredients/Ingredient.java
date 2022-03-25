package punk.api.dto.ingredients;

import com.fasterxml.jackson.annotation.JsonProperty;
import punk.api.dto.units.Amount;

public class Ingredient {
    @JsonProperty("name")
    String name;
    @JsonProperty("amount")
    Amount amount;
    @JsonProperty("add")
    String add;
    @JsonProperty("attribute")
    String attribute;
}
