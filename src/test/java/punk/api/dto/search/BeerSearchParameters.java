package punk.api.dto.search;

import java.util.*;

public class BeerSearchParameters {

    public long abv_gt;
    public long abv_lt;
    public long ibu_gt;
    public long ibu_lt;
    public long ebc_gt;
    public long ebc_lt;
    public String beer_name;
    public String yeast;
    public Date brewed_before;
    public Date brewed_after;
    public String hops;
    public String malt;
    public String food;
    public String ids;

    public static String SearchBuilder(BeerSearchParameters params)
    {
        StringBuilder builder = new StringBuilder();
            if(params.abv_gt != 0)
                builder.append("abv_gt=").append(params.abv_gt);

            return builder.toString();
    }
}
