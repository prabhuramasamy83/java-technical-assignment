package kata.supermarket.calculator;

import kata.supermarket.scale.Item;
import kata.supermarket.scheme.BuyOneGetOneDiscount;

import java.math.BigDecimal;
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
        totalDiscount = totalDiscount.add(BuyOneGetOneDiscount.calculateBuyOneGetOneDiscount(items));
        return totalDiscount;
    }

    @Override
    public BigDecimal calculate(final List<Item> items) {
        return subtotal(items).subtract(discounts(items));
    }
}
