package company.webspoon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oakinrele on Oct, 2020
 */
public class PriceCheck {

    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        // Write your code here

        int errors = 0;
        Map<String,Float> productPriceMap = new HashMap<>();

        for(int i = 0; i < products.size(); i++)
        {
            productPriceMap.put(products.get(i), productPrices.get(i));
        }

        for(int i = 0; i < productSold.size(); i++)
        {
            String currentProduct = productSold.get(i);
            Float currentProductPrice = soldPrice.get(i);

            if(!productPriceMap.get(currentProduct).equals(currentProductPrice))
            {
                errors++;
            }
        }

        return errors;
    }
}
