/**
 * Goods Class
 * 
 * This class defines a list of goods types that can be handled by delivery agents
 * in the Delivery Agent Management System. It provides functionality to validate
 * goods types and retrieve all available types.
 * 
 * Author: OOP GROUP 7 
 * Date: 10/19/2024
 */

import java.util.Arrays;
import java.util.List;
 
public class GoodsType {
     private final List<String> goodsTypes = Arrays.asList("Food", "Medicine", "Furniture", "Livestock", "Clothing", 
                                                                "Jewelry", "Tech Products", "Games", "Customized Products", "Toys");
 
    public boolean isValidGoodsType(String goodsType, boolean ignoreCase) {
        if (ignoreCase) {
            return goodsTypes.stream().map(String::toLowerCase).anyMatch(type -> type.equals(goodsType.toLowerCase()));
        } 
        else 
        {
            return goodsTypes.contains(goodsType);
        }
    }

    public List<String> getAllGoodsTypes() {
        return goodsTypes;
    }
} 
