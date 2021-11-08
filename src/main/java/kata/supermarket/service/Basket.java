package kata.supermarket.service;

import kata.supermarket.scale.Item;

import java.math.BigDecimal;
import java.util.List;

public interface Basket {

    void addItem(final Item item);

    List<Item> listItems();

    BigDecimal total();
}
