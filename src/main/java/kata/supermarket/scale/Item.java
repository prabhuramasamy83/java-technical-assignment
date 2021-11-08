package kata.supermarket.scale;

import java.math.BigDecimal;

public interface Item {
    /**
     * Item price
     * @return
     */
    BigDecimal price();

    /**
     * Item name
     * @return
     */
    String name();
}
