package punk.api.dto;

import com.frameworkium.core.api.dto.AbstractDTO;
import punk.api.dto.ingredients.Ingredients;
import punk.api.dto.process.Method;
import punk.api.dto.units.BoilVolume;
import punk.api.dto.units.Volume;

import java.util.Date;
import java.util.List;

public class Beer extends AbstractDTO<Beer> {

    public int id;
    public String name;
    public String tagline;
    public String first_brewed;
    public String description;
    public String image_url;
    public Double abv;
    public Double ibu;
    public long target_fg;
    public long target_og;
    public Double ebc;
    public Double srm;
    public Double ph;
    public Double attenuation_level;
    public Volume volume;
    public BoilVolume boil_volume;
    public Method method;
    public Ingredients ingredients;
    public List<String> food_pairing;
    public String brewers_tips;
    public String contributed_by;

}


