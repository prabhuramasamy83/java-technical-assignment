package kata.supermarket.calculator;

import kata.supermarket.constant.ProductNames;
import kata.supermarket.scale.Item;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class TotalCalculatorImpl implements TotalCalculator{

    private BigDecimal subtotal(final List<Item> items) {
        return items.stream().map(Item::price)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal discounts(final List<Item> items) {
        BigDecimal totalDiscount = BigDecimal.ZERO;
        totalDiscount.add(calculateBuyOneGetOneDiscount(items));
        return totalDiscount;
    }

    private BigDecimal calculateBuyOneGetOneDiscount(List<Item> items) {
        String itemName = ProductNames.IceCream.name();
        long noOfItems = items.stream().filter(item -> item.name().equals(itemName)).count();
        MathContext roundingMode = new MathContext(4);
        BigDecimal itemPrice = items.stream().filter(item -> item.name().equals(itemName)).findFirst().get().price();
        BigDecimal buyOneGetOneDiscount = itemPrice.multiply(new BigDecimal(noOfItems/2), roundingMode);
        return buyOneGetOneDiscount;
    }


    @Override
    public BigDecimal calculate(final List<Item> items) {
        return subtotal(items).subtract(discounts(items));
    }
}
