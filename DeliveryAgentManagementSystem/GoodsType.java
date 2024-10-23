/**
 * GoodsType Class
 * 
 * This class defines and manages the list of goods types that delivery agents 
 * in the Delivery Agent Management System can handle. It provides methods to:
 * - Validate whether a given goods type is valid, with an option for case-insensitive matching.
 * - Retrieve the list of all available goods types.
 * 
 * The goods types included are: Food, Medicine, Furniture, Livestock, Clothing, Jewelry, 
 * Tech Products, Games, Customized Products, and Toys.
 * 
 * Author: OOP GROUP 7
 * Date: 10/19/2024
 */

import java.util.Arrays;
import java.util.List;
 
public class GoodsType 
{
     private final List<String> goodsTypes = Arrays.asList("Food", "Medicine", "Furniture", "Livestock", "Clothing", 
                                                                "Jewelry", "Tech Products", "Games", "Customized Products", "Toys");
 
    public boolean isValidGoodsType(String goodsType, boolean ignoreCase) 
    {
        if (ignoreCase) 
        {
            return goodsTypes.stream().map(String::toLowerCase).anyMatch(type -> type.equals(goodsType.toLowerCase()));
        } 
        else 
        {
            return goodsTypes.contains(goodsType);
        }
    }

    public List<String> getAllGoodsTypes() 
    {
        return goodsTypes;
    }
} 
