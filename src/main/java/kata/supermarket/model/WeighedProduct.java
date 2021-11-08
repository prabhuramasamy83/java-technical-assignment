package kata.supermarket.model;

import kata.supermarket.scale.Item;
import kata.supermarket.scale.ItemByWeight;

import java.math.BigDecimal;

public class WeighedProduct {

    private final String name;

    private final BigDecimal pricePerKilo;

    public WeighedProduct(final String name, final BigDecimal pricePerKilo) {
        this.name = name;
        this.pricePerKilo = pricePerKilo;
    }

    public BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public String name(){
        return name;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }
}
