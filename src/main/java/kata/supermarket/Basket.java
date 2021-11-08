package kata.supermarket;

import kata.supermarket.calculator.TotalCalculator;
import kata.supermarket.calculator.TotalCalculatorImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    private final List<Item> items;

    private TotalCalculator totalCalculator; //When Spring is used we can autowire this component using @Autowire

    public Basket() {
        this.items = new ArrayList<>();
        this.totalCalculator = new TotalCalculatorImpl();
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        return this.totalCalculator.calculate(items());
    }

}
