package kata.supermarket.calculator;

import kata.supermarket.scale.Item;

import java.math.BigDecimal;
import java.util.List;

public interface TotalCalculator {

    /**
     * Calculate the total cost of the items present in the basket
     * @param items
     * @return
     */
    BigDecimal calculate(final List<Item> items);
}
