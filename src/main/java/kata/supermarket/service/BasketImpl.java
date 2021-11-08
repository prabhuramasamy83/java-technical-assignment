package kata.supermarket.service;

import kata.supermarket.calculator.TotalCalculator;
import kata.supermarket.calculator.TotalCalculatorImpl;
import kata.supermarket.scale.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasketImpl implements Basket{

    private final List<Item> items;

    private TotalCalculator totalCalculator = new TotalCalculatorImpl(); //In Spring this could be autowired using @Autowired annotation

    public BasketImpl() {
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(final Item item) {
        this.items.add(item);
    }

    @Override
    public List<Item> listItems() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public BigDecimal total() {
        return totalCalculator.calculate(listItems());
    }
}
