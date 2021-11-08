package kata.supermarket.calculator;

import kata.supermarket.scale.Item;

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

    private BigDecimal discounts() {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal calculate(final List<Item> items) {
        return subtotal(items).subtract(discounts());
    }
}
