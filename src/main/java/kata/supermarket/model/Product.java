package kata.supermarket.model;

import kata.supermarket.scale.Item;
import kata.supermarket.scale.ItemByUnit;

import java.math.BigDecimal;

public class Product {

    private final String name;

    private final BigDecimal pricePerUnit;

    public Product(final String name, final BigDecimal pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    public BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public String name(){
        return name;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }
}
