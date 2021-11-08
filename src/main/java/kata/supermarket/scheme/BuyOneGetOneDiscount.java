package kata.supermarket.scheme;

import kata.supermarket.constant.ProductNames;
import kata.supermarket.scale.Item;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuyOneGetOneDiscount {

    private static List<String> listOfItems = Arrays.asList(ProductNames.IceCream.name(), ProductNames.Milk.name()); //This list can come from dynamic sources like database

    public static BigDecimal calculateBuyOneGetOneDiscount(List<Item> items) {
        BigDecimal buyOneGetOneDiscount = BigDecimal.ZERO;
        Set<String> processedItems = new HashSet<>();
        for(Item basketItem: items){
            if(listOfItems.contains(basketItem.name()) && !processedItems.contains(basketItem.name())){
                long noOfItems = items.stream().filter(item -> item.name().equals(basketItem.name())).count();
                if(noOfItems >1){
                    MathContext roundingMode = new MathContext(4);
                    BigDecimal itemPrice = items.stream().filter(item -> item.name().equals(basketItem.name())).findFirst().get().price();
                    buyOneGetOneDiscount = buyOneGetOneDiscount.add(itemPrice.multiply(new BigDecimal(noOfItems/2), roundingMode));
                }
            }
            processedItems.add(basketItem.name());
        }
        return buyOneGetOneDiscount;
    }
}
