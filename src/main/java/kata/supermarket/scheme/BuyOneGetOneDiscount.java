package kata.supermarket.scheme;

import kata.supermarket.constant.ProductNames;
import kata.supermarket.scale.Item;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class BuyOneGetOneDiscount {

    public static BigDecimal calculateBuyOneGetOneDiscount(List<Item> items) {
        String itemName = ProductNames.IceCream.name();
        BigDecimal buyOneGetOneDiscount = BigDecimal.ZERO;
        long noOfItems = items.stream().filter(item -> item.name().equals(itemName)).count();
        if(noOfItems >1){
            MathContext roundingMode = new MathContext(4);
            BigDecimal itemPrice = items.stream().filter(item -> item.name().equals(itemName)).findFirst().get().price();
            buyOneGetOneDiscount = itemPrice.multiply(new BigDecimal(noOfItems/2), roundingMode);
        }
        return buyOneGetOneDiscount;
    }
}
